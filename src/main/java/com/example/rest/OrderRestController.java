package com.example.rest;

import com.example.entity.Order;
import com.example.entity.OrderStatus;
import com.example.entity.User;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderRestController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(
            value = "api/orders",
            method = RequestMethod.GET,
            produces = {
                    "application/JSON"
            }
    )
    public Iterable<Order> getAllOrders() {
        Iterable<Order> orders = orderRepository.findAll();
        return orders;
    }

    @RequestMapping(
            value = "api/orders/pending",
            method = RequestMethod.GET,
            produces = {
                    "application/JSON"
            }
    )
    public Iterable<Order> getPendingOrders() {
        Iterable<Order> orders = orderRepository.findOrdersByStatus(OrderStatus.PENDING);
        return orders;
    }

    @RequestMapping(
            value = "api/orders/accepted",
            method = RequestMethod.GET,
            produces = {
                    "application/JSON"
            }
    )
    public Iterable<Order> getAcceptedOrders() {
        Iterable<Order> orders = orderRepository.findOrdersByStatus(OrderStatus.ACCEPTED);
        return orders;
    }

    @RequestMapping(
            value = "api/orders/denied",
            method = RequestMethod.GET,
            produces = {
                    "application/JSON"
            }
    )
    public Iterable<Order> getDeniedOrders() {
        Iterable<Order> orders = orderRepository.findOrdersByStatus(OrderStatus.DENIED);
        return orders;
    }

    @RequestMapping(
            value = "api/orders/completed",
            method = RequestMethod.GET,
            produces = {
                    "application/JSON"
            }
    )
    public Iterable<Order> getCompletedOrders() {
        Iterable<Order> orders = orderRepository.findOrdersByStatus(OrderStatus.COMPLETED);
        return orders;
    }


    @RequestMapping(
            value = "api/order/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/JSON"
            }
    )
    public Iterable<Order> getOrder(@PathVariable("id") int id) {
        Optional<User> user = userRepository.findById(id);
        Iterable<Order> orders = orderRepository.findByUser(user);
        return orders;
    }


}
