package com.example.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue
    private int menu_id;
    private String dishName;
    private double price;
    private String availability;
    private String description;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
