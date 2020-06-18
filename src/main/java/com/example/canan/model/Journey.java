package com.example.canan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "journey")
public class Journey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Journey_id")
    private Long id;

    @Column(name = "price_per_seat")
    private int pricePerSeat;

 /*   @Column(name = "departure_date")
    private String departureDate;*/

    @Column(name = "startDate")
    private String startDate;

  /*  @Column(name = "departure_time")
    private String departureTime;*/

    @Column(name = "arrival_time")
    private String arrivalTime;

    @Column(name = "startLocation")
    private String startLocation;

    @Column(name = "endLocation")
    private String endLocation;

/*    @Column(name = "duration")
    private String duration;*/

    @Column(name = "route_number")
    private String routeNumber;

    @Column(name = "bus_reg_number")
    private String busRegNumber;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "route_id")
    private Route route;



    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "bus_id")
    private Bus bus;


    @OneToMany(mappedBy = "journey", cascade = CascadeType.ALL)
    private List<Booking> booking;

    public Journey() {
    }

    public Journey(String startLocation, String endLocation ,int pricePerSeat,  String startDate,String arrivalTime,  String routeNumber, String busRegNumber) {
        this.pricePerSeat = pricePerSeat;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startDate = startDate;

        this.arrivalTime = arrivalTime;

        this.routeNumber = routeNumber;
        this.busRegNumber = busRegNumber;
    }
}