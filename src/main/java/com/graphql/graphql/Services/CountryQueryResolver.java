package com.graphql.graphql.Services;

import com.graphql.graphql.Models.Country;
import com.graphql.graphql.Repository.CountryRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryQueryResolver implements GraphQLQueryResolver {
    private final CountryRepository countryRepository;

    public CountryQueryResolver(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public Country getCountry(Integer id) {
        return countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
    }
}