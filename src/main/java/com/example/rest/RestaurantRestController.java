package com.example.rest;

import com.example.dto.RestarauntDto;
import com.example.entity.Menu;
import com.example.entity.Restaurant;
import com.example.entity.User;
import com.example.exceptions.RestaurantNotFoundException;
import com.example.repository.RestaurantRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin
public class RestaurantRestController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(
            value = "api/restaurants",
            method = RequestMethod.GET,
            produces = {
                    "application/json"
            }
    )
    public List<RestarauntDto> getRestaurants() {
        Iterable<Restaurant> restaurants = restaurantRepository.findAll();
        return StreamSupport.stream(restaurants.spliterator(), false)
                .map(restaurantEntity -> {
                    RestarauntDto restarauntDto = new RestarauntDto();
                    restarauntDto.setId(restaurantEntity.getId());
                    restarauntDto.setRestaurantName(restaurantEntity.getRestaurantName());
                    restarauntDto.setDescription(restaurantEntity.getDescription());
                    return restarauntDto;
                })
                .collect(Collectors.toList());
    }

    @RequestMapping(
            value = "api/restaurants/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/json"
            }
    )
    public RestarauntDto getRestaurant(@PathVariable("id") int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isPresent()) {
            Restaurant restaurantEntity = restaurant.get();
            RestarauntDto restarauntDto = new RestarauntDto();
            restarauntDto.setId(restaurantEntity.getId());
            restarauntDto.setRestaurantName(restaurantEntity.getRestaurantName());
            restarauntDto.setDescription(restaurantEntity.getDescription());
            return restarauntDto;
        }
        else {
            throw new RestaurantNotFoundException("restaurant does not exist");
        }
    }

    @RequestMapping(
            value = "api/manager-restaurant/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/json"
            }
    )
    public Optional<Restaurant> getManagerRestaurant(@PathVariable("id") int id) {
        Optional<User> user = userRepository.findById(id);
        Optional<Restaurant> restaurant = restaurantRepository.findRestaurantByManager(user);
        return restaurant;
    }

}
