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
    @SequenceGenerator(
            name = "menu_sequence",
            sequenceName = "menu_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "menu_sequence"
    )
    @Column(columnDefinition = "serial")
    private int menu_id;
    private String dishName;
    private double price;
    private String availability;
    private String description;
    private String review;
    private String ingredients;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
