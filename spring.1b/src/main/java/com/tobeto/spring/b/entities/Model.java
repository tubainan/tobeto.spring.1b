package com.tobeto.spring.b.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name="models")
@Entity
public class Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @OneToMany(mappedBy = "models")
    private List<Car> cars;
}
