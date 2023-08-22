package com.example.user.msvc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {

    private String marca;
    private int fabrication;
    private Integer userId;
}
