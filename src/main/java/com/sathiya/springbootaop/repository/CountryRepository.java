package com.sathiya.springbootaop.repository;

import com.sathiya.springbootaop.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Sathiyaraj created on 05-02-2022
 * <p>
 * TODO
 */

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findById(long id);
}
