package com.example.service;

import com.example.entity.Order;

public interface OrderService {

    void setOrderStatus(int order_id, Order order);

    void addOrder(Order order);
}
