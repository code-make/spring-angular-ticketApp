package com.example.canan.service.Impl;

import com.example.canan.dto.CityDto;
import com.example.canan.dto.JourneyDto;
import com.example.canan.model.Booking;
import com.example.canan.model.City;
import com.example.canan.model.Journey;

import com.example.canan.repository.CityRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Service
public class CityServiceImpl {
    @Autowired
    private CityRepository cityRepository;
    private ModelMapper modelMapper;


    public List<City> findAllCity() throws NotFoundException{
    List<City> cities= cityRepository.findAll();

        return cities;
    }


    public CityDto saveCity(CityDto cityDto) throws Exception {
     /*   City cityChechked = cityRepository.findByName(cityDto);
        if (cityChechked != null) {
            throw new IllegalArgumentException("City already exist");
        }*/
        City city1 = modelMapper.map(cityDto, City.class);
        cityRepository.save(city1);
        cityDto.setId(city1.getId());
        return cityDto;
    }

}
