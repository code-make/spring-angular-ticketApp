package com.example.canan.dto;

import com.example.canan.model.Journey;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Data
public class RouteDto {

    private String routeNumber;


    private int distance;


    private String startLocation;


    private String endLocation;


    private String description;

    private List<JourneyDto> trips;
}
