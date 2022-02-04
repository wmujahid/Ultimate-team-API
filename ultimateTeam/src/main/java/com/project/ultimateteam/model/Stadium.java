package com.project.ultimateteam.model;

import javax.persistence.*;

@Entity
@Table(name = "stadiums")
public class Stadium {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String city;

    @Column
    private Integer seatingCapacity;

    @Column
    private boolean hasChant;

}
