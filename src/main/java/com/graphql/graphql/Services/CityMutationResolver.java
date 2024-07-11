package com.graphql.graphql.Services;

import com.graphql.graphql.Models.City;
import com.graphql.graphql.Models.Country;
import com.graphql.graphql.Repository.CityRepository;
import com.graphql.graphql.Repository.CountryRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class CityMutationResolver implements GraphQLMutationResolver {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public CityMutationResolver(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public City createCity(String name, String countryCode, String district, Integer population) {
        Country country = countryRepository.getReferenceById(Integer.valueOf(countryCode));
        if (country == null) throw new RuntimeException("Country not found");

        City city = new City();
        city.setName(name);
        city.setCountryCode(country);
        city.setDistrict(district);
        city.setPopulation(population);
        return cityRepository.save(city);
    }

    public City updateCity(Integer id, String name, String countryCode, String district, Integer population) {
        City city = cityRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("City not found"));
        if (name != null) city.setName(name);
        if (countryCode != null) {
            Country country = countryRepository.getReferenceById(Integer.valueOf(countryCode));
            city.setCountryCode(country);
        }
        if (district != null) city.setDistrict(district);
        if (population != null) city.setPopulation(population);
        return cityRepository.save(city);
    }

    public String deleteCity(Integer id) {
        cityRepository.deleteById(Long.valueOf(id));
        return "City deleted";
    }
}