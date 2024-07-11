package com.graphql.graphql.Repository;

import com.graphql.graphql.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}