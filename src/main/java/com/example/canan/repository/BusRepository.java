package com.example.canan.repository;

import com.example.canan.dto.BusDto;
import com.example.canan.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Long> {

    BusDto findBusById(int id);

    Bus findByBusRegNumber(String busRegNumber);
    @Async
    @Query("select s from Bus s  where s.id= :id and s.busRegNumber= :busRegNumber")
    List<Bus> findByIdAndBusRegNumber(@Param("id") Long id,@Param("busRegNumber") String busRegNumber);

    List<Bus> findByName (String name);
}
