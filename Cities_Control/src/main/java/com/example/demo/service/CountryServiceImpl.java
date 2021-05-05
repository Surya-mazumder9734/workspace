package com.example.demo.service;

import com.example.demo.model.Country;
import com.example.demo.model.city;
import com.example.demo.repo.CityRepository;
import com.example.demo.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class CountryServiceImpl implements CountryService{

    private CountryRepository countryRepository;
    private CityRepository cityRepository;
    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository,CityRepository cityRepository) {

        this.countryRepository = countryRepository;
        this.cityRepository=cityRepository;
    }

  
//

	@Override
	public Country createCountry(Country country,Integer id,String name) {
		// TODO Auto-generated method stub
		List<city> cities=new ArrayList<city>();
		city city=new city(id,name);
		cities.add(city);
		country.setCities(cities);
		cityRepository.saveAll(cities);
	 return countryRepository.save(country);
    }

	@Override
	public Country deleteCountry(Integer id) {
		return countryRepository.deleteCountryById(id);
	}


	@Override
	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}


}
