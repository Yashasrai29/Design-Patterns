package behavior_dessign_pattern.strategy;

public class DebitCard implements Payment{

    private String cvv;

    private Long accountNumber;

    public DebitCard(String cvv, Long accountNumber){
        this.cvv = cvv;
        this.accountNumber = accountNumber;
    }
    @Override
    public void pay() {
        System.out.println("performing payment using debitcard for account "+accountNumber);
    }
}
