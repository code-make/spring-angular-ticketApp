package com.example.canan.service.Impl;

import com.example.canan.dto.BusDto;
import com.example.canan.model.Bus;
import com.example.canan.repository.BusRepository;
import com.example.canan.service.BusService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {
    private final ModelMapper modelMapper;
    private final BusRepository busRepository;

    public BusServiceImpl(ModelMapper modelMapper, BusRepository busRepository) {
        super();
        this.modelMapper = modelMapper;
        this.busRepository = busRepository;
    }

    @Override
    public List<BusDto> findAllBuses() throws NotFoundException {
        List<Bus> buses = busRepository.findAll();
        if (buses.size() < 1) {
            throw new NotFoundException("Bus don't already exist");
        }
        BusDto[] busDtos = modelMapper.map(buses, BusDto[].class);

        return Arrays.asList(busDtos);
    }

    @Override
    public BusDto findBusById(Long id) throws NotFoundException {
        Optional<Bus> bus = busRepository.findById(id);
        if (!bus.isPresent()) {
            throw new NotFoundException("Bus dosen't exist : " + id);
        }

        BusDto busDto = modelMapper.map(bus.get(), BusDto.class);
        busDto.setId(id);

        return busDto;
    }

    @Override
    public BusDto saveBus(BusDto bus) {
        Bus busChecked = busRepository.findByBusRegNumber(bus.getBusRegNumber());
        if (busChecked != null) {
            throw new IllegalArgumentException("Bus regnumber already exist");
        }
        Bus bus1 = modelMapper.map(bus, Bus.class);
        busRepository.save(bus1);
        bus.setId(bus1.getId());
        return bus;
    }

    @Override
    public Boolean deleteBusById(Long id) throws NotFoundException {
        Optional<Bus> bus = busRepository.findById(id);
        if (!bus.isPresent()) {
            throw new NotFoundException("Bus dosen't exist : " + id);
        }
        busRepository.deleteById(id);
        return true;
    }

    @Override
    public List<BusDto> getByBusRegNUmber(Long id,String busRegNumber) throws NotFoundException {
        List<Bus> buses = busRepository.findByIdAndBusRegNumber(id,busRegNumber);
        if (buses.size() < 1) {
            throw new NotFoundException("Bus don't already exist");
        }
        BusDto[] busDtos = modelMapper.map(buses, BusDto[].class);

        return Arrays.asList(busDtos);
    }

    @Override
    public List<BusDto> findByName(String name) throws NotFoundException {
        List<Bus> buses = busRepository.findByName(name);
        if (buses.size() < 1) {
            throw new NotFoundException("Bus don't already exist");
        }
        BusDto[] busDtos = modelMapper.map(buses, BusDto[].class);

        return Arrays.asList(busDtos);
    }

    @Override
    public BusDto update(Long id, @Valid BusDto busDto) throws NotFoundException {

        Optional<Bus> busOptional = busRepository.findById(id);
        if (!busOptional.isPresent()) {
            throw new NotFoundException("Bus dosen't exist : " + id);
        }
        Bus bus = modelMapper.map(busDto, Bus.class);
        bus.setId(id);
        busRepository.save(bus);
        busDto.setId(bus.getId());
        return busDto;
    }


}
