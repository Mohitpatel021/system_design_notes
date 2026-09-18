package Lecture11.stratiegies;

public class CardPayment implements PaymentStrategies {
    private String cardNumber;
    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(Double amount) {
        System.out.println("Paid " + amount + " using Card number: " + cardNumber);
    }
    
}
