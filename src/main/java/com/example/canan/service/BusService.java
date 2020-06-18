package com.example.canan.service;

import com.example.canan.dto.BusDto;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

public interface BusService {

    public List<BusDto> findAllBuses()throws NotFoundException;

    public BusDto findBusById(Long id)throws NotFoundException;

    public BusDto saveBus(BusDto bus);

    public Boolean deleteBusById(Long id)throws NotFoundException;

    public List<BusDto> getByBusRegNUmber(Long id,String busRegNumber)throws NotFoundException;

    public List<BusDto> findByName(String name)throws NotFoundException;

    public BusDto update(Long id, @Valid BusDto busDto) throws NotFoundException;
}
