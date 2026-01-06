package behavior_dessign_pattern.chaining_of_responsibility;

public class CreditCardPaymentHandler extends PaymentHandler{
    @Override
    public void handlePayment(double amount) {
        if(amount <= 1000){
            System.out.println("processing the credit card payment of  "+amount);
        }
        else{
            handler.handlePayment(amount);
        }
    }

}
