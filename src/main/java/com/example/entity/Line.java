package com.example.entity;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "line")
public class Line {

    @Id
    @SequenceGenerator(
            name = "line_sequence",
            sequenceName = "line_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "line_sequence"
    )
    @Column(columnDefinition = "serial")
    private int id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    private int menu_id;

    private int quantity;


}
