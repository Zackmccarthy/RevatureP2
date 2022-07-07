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
    @SequenceGenerator(
            name = "restaurant_sequence",
            sequenceName = "restaurant_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "restaurant_sequence"
    )
    @Column(columnDefinition = "serial")
    private int id;
    private String restaurantName;
    @OneToOne
    @JoinColumn
    private User user;
}
