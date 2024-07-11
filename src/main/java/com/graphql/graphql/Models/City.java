package com.graphql.graphql.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ColumnDefault("''")
    @Column(name = "Name", nullable = false, length = 35)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("''")
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country countryCode;

    @ColumnDefault("''")
    @Column(name = "District", nullable = false, length = 20)
    private String district;

    @ColumnDefault("0")
    @Column(name = "Population", nullable = false)
    private Integer population;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Country countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

}