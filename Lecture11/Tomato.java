package Lecture11;

import java.util.List;

import Lecture11.factory.NewOrderFactory;
import Lecture11.factory.OrderFactory;
import Lecture11.factory.ScheduleOrderFactory;
import Lecture11.manager.OrderManager;
import Lecture11.manager.RestaurantManager;
import Lecture11.model.Cart;
import Lecture11.model.MenuItem;
import Lecture11.model.Order;
import Lecture11.model.Restaurant;
import Lecture11.model.User;
import Lecture11.stratiegies.PaymentStrategies;

public class Tomato {
    
    public Tomato() {
        initializeRestaurants();
    }

    public void initializeRestaurants() {
        Restaurant restaurant1 = new Restaurant("Bikaner", "Delhi");
        restaurant1.setMenuItems(new MenuItem("P1", "Chole Bhature", 120));
        restaurant1.setMenuItems(new MenuItem("P2", "Samosa", 15));

        Restaurant restaurant2 = new Restaurant("Haldiram", "Kolkata");
        restaurant2.setMenuItems(new MenuItem("P1", "Raj Kachori", 80));
        restaurant2.setMenuItems(new MenuItem("P2", "Pav Bhaji", 100));
        restaurant2.setMenuItems(new MenuItem("P3", "Dhokla", 50));

        Restaurant restaurant3 = new Restaurant("Saravana Bhavan", "Chennai");
        restaurant3.setMenuItems(new MenuItem("P1", "Masala Dosa", 90));
        restaurant3.setMenuItems(new MenuItem("P2", "Idli Vada", 60));
        restaurant3.setMenuItems(new MenuItem("P3", "Filter Coffee", 30));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);
    }

    public List<Restaurant> searchRestaurantBylocation(String location) {
       return RestaurantManager.getInstance().searchRestaurantsByLocation(location);
    }
       public void selectRestaurant(User user, Restaurant restaurant) {
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }

    public void addToCart(User user, String itemCode) {
        Restaurant restaurant = user.getCart().getRestaurant();
        if (restaurant == null) {
            System.out.println("Please select a restaurant first.");
            return;
        }
        for (MenuItem item : restaurant.getMenuItems()) {
            if (item.getId().equals(itemCode)) {
                user.getCart().addItem(item);
                break;
            }
        }
    }
     public Order checkoutNow(User user, String orderType, PaymentStrategies paymentStrategy) {
        return checkout(user, orderType, paymentStrategy, new NewOrderFactory());
    }
    public Order checkoutScheduled(User user, String orderType, PaymentStrategies paymentStrategy, String scheduleTime) {
        return checkout(user, orderType, paymentStrategy, new ScheduleOrderFactory(scheduleTime));
    }

    public Order checkout(User user, String orderType, PaymentStrategies paymentStrategy, OrderFactory orderFactory) {
        if (user.getCart().isEmpty()) return null;

        Cart userCart = user.getCart();
        Restaurant orderedRestaurant = userCart.getRestaurant();
        List<MenuItem> itemsOrdered = userCart.getItems();
        double totalCost = userCart.getTotalPrice();

        Order order = orderFactory.createOrder(user, userCart, orderedRestaurant, itemsOrdered, paymentStrategy, totalCost, orderType);
        OrderManager.getInstance().addOrder(order);
        return order;
    }
public void payForOrder(User user, Order order) {
        boolean isPaymentSuccess = order.processPayment();

        if (isPaymentSuccess) {
            // NotificationService.notify(order);
            user.getCart().removeItem();
        }
    }
    public void printUserCart(User user) {
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getCart().getItems()) {
            System.out.println(item.getId() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : ₹" + user.getCart().getTotalPrice());
    }
}
