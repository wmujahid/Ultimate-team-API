package com.project.ultimateteam.controller;

import com.project.ultimateteam.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.ultimateteam.service.TeamService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class TeamController {

    private TeamService teamService;

    @Autowired
    public void setTeamService(TeamService teamService){
        this.teamService = teamService;
    }

    // Get all teams
    @GetMapping(path = "/team")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    // Get team by id
    @GetMapping(path = "/team/{teamId}")
    public Optional getATeam(@PathVariable Long teamId) {
        return teamService.getATeam(teamId);
    }

    // Create a team and throw an exception if it
    @PostMapping("/team/")
    public Team createTeam(@RequestBody Team teamObject) {
        //  the @RequestBody annotation maps the HttpRequest body to an object
        return teamService.createTeam(teamObject);
    }

    // Update team by id
    @PutMapping("/team/{teamId}")
    public Team updateTeam(@PathVariable(value = "teamId") Long teamId, @RequestBody Team teamObject) {
        return teamService.updateTeam(teamId, teamObject);
    }

    // Delete team by id
    @DeleteMapping("/team/{teamId}")
    public Optional<Team> deleteTeam(@PathVariable(value = "teamId") Long teamId) {
        return teamService.deleteTeam(teamId);
    }
}