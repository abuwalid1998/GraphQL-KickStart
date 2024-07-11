package com.graphql.graphql.Repository;

import com.graphql.graphql.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}