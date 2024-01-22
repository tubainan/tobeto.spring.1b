package com.tobeto.spring.b.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name="customers")
@Entity
@Data


public class Customer {

    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name="name")
    private String name;

    @Column(name="sur_name")
    private String surName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "email")
    private String eMail;

    @Column(name = "adress")
    private String adress;

    @OneToMany(mappedBy = "customers")
    private List<ReservationCar>  reservationCar;

}
