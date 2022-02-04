package com.project.ultimateteam.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

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

    // one category can contain more than one player
    @OneToMany(mappedBy = "team", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Player> playerList;

    @OneToOne(mappedBy = "team", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Coach coach;


    public Team(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Team() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
    public void setPlayerList(List<Player> playerList){
        this.playerList = playerList;
    }
    public Coach getCoach() { return coach; }
    public void setCoach(Coach coach){
        this.coach = coach;
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