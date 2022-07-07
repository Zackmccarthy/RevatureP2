package com.example.web;

import com.example.entity.Restaurant;
import com.example.repository.RestaurantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestaurantController {

    private RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/restaurants"
    )
    public ModelAndView getRestaurants() {
        Iterable<Restaurant> restaurants = restaurantRepository.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("all-restaurants", restaurants);
        mav.setViewName("restaurants-view");
        return mav;
    }
}
