package com.example.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class RestarauntDto {
    private int id;
    private String restaurantName;
    private String description;
}
