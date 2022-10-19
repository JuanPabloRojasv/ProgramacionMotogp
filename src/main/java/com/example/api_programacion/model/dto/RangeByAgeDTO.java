package com.example.api_programacion.model.dto;

import com.example.api_programacion.model.Kid;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RangeByAgeDTO
{
    private int initial;
    private int end;
    private int quantity;
}
