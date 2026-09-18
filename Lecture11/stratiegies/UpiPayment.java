package Lecture11.stratiegies;

public class UpiPayment implements PaymentStrategies {
    private String mobileNumber;

    public UpiPayment(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    @Override
    public void pay(Double amount) {
        System.out.println("Paid " + amount + " using mobile number: " + mobileNumber);
    }
    
}
