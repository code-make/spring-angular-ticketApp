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
public class BusDto {
    private Long id;

    private String busRegNumber;


    private String name;


    private String type;


    private int isAvailable;


    private List<JourneyDto> journey;
}
