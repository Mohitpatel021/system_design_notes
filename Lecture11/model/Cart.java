package Lecture11.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private List<MenuItem> items= new ArrayList<>();
    public Cart() {
        this.restaurant =null;
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
    public List<MenuItem> addItem(MenuItem item) {
        items.add(item);
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Double getTotalPrice() {
        Double totalPrice = 0.0;
        for (MenuItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public List<MenuItem> removeItem() {
       items.clear();
       restaurant = null;
       return new ArrayList<>();
    }

}
