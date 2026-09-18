package Lecture11.model;

public class Pickup extends Order {
    private String restaurantAddress;
    public Pickup() {
        this.restaurantAddress = "";
    }
    @Override
    public String getType() {
        return "Pickup";
    }
    public String getRestaurantAddress() {
        return restaurantAddress;
    }
    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }
    
    
}
