package com.example.canan.api;

import com.example.canan.dto.CityDto;
import com.example.canan.model.City;
import com.example.canan.service.Impl.CityServiceImpl;
import com.example.canan.util.ApiPaths;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.CityCtrl.CTRL)
@CrossOrigin("http://localhost:4200")
public class CityController {

    private final CityServiceImpl cityService;

    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }


    @GetMapping()
    public ResponseEntity<List<City>> getAll() throws NotFoundException {
        List<City> cities = cityService.findAllCity();
        return ResponseEntity.ok(cities);
    }

    @PostMapping()
    public ResponseEntity<CityDto> createCity(@Valid @RequestBody CityDto cityDto) throws Exception{


        return ResponseEntity.ok(cityService.saveCity(cityDto));
    }
}
