package com.example.canan.api;

import com.example.canan.dto.BusDto;
import com.example.canan.dto.JourneyDto;
import com.example.canan.model.Journey;
import com.example.canan.service.Impl.JourneyServiceImpl;
import com.example.canan.util.ApiPaths;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.JourneyCtrl.CTRL)
@CrossOrigin("http://localhost:4200")
public class JourneyController {
    private final JourneyServiceImpl journeyService;

    public JourneyController(JourneyServiceImpl journeyService) {
        this.journeyService = journeyService;
    }



    @GetMapping()
    public ResponseEntity<List<JourneyDto>> getAll() throws NotFoundException {
        List<JourneyDto> journeyDtos = journeyService.findAllJourney();
        return ResponseEntity.ok(journeyDtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<JourneyDto> getOneJourney(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(journeyService.findTripById(id));
    }

    @PostMapping()
    public ResponseEntity<JourneyDto> createJourney(@Valid @RequestBody JourneyDto journeyDto) throws Exception{
        return ResponseEntity.ok(journeyService.saveTrip(journeyDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JourneyDto> update(@PathVariable(name = "id", required = true) Long id,
                                            @Valid @RequestBody JourneyDto journeyDto) throws NotFoundException {
        return ResponseEntity.ok(journeyService.update(id, journeyDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(journeyService.deleteTripById(id));
    }

    @GetMapping("/find/{startLocation}/{endLocation}/{startDate}")
    public ResponseEntity<List<JourneyDto>> findByName(@PathVariable(name = "startLocation", required = true) String startLocation,
                                                    @PathVariable(name = "endLocation", required = true) String endLocation,
                                                    @PathVariable(name = "startDate", required = true) String startDate)
            throws NotFoundException {
        return ResponseEntity.ok(journeyService.getByDate(startLocation,endLocation,startDate));
    }

    @GetMapping("/get/{id}/{busRegNumber}")
    public ResponseEntity<List<JourneyDto>> findAllBusRegNumber(@PathVariable(name = "id", required = true) Long id,
                                                            @PathVariable(name = "busRegNumber", required = true) String busRegNumber) throws NotFoundException {
        List<JourneyDto> journeyDtos = journeyService.getByBusRegNUmber(id, busRegNumber);

        return ResponseEntity.ok(journeyDtos);
    }
    }
/*    @GetMapping("/find")
    public ResponseEntity<List<JourneyDto>> findAllByName(@RequestParam String name) throws NotFoundException {
        List<BusDto> busDtos = journeyService.findTripByBusRegNumber(name);
        return ResponseEntity.ok(busDtos);
    }*/