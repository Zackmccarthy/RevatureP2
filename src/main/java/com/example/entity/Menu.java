package com.example.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name="menus")
public class Menu {
    private int menu_id;
    private String dishName;
    private double price;

}
