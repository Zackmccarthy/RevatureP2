package com.example.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.AUTO,
            generator = "user_sequence"
    )
    @Column(columnDefinition = "serial")
    private int id;
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String address;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({
            org.hibernate.annotations.CascadeType.MERGE
    })
    @JoinTable(
        name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

}
