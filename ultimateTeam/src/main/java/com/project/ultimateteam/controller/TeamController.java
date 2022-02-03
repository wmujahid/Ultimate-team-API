package com.project.ultimateteam.controller;

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

    @GetMapping(path = "/team/")
    public List<Team> getTeam() {
        return teamRepository.findAll();
    }

    @GetMapping(path = "/team/{teamId}")
    public Optional getTeam(@PathVariable Long teamId) throws Exception {
        Optional team = teamRepository.findById(teamId);
        if(team.isPresent()){
            return team;
        } else {
            throw new Exception("team with id " + teamId + " not found");
        }
    }

    @PostMapping("/team/")
    public String createTeam(@RequestBody String body) {
        return "creating a team " + body;
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