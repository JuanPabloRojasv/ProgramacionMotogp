package com.example.api_programacion.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Kid {
    private String identification;
    private String name;
    private byte age;
    private char gender;
    private byte num_brothers;
    private City city;
}