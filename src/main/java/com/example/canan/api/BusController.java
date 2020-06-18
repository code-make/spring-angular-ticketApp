package com.example.canan.api;

import com.example.canan.dto.BusDto;
import com.example.canan.service.Impl.BusServiceImpl;
import com.example.canan.util.ApiPaths;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping(ApiPaths.BusCtrl.CTRL)
@CrossOrigin
public class BusController {
    private final BusServiceImpl busServiceImpl;

    public BusController(BusServiceImpl busServiceImpl) {
        this.busServiceImpl = busServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<List<BusDto>> getAll() throws NotFoundException {
        List<BusDto> busDtos = busServiceImpl.findAllBuses();
        return ResponseEntity.ok(busDtos);
    }

    @GetMapping("/find")
    public ResponseEntity<List<BusDto>> findAllByName(@RequestParam String name) throws NotFoundException {
        List<BusDto> busDtos = busServiceImpl.findByName(name);
        return ResponseEntity.ok(busDtos);
    }
    @GetMapping("/get/{id}/{busRegNumber}")
    public ResponseEntity<List<BusDto>> findAllBusRegBumber(@PathVariable(name = "id", required = true) Long id,
                                                            @PathVariable(name = "busRegNumber", required = true) String busRegNumber) throws NotFoundException {
        List<BusDto> busDtos = busServiceImpl.getByBusRegNUmber(id,busRegNumber);
        return ResponseEntity.ok(busDtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BusDto> getOne(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(busServiceImpl.findBusById(id));
    }

    @PostMapping()
    public ResponseEntity<BusDto> createBus(@Valid @RequestBody BusDto busDto) {
        return ResponseEntity.ok(busServiceImpl.saveBus(busDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusDto> updateBus(@PathVariable(name = "id", required = true) Long id,
                                                        @Valid @RequestBody BusDto busDto) throws NotFoundException {
        return ResponseEntity.ok(busServiceImpl.update(id, busDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(busServiceImpl.deleteBusById(id));
    }

}
