package com.example.canan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "city")
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private int id;

    @Column(name = "name")
    private String name;



    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
