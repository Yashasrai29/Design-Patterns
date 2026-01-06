package behavior_dessign_pattern.chaining_of_responsibility;

public class PaypalPaymentHandler extends PaymentHandler{
    @Override
    public void handlePayment(double amount) {
        if(amount <= 2000){
            System.out.println("processing the paypal payment of "+amount);
        }
        else{
            System.out.println("currently not able to process payment beyond 2000");
        }
    }
}
