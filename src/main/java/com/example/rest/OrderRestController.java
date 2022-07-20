package com.example.rest;

import com.example.entity.Menu;
import com.example.entity.Order;
import com.example.entity.OrderStatus;
import com.example.entity.User;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class OrderRestController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderService orderService;

    OrderRestController(OrderRepository orderRepository, UserRepository userRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderService = orderService;
    }

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
            value = "api/orders/courier/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/json"
            }
    )
    public Iterable<Order> getCourierAcceptedOrders(@PathVariable("id") int id) {
        Iterable<Order> courierOrders = orderRepository.findByCourierId(id);

        return courierOrders;
    }

    @RequestMapping(
            value = "api/orders/courier-completed/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/json"
            }
    )
    public Iterable<Order> getCourierCompletedOrders(@PathVariable("id") int id) {
        Iterable<Order> courierOrders = orderRepository.findByCourierIdCompleted(id);

        return courierOrders;
    }

    @RequestMapping(
            value = "api/orders/manager/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/JSON"
            }
    )
    public Iterable<Order> getManagerOrders(@PathVariable("id") int id) {
        Iterable<Order> orders = orderRepository.findOrdersByStatus(OrderStatus.ACCEPTED);

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

    @RequestMapping(
            value = "change-status/{id}",
            method = RequestMethod.PATCH
    )
    public void approveOrder(
            @PathVariable("id") int id,
            @RequestBody Order order
    ) {
        orderService.setOrderStatus(id, order);
    }

    @RequestMapping(
            value = "add-new-order",
            method = RequestMethod.POST,
            consumes = {"application/json"}
    )
    public void addNewOrder(
            @RequestBody Order order
    ) {
        orderService.addOrder(order);
    }


}
