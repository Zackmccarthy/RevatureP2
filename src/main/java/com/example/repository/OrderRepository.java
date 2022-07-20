package com.example.repository;

import com.example.entity.Order;
import com.example.entity.OrderStatus;
import com.example.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.entity.OrderStatus;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Integer> {


    @Query("SELECT o from Order o WHERE o.user = ?1")
    List<Order> findByUser(Optional<User> user);

    @Query("SELECT o from Order o WHERE o.courier_id = ?1 AND o.orderStatus = 'ACCEPTED'")
    List<Order> findByCourierId(int courier_id);

    @Query("SELECT o from Order o WHERE o.orderStatus = ?1")
    List<Order> findOrdersByStatus(OrderStatus orderStatus);
}
