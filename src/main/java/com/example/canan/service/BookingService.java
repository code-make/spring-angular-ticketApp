package com.example.canan.service;

import com.example.canan.dto.BookingDto;
import com.example.canan.dto.BusDto;
import com.example.canan.dto.JourneyDto;
import javassist.NotFoundException;

import javax.validation.Valid;
import java.util.List;

public interface BookingService {

    public List<BookingDto> findAllBooking()throws NotFoundException;

    public BookingDto saveBooking(BookingDto bookingDto) throws  Exception;

    public Boolean deleteBookingById(Long id) throws NotFoundException ;

    public BookingDto update(Long id, @Valid BookingDto bookingDto) throws NotFoundException;

    public List<BookingDto> getByEmail(String email)throws NotFoundException;


}
