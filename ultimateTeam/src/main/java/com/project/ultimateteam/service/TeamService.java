package com.project.ultimateteam.service;

import com.project.ultimateteam.exception.InformationExistException;
import com.project.ultimateteam.exception.InformationNotFoundException;
import com.project.ultimateteam.model.Team;
import com.project.ultimateteam.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional getATeam(Long teamId) {

        Optional team = teamRepository.findById(teamId);

        if(team.isPresent()){
            return team;
        } else {
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }
    }

    public Team createTeam(Team teamObject) {

        Team team = teamRepository.findByName(teamObject.getTeamName());

        if(team != null){
            throw new InformationExistException("team with name " + team.getTeamName() + " already exists");
        } else {
            return teamRepository.save(teamObject);
        }
    }

    public Team updateTeam(Long teamId, Team teamObject) {

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

    public Optional<Team> deleteTeam(Long teamId) {
        System.out.println("service calling deleteCategory ==>");
        Optional<Team> category = teamRepository.findById(teamId);

        if (((Optional<?>) category).isPresent()) {
            teamRepository.deleteById(teamId);
            return category;
        } else {
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }
    }
}
