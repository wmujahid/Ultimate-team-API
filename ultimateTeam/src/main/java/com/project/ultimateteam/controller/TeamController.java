package com.project.ultimateteam.controller;

import com.project.ultimateteam.model.Player;
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
    @GetMapping(path = "/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    // Get team by id
    @GetMapping(path = "/teams/{teamId}")
    public Optional getATeam(@PathVariable Long teamId) {
        return teamService.getATeam(teamId);
    }

    // Create a team and throw an exception if it
    @PostMapping("/teams")
    public Team createTeam(@RequestBody Team teamObject) {
        //  the @RequestBody annotation maps the HttpRequest body to an object
        return teamService.createTeam(teamObject);
    }

    // Update team by id
    @PutMapping("/teams/{teamId}")
    public Team updateTeam(@PathVariable(value = "teamId") Long teamId, @RequestBody Team teamObject) {
        return teamService.updateTeam(teamId, teamObject);
    }

    // Delete team by id
    @DeleteMapping("/teams/{teamId}")
    public String deleteTeam(@PathVariable(value = "teamId") Long teamId) {
        return teamService.deleteTeam(teamId);
    }

    @PostMapping("/teams/players")
    public Player createPlayer(@RequestBody Player playerObject) {
        //  the @RequestBody annotation maps the HttpRequest body to an object
        return teamService.createPlayer(playerObject);
    }
    // Get all teams
    @GetMapping(path = "/teams/players")
    public List<Player> getAllPlayers() {
        return teamService.getAllPlayers();
    }

    // Get team by id
    @GetMapping(path = "/teams/{playerId}")
    public Optional getAPlayer(@PathVariable Long playerId) {
        return teamService.getAPlayer(playerId);
    }
}