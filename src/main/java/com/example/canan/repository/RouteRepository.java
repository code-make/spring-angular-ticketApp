package com.example.canan.repository;

import com.example.canan.dto.RouteDto;
import com.example.canan.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {

    RouteDto findRouteById(int id);

    RouteDto findByRouteNumber(String routeNumber);

    List<RouteDto> findAllByStartLocationIgnoreCaseAndEndLocationIgnoreCase(String startLocation, String endLocation);

    RouteDto findRouteByStartLocation(String start);
}
