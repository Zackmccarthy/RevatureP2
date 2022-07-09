package com.example.repository;

import com.example.entity.Order;
import com.example.entity.Restaurant;
import com.example.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    @Query("SELECT r from restaurants r WHERE r.user = ?1")
    Optional<Restaurant> findRestaurantByManager(Optional<User> user);

}
