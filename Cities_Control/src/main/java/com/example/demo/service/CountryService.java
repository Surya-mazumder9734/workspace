package com.example.demo.service;

import com.example.demo.model.Country;
import com.example.demo.model.city;

import java.util.List;

public interface CountryService {
	 public List<Country> getAllCountry();
	 public Country createCountry(Country country,Integer id,String name);

	public Country deleteCountry(Integer id);
}
