package com.project.ultimateteam.controller;

import com.project.ultimateteam.exception.InformationExistException;
import com.project.ultimateteam.exception.InformationNotFoundException;
import com.project.ultimateteam.model.Team;
import com.project.ultimateteam.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class TeamController {

    private TeamRepository teamRepository;

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    // Get all teams
    @GetMapping(path = "/team/")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    // Get team by id
    @GetMapping(path = "/team/{teamId}")
    public Optional getATeam(@PathVariable Long teamId) throws Exception {
        Optional team = teamRepository.findById(teamId);
        if(team.isPresent()){
            return team;
        } else {
            throw new Exception("team with id " + teamId + " not found");
        }
    }

    // Create a team and throw an exception if it
    @PostMapping("/team/")
    public Team createTeam(@RequestBody Team teamObject) {

        Team team = teamRepository.findByName(teamObject.getTeamName());

        if(team != null){
            throw new InformationExistException("team with name " + team.getTeamName() + " already exists");
        } else {
            return teamRepository.save(teamObject);
        }
    }

    @PutMapping("/team/{teamId}")
    public String updateTeam(@PathVariable(value = "teamId") Long teamId, @RequestBody String body) {
        return "updating the team with the id of " + teamId + body;
    }

    @DeleteMapping("/team/{teamId}")
    public String deleteTeam(@PathVariable(value = "teamId") Long teamId) {
        return "deleting the team with the id of " + teamId;
    }
}