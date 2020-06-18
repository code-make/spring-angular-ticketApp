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
public class BookingDto {

    private Long id;


    private String name;

    private String surname;


    private String tc;


    private String email;


    private String phone;


    private String seatNo;


    private String routeNumber;
}
