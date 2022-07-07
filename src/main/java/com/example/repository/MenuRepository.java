package com.example.repository;

import com.example.entity.Menu;
import com.example.entity.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends PagingAndSortingRepository<Menu, Integer> {

    @Query("SELECT m FROM Menu m WHERE m.restaurant = ?1")
    List<Menu> findByRestaurant(Optional<Restaurant> restaurant);
}
