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
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }
    }

    // Create a team and throw an exception if it
    @PostMapping("/team/")
    public Team createTeam(@RequestBody Team teamObject) {
        //  the @RequestBody annotation maps the HttpRequest body to an object

        Team team = teamRepository.findByName(teamObject.getTeamName());

        if(team != null){
            throw new InformationExistException("team with name " + team.getTeamName() + " already exists");
        } else {
            return teamRepository.save(teamObject);
        }
    }

    // Update team by id
    @PutMapping("/team/{teamId}")
    public Team updateTeam(@PathVariable(value = "teamId") Long teamId, @RequestBody Team teamObject) {
        Optional<Team> team = teamRepository.findById(teamId);

        if(team.isPresent()){
            if(teamObject.getTeamName().equals(team.get().getTeamName())){
                throw new InformationExistException("no changes were made to team " + team.get().getTeamName());
            } else {
                Team updateTeam = teamRepository.findById(teamId).get();
                updateTeam.setTeamName(teamObject.getTeamName());
                updateTeam.setDescription(teamObject.getDescription());
                return teamRepository.save(updateTeam);
            }
        } else {
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }
    }

    // Delete team by id
    @DeleteMapping("/team/{teamId}")
    public Optional<Team> deleteTeam(@PathVariable(value = "teamId") Long teamId) {

        Optional team = teamRepository.findById(teamId);
        if(team.isPresent()){
            teamRepository.deleteById(teamId);
            return team;
        } else {
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }
    }
}