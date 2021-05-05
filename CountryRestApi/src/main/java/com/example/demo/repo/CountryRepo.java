package com.example.demo.repo;

import com.example.demo.model.Country;

import java.util.Collection;

public interface CountryRepo {
    public Collection<Country> createCountry(Country country);


}
