package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name="restaurantManagers")
public class RestaurantManager {
    @Id
    @GeneratedValue
    private int restaurant_id;
    private String restUsername;
    private String restPassword;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(
            name = "restaurants_menus",
            joinColumns = @JoinColumn (name = "order_id")

    )
    private List<Menu> me = new ArrayList<>();
}
