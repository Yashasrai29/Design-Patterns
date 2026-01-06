package behavior_dessign_pattern.strategy;

public class PaymentGateWay {

    private Payment payment;

    public PaymentGateWay(Payment payment){
        this.payment = payment;
    }
    public void proceed(){
        payment.pay();
    }
}
