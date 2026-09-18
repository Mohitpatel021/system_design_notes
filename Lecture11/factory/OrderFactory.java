package Lecture11.factory;

import java.util.List;

import Lecture11.model.Cart;
import Lecture11.model.MenuItem;
import Lecture11.model.Order;
import Lecture11.model.Restaurant;
import Lecture11.model.User;
import Lecture11.stratiegies.PaymentStrategies;

public interface OrderFactory {
    public Order createOrder(User user ,Cart cart,Restaurant restaurant,List<MenuItem> items,PaymentStrategies paymentStrategy,Double totalPrice,String orderType);

}
