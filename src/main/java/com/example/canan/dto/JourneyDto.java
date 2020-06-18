package com.example.canan.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@Data
public class JourneyDto {

    private Long id;

    private int pricePerSeat;

    private String startDate;

    private String arrivalTime;

    private String startLocation;

    private String endLocation;


    private String duration;

    private String routeNumber;

    private String busRegNumber;
}
