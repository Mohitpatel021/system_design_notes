package Lecture11.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int nextRestaurantId = 0;
    private int id;
    private String name;
    private String location;
    List<MenuItem> menuItems = new ArrayList<>();

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
        this.id = ++nextRestaurantId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    public void setMenuItems(MenuItem menuItems) {
        this.menuItems.add(menuItems);
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
}
