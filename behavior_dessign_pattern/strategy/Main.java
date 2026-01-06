package behavior_dessign_pattern.strategy;

public class Main {

    public static void main(String [] args){
        Payment payment = new UPI("73386");
        Payment payment2 = new DebitCard("733", 273848282727L);
        PaymentGateWay paymentGateWay = new PaymentGateWay(payment);
        paymentGateWay.proceed();
        PaymentGateWay paymentGateWay2 = new PaymentGateWay(payment2);
        paymentGateWay2.proceed();
    }
}
