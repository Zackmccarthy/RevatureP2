package com.example.service;

import com.example.entity.Order;

public interface OrderService {

    void setOrderToAccepted(int order_id, Order order);

    void setOrderToDenied(int order_id, Order order);

    void setOrderToCompleted(int order_id, Order order);
}
