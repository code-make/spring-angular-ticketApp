package com.example.canan.repository;

import com.example.canan.model.Booking;
import com.example.canan.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Async
    @Query("select s from Booking s  where s.email= :email")
    List<Booking> findByEmail(@Param("email") String email);
}
