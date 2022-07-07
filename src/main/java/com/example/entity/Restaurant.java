package com.example.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue
    private int id;
    private String restaurantName;
    @OneToOne
    @JoinColumn
    private User user;
}
