package com.project.ultimateteam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private String country;

    @Column
    @NotNull
    @Min(1)
    @Max(100)
    private Integer rating;

    @Column
    @NotNull
    @Min(1)
    @Max(100)
    private Integer pace;

    @Column
    @NotNull
    @Min(1)
    @Max(100)
    private Integer showboating;

    @Column
    @NotNull
    @Min(1)
    @Max(100)
    private Integer passing;

    @Column
    @NotNull
    @Min(1)
    @Max(100)
    private Integer dribbling;

    @Column
    @NotNull
    @Min(1)
    @Max(100)
    private Integer defense;

    @Column
    @NotNull
    @Min(1)
    @Max(100)
    private Integer physicality;

    @Column
    @NotNull
    private String primaryFoot;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player(Long id, String name, String country, Integer rating, Integer pace, Integer showboating, Integer passing, Integer dribbling, Integer defense, Integer physicality, String primaryFoot) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.rating = rating;
        this.pace = pace;
        this.showboating = showboating;
        this.passing = passing;
        this.dribbling = dribbling;
        this.defense = defense;
        this.physicality = physicality;
        this.primaryFoot = primaryFoot;
    }

    public Player(){

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getPace() {
        return pace;
    }

    public void setPace(Integer pace) {
        this.pace = pace;
    }

    public Integer getShowboating() {
        return showboating;
    }

    public void setShowboating(Integer showboating) {
        this.showboating = showboating;
    }

    public Integer getPassing() {
        return passing;
    }

    public void setPassing(Integer passing) {
        this.passing = passing;
    }

    public Integer getDribbling() {
        return dribbling;
    }

    public void setDribbling(Integer dribbling) {
        this.dribbling = dribbling;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getPhysicality() {
        return physicality;
    }

    public void setPhysicality(Integer physicality) {
        this.physicality = physicality;
    }

    public String getPrimaryFoot() {
        return primaryFoot;
    }

    public void setPrimaryFoot(String primaryFoot) {
        this.primaryFoot = primaryFoot;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", rating=" + rating +
                ", pace=" + pace +
                ", showboating=" + showboating +
                ", passing=" + passing +
                ", dribbling=" + dribbling +
                ", defense=" + defense +
                ", physicality=" + physicality +
                ", primaryFoot='" + primaryFoot + '\'' +
                ", team=" + team +
                '}';
    }
}