package com.example.service;

import com.example.entity.Menu;
import org.springframework.stereotype.Service;

public interface MenuService {

    void addMenuItem(int restaurantId, Menu menu);
}
