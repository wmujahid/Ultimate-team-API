package com.project.ultimateteam.model;

public class Team {
    private Long id;
    private String teamName;
    private String description;

    public Team(Long id, String name, String description) {
        this.id = id;
        this.teamName = name;
        this.description = description;
    }

    public Team() {

    }



}