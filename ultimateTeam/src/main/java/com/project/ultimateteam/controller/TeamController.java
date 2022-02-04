package com.project.ultimateteam.controller;

import com.project.ultimateteam.model.Coach;
import com.project.ultimateteam.model.Player;
import com.project.ultimateteam.model.Stadium;
import com.project.ultimateteam.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.ultimateteam.service.TeamService;

import java.util.HashMap;
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
    public Optional<Team> deleteTeam(@PathVariable(value = "teamId") Long teamId) {
        return teamService.deleteTeam(teamId);
    }

    //----------------------------------------------------------------------------------------------------//

    @PostMapping("/teams/{teamId}/players")
    public Player createPlayer(
            @PathVariable(value = "teamId") Long teamId, @RequestBody Player playerObject) {
            return teamService.createPlayer(teamId, playerObject);
    }

    @GetMapping(path = "/teams/{teamId}/players")
    public List<Player> getAllPlayers(@PathVariable(value = "teamId") Long teamId) {
        return teamService.getAllPlayers(teamId);
    }

    @GetMapping(path = "/teams/{teamId}/players/{playerId}")
    public Player getAPlayer(@PathVariable(value = "teamId") Long teamId, @PathVariable(value = "playerId") Long playerId) {
        return teamService.getAPlayer(teamId, playerId);
    }

    @PutMapping("/teams/{teamId}/players/{playerId}")
    public Player updatePlayer(@PathVariable(value = "teamId" ) Long teamId,
                               @PathVariable(value = "playerId") Long playerId,
                               @RequestBody Player playerObject) {
        return teamService.updatePlayer(teamId, playerId, playerObject);
    }

    @DeleteMapping("/teams/{teamId}/players/{playerId}")
    public ResponseEntity<HashMap> deletePlayer(@PathVariable(value = "teamId") Long teamId,
                                                @PathVariable(value = "playerId") Long playerId) {
        teamService.deletePlayer(teamId, playerId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "player with id: " + playerId + " was successfully deleted.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }

    //------------------------------------------------------------------------------------------//

    @PostMapping("/teams/{teamId}/coaches")
    public Coach createCoach(
            @PathVariable(value = "teamId") Long teamId, @RequestBody Coach coachObject) {
        return teamService.createCoach(teamId, coachObject);
    }

    @GetMapping(path = "/teams/{teamId}/coaches")
    public Coach getAllCoaches(@PathVariable(value = "teamId") Long teamId) {
        return teamService.getAllCoaches(teamId);
    }

    @GetMapping(path = "/teams/{teamId}/coaches/{coachId}")
    public Coach getACoach(@PathVariable(value = "teamId") Long teamId, @PathVariable(value = "coachId") Long coachId) {
        return teamService.getACoach(teamId, coachId);
    }

    @PutMapping("/teams/{teamId}/coaches/{coachId}")
    public Coach updateCoach(@PathVariable(value = "teamId" ) Long teamId,
                               @PathVariable(value = "coachId") Long coachId,
                               @RequestBody Coach coachObject) {
        return teamService.updateCoach(teamId, coachId, coachObject);
    }

    @DeleteMapping("/teams/{teamId}/coaches/{coachId}")
    public ResponseEntity<HashMap> deleteCoach(@PathVariable(value = "teamId") Long teamId,
                                                @PathVariable(value = "coachId") Long coachId) {
        teamService.deleteCoach(teamId, coachId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "coach with id: " + coachId + " was successfully deleted.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }

    //------------------------------------------------------------------------------------------//

    @PostMapping("/teams/{teamId}/stadiums")
    public Stadium createStadium(
            @PathVariable(value = "teamId") Long teamId, @RequestBody Stadium stadiumObject) {
        return teamService.createStadium(teamId, stadiumObject);
    }

    @GetMapping(path = "/teams/{teamId}/stadiums")
    public Stadium getAllStadiums(@PathVariable(value = "teamId") Long teamId) {
        return teamService.getAllStadiums(teamId);
    }

    @GetMapping(path = "/teams/{teamId}/stadiums/{stadiumId}")
    public Stadium getAStadium(@PathVariable(value = "teamId") Long teamId, @PathVariable(value = "stadiumId") Long stadiumId) {
        return teamService.getAStadium(teamId, stadiumId);
    }

    @PutMapping("/teams/{teamId}/stadiums/{stadiumId}")
    public Stadium updateStadium(@PathVariable(value = "teamId" ) Long teamId,
                             @PathVariable(value = "stadiumId") Long stadiumId,
                             @RequestBody Stadium stadiumObject) {
        return teamService.updateStadium(teamId, stadiumId, stadiumObject);
    }

    @DeleteMapping("/teams/{teamId}/stadiums/{stadiumId}")
    public ResponseEntity<HashMap> deleteStadium(@PathVariable(value = "teamId") Long teamId,
                                               @PathVariable(value = "stadiumId") Long stadiumId) {
        teamService.deleteStadium(teamId, stadiumId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "stadium with id: " + stadiumId + " was successfully deleted.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }
}