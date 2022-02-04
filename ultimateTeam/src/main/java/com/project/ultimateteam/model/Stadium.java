package com.project.ultimateteam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Stadium(Long id, String name, String city, Integer seatingCapacity) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.seatingCapacity = seatingCapacity;
    }

    public Stadium() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }


    @Override
    public String toString() {
        return "Stadium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", team=" + team +
                '}';
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
