package com.sathiya.springbootaop.controller;

import com.sathiya.springbootaop.entity.Country;
import com.sathiya.springbootaop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Sathiyaraj created on 05-02-2022
 * <p>
 * TODO
 */

@RestController
@RequestMapping("/api/v1/")
public class CountryController {

    @Autowired
    private CountryService countryServ;

    @GetMapping(value="country")
    public List<Country> getAllCountryList() {
        return countryServ.getCountryList();
    }

    @GetMapping(value="country/{id}")
    public Country getCountryDetails(@PathVariable("id") long id) {
        return countryServ.getCountry(id);
    }
}
