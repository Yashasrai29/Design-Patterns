package LLD;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static LLD.VendingMachineSystem.Category.BEVERAGES;
import static LLD.VendingMachineSystem.Category.SNACK;

public class VendingMachineSystem {

    public static class VendingMachine{

        static Map<String, Product> inventory;

        static ProductFactory productFactory;

        Boolean isActive = false;

        static {
            productFactory = new ProductFactory();
            inventory = new ConcurrentHashMap<>();
        }

        private static VendingMachine vendingMachine;

        public static synchronized VendingMachine getInstance(){
            if(vendingMachine == null){
                synchronized (VendingMachine.class){
                    if(vendingMachine == null){
                        vendingMachine = new VendingMachine();
                    }
                }
            }
            return vendingMachine;
        }

        public void addProducts(String sku, String name, Double price, Integer quantity, Category category, SubCategory subCategory, Optional<String> color){
            String colorOptional = color.orElse(null);
            Product product = productFactory.createProduct(sku, name, price, quantity, category, subCategory, colorOptional);
            this.isActive = true;
            inventory.put(name, product);
        }

        public List<Product> getProducts(){
            return inventory.values().stream().collect(Collectors.toList());
        }

        public boolean buy(int balance){
            Boolean flag = true;
            Scanner scanner = new Scanner(System.in);
            while(flag){
                System.out.println("Enter 1 to proceed 0 to exit");
                String control = scanner.nextLine();
                switch (control){
                    case "1":
                        System.out.println("Enter name with quantity in this format -> lays:2,hide-&-seek:1");
                        List<LineItem> lineItems = new ArrayList<>();
                        for(String each : scanner.nextLine().split(",")){
                            String [] item = each.split(":");
                            lineItems.add(new LineItem(item[0], Integer.parseInt(item[1])));
                        }
                        int total = process(lineItems);
                        System.out.println("the sub total : "+total);
                        System.out.println("Enter 1 to proceed 0 to exit ");
                        switch (scanner.nextLine()){
                            case "1":
                                System.out.println("Choose payment option 1 for UPI, 2 for DEBIT CARD with details comma seperated");
                                String payment = scanner.nextLine();
                                String paymentOption = payment.split(",")[0];
                                Payments option = null;
                                if(paymentOption.equals("1")){
                                    option = new UPI(payment.split(",")[1]);
                                }
                                else if(paymentOption.equals("2")){
                                    option = new DebitCard(payment.split(",")[1],payment.split(",")[2] );
                                }
                                else{
                                    throw new IllegalArgumentException("invalid selection");
                                }
                                boolean isValid = checkForPayment(total, balance, option);
                                if(!isValid){
                                    throw new RuntimeException("Insufficient Balance");
                                }
                                return completeTransaction(lineItems);
                            case "0":
                                return false;
                        }


                    case "0":
                        return false;
                }
            }
            return false;
        }

        public boolean completeTransaction(List<LineItem> lineItems) {
            for (LineItem item : lineItems) {
                if(!inventory.containsKey(item.name)){
                    throw new IllegalArgumentException("product name not fount "+item.name);
                }
                Product product = inventory.get(item.name);
                synchronized (product) {
                    product.quantity -= item.quantity;
                }
            }
            System.out.println("Successfully order item");
            return true;
        }
        public boolean checkForPayment(int total, int balance, Payments payments){
            return payments.proceedPayments(total, balance);
        }
//        sub total calculation
        public int process(List<LineItem> lineItems){
            int total = 0;
            for(LineItem item : lineItems){
                if(!inventory.containsKey(item.name)){
                    throw new IllegalArgumentException("product name not fount "+item.name);
                }
                Product product = inventory.get(item.name);
                if(item.quantity > product.quantity){
                    throw new RuntimeException("OUT of stock for "+item.name);
                }
                total += (product.price * item.quantity);
            }
            return total;
        }

        public interface Payments{
            boolean proceedPayments(int total, int balance);
        }

        public class UPI implements Payments{

            private String upiID;


            public UPI(String upiID){
                this.upiID = upiID;
            }
            @Override
            public boolean proceedPayments(int total, int balance) {
                System.out.println("UPI payment made by upiId "+upiID);
                return balance >= total;
            }
        }

        public class DebitCard implements Payments{

            private String cardNumber;

            private String cvv;

            public DebitCard(String cardNumber, String cvv){
                this.cardNumber = cardNumber;
                this.cvv = cvv;
            }
            @Override
            public boolean proceedPayments(int total, int balance) {

                System.out.println("Debit card payment made by upiId "+cardNumber);
//                here we can use third party payment provider to complete the payment transaction
                return balance >= total;
            }
        }



    }

    public static abstract class Product{
        String sku;
        String name;
        Double price;
        Integer quantity;

        public Product(String sku, String name, Double price, Integer quantity){
            this.sku = sku;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public String getSku(){
            return this.sku;
        }
    }

    public static class BeverageProduct extends Product{

        Category category;

        String color;
        public BeverageProduct(String sku, String name, Double price, Integer quantity, Category category, String color){
            super(sku, name, price, quantity);
            this.category = category;
            this.color = color;
        }
    }

    public static class SnackProduct extends Product{

        Category category;

        SubCategory subCategory;

        public SnackProduct(String sku, String name, Double price, Integer quantity, Category category, SubCategory subCategory){
            super(sku, name, price, quantity);
            this.category = category;
            this.subCategory = subCategory;
        }
    }

    public enum SubCategory{
        CHIPS, BISCUIT, BREAD, CAKE, OTHERS
    }
    public enum Category{
        BEVERAGES, SNACK, OTHERS
    }

    public static class ProductFactory{
        public Product createProduct(String sku, String name, Double price, Integer quantity, Category category, SubCategory subCategory, String color){
            switch(category){
                case SNACK -> {
                    return new SnackProduct(sku, name, price, quantity, category, subCategory);
                }
                case BEVERAGES -> {
                    return new BeverageProduct(sku, name, price, quantity, category, color);
                }
                default -> {
                    throw new IllegalArgumentException("Product this type not available");
                }
            }
        }

    }

    public static class LineItem{
        String name;
        int quantity;

        public LineItem(String name, int quantity){
            this.name = name;
            this.quantity = quantity;
        }
    }



    public static void main(String [] args){
        VendingMachine vm = VendingMachine.getInstance();
        vm.addProducts("LAYS-ONION-CHEESE-10", "lays", 10.0, 19, SNACK, SubCategory.CHIPS, Optional.empty());
        vm.addProducts("PARLEY-HIDE-&-SEEk-30", "hide-&-seek", 30.0, 5, SNACK, SubCategory.BISCUIT, Optional.empty());
        vm.addProducts("COCACOLA-ZERO-35", "cola", 35.0, 11, BEVERAGES, null, Optional.of("RED"));
        for( Product p : vm.getProducts()){
            System.out.println("name "+p.name+" price "+p.price+ " availableQuantity "+p.quantity);
        }
        vm.buy(100);
//        ServiceLoader<VendingMachine.Payments> loader = ServiceLoader.load(VendingMachine.Payments.class);
//        for (VendingMachine.Payments implementation : loader) {
//
//            System.out.println("each "+implementation.getClass());
//        }
    }


}
