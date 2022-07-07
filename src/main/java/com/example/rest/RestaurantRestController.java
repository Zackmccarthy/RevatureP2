package com.example.rest;

import com.example.entity.Restaurant;
import com.example.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RestaurantRestController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @RequestMapping(
            value = "api/restaurants",
            method = RequestMethod.GET,
            produces = {
                    "application/json"
            }
    )
    public Iterable<Restaurant> getRestaurants() {
        Iterable<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    @RequestMapping(
            value = "api/restaurants/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/json"
            }
    )
    public Optional<Restaurant> getRestaurant(@PathVariable("id") int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isPresent()) {
            return restaurant;
        }

        return restaurant;
    }
}
