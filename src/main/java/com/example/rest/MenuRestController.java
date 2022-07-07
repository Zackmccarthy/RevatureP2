package com.example.rest;

import com.example.entity.Menu;
import com.example.entity.Restaurant;
import com.example.repository.MenuRepository;
import com.example.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

@RestController
public class MenuRestController {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @RequestMapping(
            value = "api/menus/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/JSON"
            }
    )
    public Iterable<Menu> getMenus(@PathVariable("id") int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        Iterable<Menu> menus = menuRepository.findByRestaurant(restaurant);
        return menus;
    }
}
