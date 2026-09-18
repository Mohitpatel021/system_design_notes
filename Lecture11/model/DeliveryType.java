package Lecture11.model;

public class DeliveryType extends Order {

    private String userAddress;
    public DeliveryType() {
        this.userAddress = "";
    }
    @Override
    public String getType() {
        return "Delivery";
    }
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    
    
}
