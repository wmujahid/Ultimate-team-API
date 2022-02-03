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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getDescription() {
        return description;
    }
}