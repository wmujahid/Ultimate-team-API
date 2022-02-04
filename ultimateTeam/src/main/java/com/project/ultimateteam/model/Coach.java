package com.project.ultimateteam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name= "coaches")
public class Coach {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String nationality;

    @Column
    private Integer age;

    @Column
    private String strategy;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Coach(Long id, String name, String nationality, Integer age, String strategy) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.strategy = strategy;
    }

    public Coach() {
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", strategy='" + strategy + '\'' +
                '}';
    }
}
