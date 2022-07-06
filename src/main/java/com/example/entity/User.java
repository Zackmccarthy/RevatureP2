package com.example.entity;

import lombok.*;


import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private int user_id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @Enumerated(EnumType.STRING)
    private MenuType menu;
    @Enumerated(EnumType.STRING)
    private UserType users;
}
