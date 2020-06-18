package com.example.canan.dto;

import com.example.canan.model.Route;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Data
public class LocationDto {

    private String name;


    private String description;


    private Boolean enabled;


    private List<RouteDto> routes;
}
