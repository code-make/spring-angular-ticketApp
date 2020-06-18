package com.example.canan.repository;

import com.example.canan.dto.JourneyDto;
import com.example.canan.model.Bus;
import com.example.canan.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface JourneyRepository extends JpaRepository<Journey,Long> {
    JourneyDto findTripById(int id);

    JourneyDto findByBusRegNumber(String regNumber);

    Journey findTripByRouteNumber(String routeNumber);

    @Async
    @Query("select s from Journey s  where s.startLocation= :startLocation and s.endLocation= :endLocation and  s.startDate  = :startDate")
    List<Journey> findByStartLocationAndEndLocationAndStartDate(@Param("startLocation") String startLocation,@Param("endLocation") String endLocation,@Param("startDate") String startDate);

    @Async
    @Query("select s from Journey s  where s.id= :id and s.busRegNumber= :busRegNumber")
    List<Journey> findByIdAndBusRegNumber(@Param("id") Long id, @Param("busRegNumber") String busRegNumber);
   // List<JourneyDto> findByRouteNumberAndDepartureDate(String routeNumber, String departureDate);

//    JourneyDto findByRouteNumberAndDepartureDateAndDepartureTime(String routeNumber, String departureDate, String departureTime);
}
