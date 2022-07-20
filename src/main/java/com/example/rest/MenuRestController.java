package com.example.rest;

import com.example.entity.Menu;
import com.example.entity.Restaurant;
import com.example.repository.MenuRepository;
import com.example.repository.RestaurantRepository;
import com.example.repository.UserRepository;
import com.example.service.MenuService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@CrossOrigin
public class MenuRestController {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuService menuService;

    public MenuRestController(MenuRepository menuRepository, RestaurantRepository restaurantRepository, MenuService menuService) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuService = menuService;
    }

    @RequestMapping(
            value = "api/menu/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/JSON"
            }
    )
    public Optional<Menu> getMenu(@PathVariable("id") int id) {
        Optional<Menu> menu = menuRepository.findById(id);
        return menu;
    }

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

    @RequestMapping(
            value = "add-menu-item/{id}",
            method = RequestMethod.POST,
            consumes = {"application/json"}
    )
    public void addItem(
            @PathVariable("id") int id,
            @RequestBody Menu menu
    ) {
        menuService.addMenuItem(id, menu);
    }

    @RequestMapping(
            value = "edit-menu-item/{id}",
            method = RequestMethod.PATCH,
            consumes = {"application/json"}
    )
    public void editItem(
            @PathVariable("id") int id,
            @RequestBody Menu menu
    ) {
        menuService.editMenuItem(id, menu);
    }
}
