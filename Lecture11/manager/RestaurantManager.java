package Lecture11.manager;

import java.util.ArrayList;
import java.util.List;

import Lecture11.model.Restaurant;
//singleton class to manage restaurants
public class RestaurantManager {
    List<Restaurant> restaurants=new ArrayList<>();
    private static RestaurantManager instance=null;
    private RestaurantManager() {}
    
    public static RestaurantManager getInstance() {
        if(instance==null) {
            instance=new RestaurantManager();
        }
        return instance;
    }
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
    public List<Restaurant> searchRestaurantsByLocation(String location) {
        List<Restaurant> result=new ArrayList<>();
        for(Restaurant restaurant:restaurants) {
            if(restaurant.getLocation().equalsIgnoreCase(location)) {
                result.add(restaurant);
            }
        }
        return result;
    }
}
