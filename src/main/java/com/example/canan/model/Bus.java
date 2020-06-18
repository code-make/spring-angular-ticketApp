package com.example.canan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long id;

    @Column(name = "registration_number")
    private String busRegNumber;

    @Column(name = "name")
    private String name;


    @Column(name = "is_available")
    private int isAvailable;



    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<Journey> journey;

    public Bus() {
    }

    public Bus(String busRegNumber, String name,  int isAvailable) {
        this.busRegNumber = busRegNumber;
        this.name = name;

        this.isAvailable = isAvailable;
    }
}


