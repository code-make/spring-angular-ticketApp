package com.example.canan.repository;

import com.example.canan.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Override
    List<City> findAll();
    City findByName(String name);
}
