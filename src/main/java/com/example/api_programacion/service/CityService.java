package com.example.api_programacion.service;


import com.example.api_programacion.model.City;
import lombok.Data;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class CityService
{
    private List<City>
        cities;
    public CityService()
    {
        cities= new ArrayList<>();
        cities.add(new City("16917001","Manizales"));
        cities.add(new City("16917002","La dorada"));
        cities.add(new City("16917003","Chinchina"));
        cities.add(new City("16963001","Pereira"));

    }
    public List<City> getCities()
{
    return cities;
}
    public City searchCityByCode(String code) {
        for (int i = 0; i < cities.size(); i++)
        {
            if (cities.get(i).getCode().equals(code)) {
                return cities.get(i);
            }
        }
        return null;
    }
}
