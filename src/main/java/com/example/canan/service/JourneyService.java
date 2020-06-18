package com.example.canan.service;

import com.example.canan.dto.BusDto;
import com.example.canan.dto.JourneyDto;
import com.example.canan.model.Journey;
import javassist.NotFoundException;

import javax.validation.Valid;
import java.util.List;

public interface JourneyService {

    public List<JourneyDto> findAllJourney()  throws NotFoundException ;

    public JourneyDto findTripById(Long id) throws NotFoundException ;

    public JourneyDto saveTrip(JourneyDto journeyDto) throws  Exception;

    public Boolean deleteTripById(Long id) throws NotFoundException ;

    public List<JourneyDto> getByBusRegNUmber(Long id,String busRegNumber)throws NotFoundException;

    public JourneyDto findTripByRouteNumber(String routeNumber) throws NotFoundException ;

    public JourneyDto update(Long id, @Valid JourneyDto journeyDto) throws NotFoundException;

    public List<JourneyDto> getByDate(String startLocation,String endLocation,String starDate) throws NotFoundException;
}
