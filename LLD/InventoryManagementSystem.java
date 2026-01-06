package LLD;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InventoryManagementSystem {

    public enum Category{
        APPAERL, ELECTRONICS, TOY, SHOE, FURNITURE, GROCERY, HOUSE_KITCHEN, OTHERS
    }
    public static abstract class Product{
        private String sku;
        private String name;

        private Integer quantity;

        private Double price;

        private String wareHouseId;

        private Category category;

        private int threshold;
        public Product(){

        }

        public void setThreshold(int threshold){
            this.threshold = threshold;
        }
        public void setCategory(Category category){
            this.category = category;
        }
        public void setSku(String sku){
            this.sku = sku;
        }
        public void setName(String name){
            this.name= name;
        }
        public void setPrice(double price){
            this.price = price;
        }

        public void setQuantity(int quantity){
            this.quantity = quantity;
        }

        public void setWareHouseId(String wareHouseId){
            this.wareHouseId = wareHouseId;
        }

    }

    public static class ApparelProduct extends Product{
        String color;

        String size;

        public ApparelProduct(String sku, String name, double price, int quantity, String wareHouseId, Category category, int threshold){
            super();
            setName(name);
            setSku(sku);
            setPrice(price);
            setQuantity(quantity);
            setWareHouseId(wareHouseId);
            setCategory(category);
            setThreshold(threshold);

        }

        public void setColor(String color){
            this.color = color;
        }

        public void setSize(String size){
            this.size = size;
        }
    }

    public static class User{
        String userId;
        String name;

        String email;
        String phone;

        Role role;

        public User(String userId, String name, String email, String phone, Role role){
            this.name = name;
            this.userId = userId;
            this.email = email;
            this.phone = phone;
            this.role = role;
        }

        public enum Role{
            ADMIN, USER
        }

    }

    public static class WareHouse{
        private String wareHouseId;

        private String name;

        private Map<String, Product> inventory;

        private String location;

        private User owner;

        public WareHouse(String wareHouseId, String location, User user, String name){
            this.wareHouseId = wareHouseId;
            this.location = location;
            this.owner = user;
            inventory = new HashMap<>();
            this.name = name;
        }
    }

    public static class InventorySystem{
        private static InventorySystem instance;

        private Map<String, WareHouse> wareHouses;

        private ProductFactory productFactory;

        private InventorySystem(){
            wareHouses = new HashMap<>();
            productFactory = new ProductFactory();
        }

        public static synchronized InventorySystem getInstance(){
            if(instance == null){
                synchronized(InventorySystem.class){
                    if (instance == null){
                        instance = new InventorySystem();
                    }
                }
            }
            return instance;
        }


    }

    public static class ProductFactory{
        public static Product createProduct(Category category, String sku, String name, double price, int quantity, String wareHouseId, int threshold){
            switch (category){
                case APPAERL -> {
                    return new ApparelProduct(sku, name, price, quantity, wareHouseId, category, threshold);
                }
                default -> {
                    throw new IllegalArgumentException("category not found");
                }
            }
        }
    }

    public static void main(String [] args){
        User admin = new User(UUID.randomUUID().toString(),"Admin", "admin@ims.com", "+917647647664", User.Role.ADMIN );
        User user1 = new User(UUID.randomUUID().toString(),"Yashas", "yashas@ims.com", "+91764735664", User.Role.USER );
        User user2 = new User(UUID.randomUUID().toString(),"Saleem", "saleem@ims.com", "+91763557664", User.Role.USER );

        InventorySystem inventorySystem = InventorySystem.getInstance();
        inventorySystem.wareHouses.put("warehouse-venkatapura-001", new WareHouse(UUID.randomUUID().toString(),"jakkasandra", admin,"warehouse-venkatapura-001"));
        inventorySystem.wareHouses.put("warehouse-madiwala-001", new WareHouse(UUID.randomUUID().toString(),"Madiwala", user1,"warehouse-hsr-001"));
        inventorySystem.wareHouses.put("warehouse-hsr-001", new WareHouse(UUID.randomUUID().toString(),"hsr", user2,"warehouse-hsr-001"));

        inventorySystem.wareHouses.get("warehouse-venkatapura-001").inventory.put("PUMA-SPORT-BLACK-10", inventorySystem.productFactory.createProduct(Category.APPAERL, "PUMA-SPORT-BLACK-10", "PUMA Running Shoes", 2500, 200, "warehouse-madiwala-001", 25));

        WareHouse wareHouse = inventorySystem.wareHouses.get("warehouse-madiwala-001");
//        inventorySystem.wareHouses.put("warehouse-madiwala-001", )
        Duration duration = Duration.between(LocalDateTime.now(), LocalDateTime.now().plusHours(5));
        duration.toHours();
        LocalDateTime l1 = LocalDateTime.now();
        LocalDate l2 = LocalDate.parse("2025-12-30", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if(LocalDateTime.of(l2, LocalTime.now()).isAfter(l1)){
            System.out.println("l2 is after l1");
        }
    }
}
