package com.example.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class UserDto {
    private String phoneNumber;
    private String email;
    private String address;
}
