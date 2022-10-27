package com.example.api_programacion.model.dto;

import com.example.api_programacion.model.Kid;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KidByPositionDTO {
    private int position;
    private KidCityDTO kidCityDTO;

}
