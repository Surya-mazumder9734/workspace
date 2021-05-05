package com.example.demo.repo;

import com.example.demo.model.Country;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class CountryRepoImpl implements CountryRepo{
    Map<Integer, Country> countryMap;
    private Country id;
    {
        Random  random=new Random();
        countryMap = new HashMap<Integer, Country>();
        countryMap.put(1,new Country(1,"India",239990));
        countryMap.put(1,new Country(random.nextInt(), "USA",23329));


    }
    @Override
    public Collection<Country> createCountry(Country country) {
        countryMap.put(countryMap.size()+1,country );
        return countryMap.values();
    }
}
