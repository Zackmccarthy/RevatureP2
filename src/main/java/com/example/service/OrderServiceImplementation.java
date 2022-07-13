package com.example.service;

import com.example.entity.Order;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void setOrderToAccepted(int order_id, Order order) {

        Optional<Order> newOrder = orderRepository.findById(order_id);
        newOrder.get().setOrderStatus(order.getOrderStatus());
        orderRepository.save(newOrder.get());
    }

    @Override
    public void setOrderToDenied(int order_id, Order order) {

    }

    @Override
    public void setOrderToCompleted(int order_id, Order order) {

    }
}
