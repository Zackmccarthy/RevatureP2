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
@Table(name="couriers")
public class Courier {
    @Id
    @GeneratedValue
    private int courier_id;
    private String courierUsername;
    private String courierPassword;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(
            name = "couriers_menus",
            joinColumns = @JoinColumn (name = "courier_id"),
            inverseJoinColumns = @JoinColumn (name="menu_id")

    )
    private List<Courier> couriers  = new ArrayList<>();
}


