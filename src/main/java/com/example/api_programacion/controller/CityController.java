package com.example.api_programacion.controller;

import com.example.api_programacion.model.City;
import com.example.api_programacion.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/city")
public class CityController
{
    @Autowired
    private CityService cityService;

    @GetMapping(path = "/listcities")
    public List <City> getCities()
    {
        return cityService.getCities();
    }

}
