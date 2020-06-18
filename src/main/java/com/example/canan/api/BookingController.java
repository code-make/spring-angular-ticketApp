package com.example.canan.api;

import com.example.canan.dto.BookingDto;
import com.example.canan.dto.JourneyDto;
import com.example.canan.service.Impl.BookingServiceImpl;
import com.example.canan.util.ApiPaths;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.BookingCtrl.CTRL)
@CrossOrigin("http://localhost:4200")
public class BookingController {
    private final BookingServiceImpl bookingService;

    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping()
    public ResponseEntity<List<BookingDto>> getAll() throws NotFoundException {
        List<BookingDto> bookingDtos = bookingService.findAllBooking();
        return ResponseEntity.ok(bookingDtos);
    }

    @PostMapping()
    public ResponseEntity<BookingDto> createBooking(@Valid @RequestBody BookingDto bookingDto) throws Exception{
        return ResponseEntity.ok(bookingService.saveBooking(bookingDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> update(@PathVariable(name = "id", required = true) Long id,
                                             @Valid @RequestBody BookingDto bookingDto) throws NotFoundException {
        return ResponseEntity.ok(bookingService.update(id, bookingDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id", required = true) Long id)
            throws NotFoundException {
        return ResponseEntity.ok(bookingService.deleteBookingById(id));
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<List<BookingDto>> findAllEmail(  @PathVariable(name = "email", required = true) String email) throws NotFoundException {
        List<BookingDto> bookingDtos = bookingService.getByEmail( email);

        return ResponseEntity.ok(bookingDtos);
    }
}
