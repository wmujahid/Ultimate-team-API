package com.project.ultimateteam.model;

import javax.persistence.*;

@Entity
@Table(name= "teams")
public class Team {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    public Team(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Team() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}