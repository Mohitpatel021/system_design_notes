package Lecture11.model;

import java.util.List;

import Lecture11.stratiegies.PaymentStrategies;

public abstract class Order {
    public static int nextOrderId = 0;
    private int orderId;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private PaymentStrategies paymentStrategy;
    private User user;
    private Double totalPrice;
    private String schedulingTime;
    public abstract String getType();
public Order() {
        this.user = null;
        this.restaurant = null;
        this.paymentStrategy = null;
        this.totalPrice = 0.0;
        this.schedulingTime = "";
        this.orderId = ++nextOrderId;
    }

    public boolean processPayment(){
        if(paymentStrategy != null){
            paymentStrategy.pay(totalPrice);
            return true;
        }else{
            System.out.println("Please Select Payment Mode first.");
            return false;
        }
    }


    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public List<MenuItem> getItems() {
        return items;
    }
   public void setItems(List<MenuItem> its) {
        items = its;
        totalPrice = 0D;
        for (MenuItem i : items) {
            totalPrice += i.getPrice();
        }
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSchedulingTime() {
        return schedulingTime;
    }

    public void setSchedulingTime(String schedulingTime) {
        this.schedulingTime = schedulingTime;
    }
    public PaymentStrategies getPaymentStrategy() {
        return paymentStrategy;
    }
    public void setPaymentStrategy(PaymentStrategies paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    

    
}
