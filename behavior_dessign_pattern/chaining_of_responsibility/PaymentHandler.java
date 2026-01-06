package behavior_dessign_pattern.chaining_of_responsibility;

public abstract class PaymentHandler {

    protected PaymentHandler handler;

    public void setPaymentHandler(PaymentHandler paymentHandler){
        this.handler = paymentHandler;
    }

    public abstract void handlePayment(double amount);
}
