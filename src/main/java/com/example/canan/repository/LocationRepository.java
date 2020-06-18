package com.example.canan.repository;

import com.example.canan.dto.LocationDto;
import com.example.canan.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
    LocationDto findLocationById(int id);

    LocationDto findLocationByName(String name);
}
