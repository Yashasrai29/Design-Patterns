package behavior_dessign_pattern.strategy;

public class UPI implements Payment{

    private String upiID;

    public UPI(String virtualId){
        this.upiID = virtualId;
    }
    @Override
    public void pay() {
        System.out.println("performing payment using upi "+upiID);
    }
}
