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
@Table(name="orders")

public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column(columnDefinition = "serial")
    private int order_id;
    private double price;
    private boolean deliveryMethod;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders_menus",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "menus_id")

    )
    private List<Order> orders = new ArrayList<>();
}
