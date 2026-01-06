package behavior_dessign_pattern.chaining_of_responsibility;

public class BankPaymentHandler extends PaymentHandler{
    @Override
    public void handlePayment(double amount) {
        if(amount <= 500){
            System.out.println("processing the bank payment of  "+amount);
        }
        else{
            handler.handlePayment(amount);
        }
    }
}
