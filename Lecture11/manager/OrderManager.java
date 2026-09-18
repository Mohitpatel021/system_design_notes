package Lecture11.manager;

import java.util.ArrayList;
import java.util.List;

import Lecture11.model.Order;
//singleton class to manage orders
public class OrderManager {
    private List<Order> orders=new ArrayList<>();
    private static OrderManager orderManager=null;
    private OrderManager() {}

    public static OrderManager getInstance() {
        if(orderManager==null) {
            orderManager=new OrderManager();
        }
        return orderManager;
    }
    public void listOrders() {
        for(Order order:orders) {
            System.out.println("Order Id: "+order.getOrderId()+" Order Type: "+order.getType());
            System.out.println("Restaurant: "+order.getRestaurant().getName()+" Total Price: "+order.getTotalPrice());
        }
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
}
