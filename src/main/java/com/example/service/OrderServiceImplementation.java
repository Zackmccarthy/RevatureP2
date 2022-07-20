package com.example.service;

import com.example.entity.*;
import com.example.repository.MenuRepository;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;

    OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void setOrderStatus(int order_id, Order order) {

        System.out.println("order" + order);
        System.out.println("order status" + order.getOrderStatus());

        Optional<Order> newOrder = orderRepository.findById(order_id);
        newOrder.get().setOrderStatus(order.getOrderStatus());
        newOrder.get().setCourier_id(order.getCourier_id());
        orderRepository.save(newOrder.get());
    }

    @Override
    public void addOrder(Order order) {

        System.out.println("order"+order);

        Order newOrder = new Order();
        newOrder.set_delivery(true);
        newOrder.setOrderStatus(OrderStatus.PENDING);
        newOrder.setPrice(order.getPrice());
        newOrder.setPayment_type(order.getPayment_type());

//        Menu menu = new Menu();
//        menu.setMenu_id(2);
//        Menu menu2 = new Menu();
//        menu2.setMenu_id(3);
//        List<Menu> menus = List.of(menu, menu2);
//        newOrder.setMenus(menus);

        List<Menu> menus = new ArrayList<>();
        for (int i = 0; i < order.getMenus().size(); i++) {
            Menu menu = new Menu();
            menu.setMenu_id(order.getMenus().get(i).getMenu_id());
            menus.add(menu);
        }
        newOrder.setMenus(menus);

        List<String> orders = new ArrayList<>();

//        Menu menu = new Menu();
//        Optional<User> user1 = userRepository.findById(id);
//        Iterable<Order> orders = orderRepository.findByUser(user);
//        Optional<Order> order1 = orderRepository.findById(order.getOrder_id());
//        menu.setMenu_id(order.getMenus());

//        List<Menu> menus = new ArrayList<>(order.getMenus());
//        List<Optional<Menu>> items = new ArrayList<>();
//        for (Menu menu : menus) {
//            Optional<Menu> item = menuRepository.findById(menu.getMenu_id());
//            item.get().setMenu_id(2);
//            items.add(item);
//        }
//        System.out.println("menu list" + menus);
//        System.out.println("item list" + items);

        User user = new User();
        user.setId(1);
        newOrder.setUser(user);

        orderRepository.save(newOrder);

    }
}
