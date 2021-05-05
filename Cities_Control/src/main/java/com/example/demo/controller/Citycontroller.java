package com.example.demo.controller;

import antlr.ASTNULLType;
import com.example.demo.model.Country;
import com.example.demo.model.city;
import com.example.demo.repo.CityRepository;
import com.example.demo.repo.CountryRepository;
import com.example.demo.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("/rest")
public class Citycontroller {

    private CountryService countryService;
private CountryRepository countryRepository;
private CityRepository cityRepository;
@Autowired

    public Citycontroller(CountryService countryService) {
        this.countryService = countryService;
    }




    @GetMapping(path = "cities")
    public List<Country>  GetAllCities(){
        return countryService.getAllCountry();
    }


//    @PostMapping (path="/countries")
//    public ResponseEntity<Country> createCountry(@RequestBody Country country, @PathVariable("id") Integer id,@PathVariable("name") String name){
//    	return ResponseEntity.ok(countryService.createCountry(country,id,name));
//    }


    @DeleteMapping(path = "/countries/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable("id") Integer id){
       Country result= countryService.deleteCountry(id);
       return ResponseEntity.ok(result);

    }
    @PostMapping("/countries")
    public ResponseEntity<Country> createCountry(@RequestBody Country country,@RequestParam("id") Integer id,@RequestParam("name")String name) {
        List<city> cities=new ArrayList<city>();
        city city=new city(id, name);
        cities.add(city);
        country.setCities(cities);
        cityRepository.saveAll(cities);
        return ResponseEntity.ok(countryRepository.save(country));
    }
    
    

}
