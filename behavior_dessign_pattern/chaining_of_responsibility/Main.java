package behavior_dessign_pattern.chaining_of_responsibility;

public class Main {

    public static void main(String [] args){
        PaymentHandler bankHandler = new BankPaymentHandler();
        PaymentHandler creditCardHandler = new CreditCardPaymentHandler();
        PaymentHandler paypalHandler = new PaypalPaymentHandler();
        bankHandler.setPaymentHandler(creditCardHandler);
        creditCardHandler.setPaymentHandler(paypalHandler);
        bankHandler.handlePayment(1650);

    }
}
