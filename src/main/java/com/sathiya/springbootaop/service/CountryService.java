package com.sathiya.springbootaop.service;

import com.sathiya.springbootaop.aop.TrackExecutionTime;
import com.sathiya.springbootaop.entity.Country;
import com.sathiya.springbootaop.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Sathiyaraj created on 05-02-2022
 * <p>
 * TODO
 */

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepo;

    public List<Country> getCountryList() {
        return countryRepo.findAll();
    }

    @TrackExecutionTime
    public Country getCountry(long id) {
        return countryRepo.findById(id);
    }
}
