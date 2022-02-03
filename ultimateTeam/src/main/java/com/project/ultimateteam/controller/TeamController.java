package com.project.ultimateteam.controller;

import com.project.ultimateteam.model.Team;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class TeamController {

    @GetMapping(path = "/team/")
    public String getTeam() {
        return "get all teams";
    }

    @GetMapping(path = "/team/{teamId}")
    public String getTeam(@PathVariable Long teamId) {
        return "getting the team with the id of " + teamId;
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