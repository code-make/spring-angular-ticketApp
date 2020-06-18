package com.example.canan.service.Impl;

import com.example.canan.dto.BusDto;
import com.example.canan.dto.JourneyDto;
import com.example.canan.model.Bus;
import com.example.canan.model.Journey;
import com.example.canan.repository.JourneyRepository;
import com.example.canan.service.JourneyService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JourneyServiceImpl implements JourneyService {
    private final JourneyRepository journeyRepository;
    private final ModelMapper modelMapper;

    public JourneyServiceImpl(JourneyRepository journeyRepository, ModelMapper modelMapper) {
        this.journeyRepository = journeyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<JourneyDto> findAllJourney() throws NotFoundException {
        List<Journey> journeys = journeyRepository.findAll();
        if (journeys.size() < 1) {
            throw new NotFoundException("journey don't already exist");
        }
        JourneyDto[] journeyDtos = modelMapper.map(journeys, JourneyDto[].class);

        return Arrays.asList(journeyDtos);
    }

    @Override
    public JourneyDto findTripById(Long id) throws NotFoundException {
        Optional<Journey> journey = journeyRepository.findById(id);
        if (!journey.isPresent()) {
            throw new NotFoundException("journey dosen't exist : " + id);
        }

        JourneyDto journeyDto = modelMapper.map(journey.get(), JourneyDto.class);
        journeyDto.setId(id);

        return journeyDto;
    }

    @Override
    public JourneyDto saveTrip(JourneyDto journeyDto) throws Exception {
        Journey journeyChecked = journeyRepository.findTripByRouteNumber(journeyDto.getRouteNumber());
        if (journeyChecked != null) {
            throw new IllegalArgumentException("journey regnumber already exist");
        }
        Journey journey = modelMapper.map(journeyDto, Journey.class);
        journeyRepository.save(journey);
        journeyDto.setId(journey.getId());
        return journeyDto;
    }

    @Override
    public Boolean deleteTripById(Long id) throws NotFoundException {
        Optional<Journey> journey = journeyRepository.findById(id);
        if (!journey.isPresent()) {
            throw new NotFoundException("journey dosen't exist : " + id);
        }
        journeyRepository.deleteById(id);
        return true;
    }

    @Override
    public List<JourneyDto> getByBusRegNUmber(Long id,String busRegNumber) throws NotFoundException {
        List<Journey> journeys = journeyRepository.findByIdAndBusRegNumber(id,busRegNumber);
        if (journeys.size() < 1) {
            throw new NotFoundException("Bus don't already exist");
        }
        JourneyDto[] journeyDtos = modelMapper.map(journeys, JourneyDto[].class);

        return Arrays.asList(journeyDtos);

    }

    @Override
    public JourneyDto findTripByRouteNumber(String routeNumber) throws NotFoundException {
        return null;
    }

    @Override
    public JourneyDto update(Long id, @Valid JourneyDto journeyDto) throws NotFoundException {

        Optional<Journey> journeyOptional = journeyRepository.findById(id);
        if (!journeyOptional.isPresent()) {
            throw new NotFoundException("Journey dosen't exist : " + id);
        }
        Journey journey = modelMapper.map(journeyDto, Journey.class);
        journey.setId(id);
        journeyRepository.save(journey);
        journeyDto.setId(journey.getId());
        return journeyDto;
    }

    @Override
    public List<JourneyDto> getByDate(String startLocation, String endLocation, String starDate) throws NotFoundException {
        List<Journey> journeys = journeyRepository.findByStartLocationAndEndLocationAndStartDate(startLocation,endLocation,starDate);
        if (journeys.size() < 1) {
            throw new NotFoundException("Journey don't already exist");
        }
        JourneyDto[] journeyDtos = modelMapper.map(journeys, JourneyDto[].class);
        return Arrays.asList(journeyDtos);
    }
}
