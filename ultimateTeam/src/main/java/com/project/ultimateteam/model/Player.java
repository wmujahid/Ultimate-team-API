package com.project.ultimateteam.model;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private Integer rating;

    @Column
    private Integer pace;

    @Column
    private Integer showboating;

    @Column
    private Integer passing;

    @Column
    private Integer dribbling;

    @Column
    private Integer defense;

    @Column
    private Integer physicality;

    @Column
    private String primaryFoot;

}