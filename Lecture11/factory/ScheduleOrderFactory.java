package Lecture11.factory;

import java.util.List;

import Lecture11.model.Cart;
import Lecture11.model.DeliveryType;
import Lecture11.model.MenuItem;
import Lecture11.model.Order;
import Lecture11.model.Pickup;
import Lecture11.model.Restaurant;
import Lecture11.model.User;
import Lecture11.stratiegies.PaymentStrategies;

public class ScheduleOrderFactory implements OrderFactory {
    private String schedulingTime;
    public ScheduleOrderFactory(String schedulingTime) {
        this.schedulingTime = schedulingTime;
    }

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> items, PaymentStrategies paymentStrategy, Double totalPrice, String orderType) {
        if (orderType.equalsIgnoreCase("Delivery")) {
            DeliveryType deliveryOrder = new DeliveryType();
            deliveryOrder.setUserAddress(user.getAddress());
            deliveryOrder.setSchedulingTime(schedulingTime);
            deliveryOrder.setRestaurant(restaurant);
            deliveryOrder.setItems(items);
            deliveryOrder.setPaymentStrategy(paymentStrategy);
            deliveryOrder.setTotalPrice(totalPrice);

            return deliveryOrder;
        } else if (orderType.equalsIgnoreCase("Pickup")) {
            Pickup pickupOrder = new Pickup();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            pickupOrder.setSchedulingTime(schedulingTime);
            pickupOrder.setRestaurant(restaurant);
            pickupOrder.setItems(items);
            pickupOrder.setPaymentStrategy(paymentStrategy);
            pickupOrder.setTotalPrice(totalPrice);
            
            return pickupOrder;
        } else {
            throw new IllegalArgumentException("Invalid order type: " + orderType);
        }
    }
    
}
