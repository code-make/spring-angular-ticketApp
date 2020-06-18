package com.example.canan.service.Impl;

import com.example.canan.dto.BookingDto;
import com.example.canan.dto.JourneyDto;
import com.example.canan.model.Booking;
import com.example.canan.model.Journey;
import com.example.canan.repository.BookingRepository;
import com.example.canan.service.BookingService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ModelMapper modelMapper;


    public BookingServiceImpl(BookingRepository bookingRepository, ModelMapper modelMapper) {
        this.bookingRepository = bookingRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<BookingDto> findAllBooking() throws NotFoundException {
        List<Booking> bookings = bookingRepository.findAll();
        if (bookings.size() < 1) {
            throw new NotFoundException("Booking don't already exist");
        }
        BookingDto[] bookingDtos = modelMapper.map(bookings, BookingDto[].class);

        return Arrays.asList(bookingDtos);
    }

    @Override
    public BookingDto saveBooking(BookingDto bookingDto) throws Exception {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        bookingRepository.save(booking);
        bookingDto.setId(booking.getId());
        return bookingDto;
    }

    @Override
    public Boolean deleteBookingById(Long id) throws NotFoundException {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (!booking.isPresent()) {
            throw new NotFoundException("booking dosen't exist : " + id);
        }
        bookingRepository.deleteById(id);
        return true;
    }

    @Override
    public BookingDto update(Long id, @Valid BookingDto bookingDto) throws NotFoundException {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (!bookingOptional.isPresent()) {
            throw new NotFoundException("Booking dosen't exist : " + id);
        }
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        booking.setId(id);
        bookingRepository.save(booking);
        bookingDto.setId(booking.getId());
        return bookingDto;
    }

    @Override
    public List<BookingDto> getByEmail(String email) throws NotFoundException {
        List<Booking> bookings = bookingRepository.findByEmail(email);
        if (bookings.size() < 1) {
            throw new NotFoundException("Booking don't already exist");
        }
        BookingDto[] bookingDtos = modelMapper.map(bookings, BookingDto[].class);

        return Arrays.asList(bookingDtos);
    }
}
