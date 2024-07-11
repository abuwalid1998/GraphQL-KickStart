package com.graphql.graphql.Services;

import com.graphql.graphql.Models.City;
import com.graphql.graphql.Repository.CityRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityQueryResolver implements GraphQLQueryResolver {
    private final CityRepository cityRepository;

    public CityQueryResolver(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public City getCity(Integer id) {
        return cityRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("City not found"));
    }
}