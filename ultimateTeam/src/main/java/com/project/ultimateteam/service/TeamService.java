package com.project.ultimateteam.service;

import com.project.ultimateteam.exception.InformationExistException;
import com.project.ultimateteam.exception.InformationNotFoundException;
import com.project.ultimateteam.model.Player;
import com.project.ultimateteam.model.Team;
import com.project.ultimateteam.repository.PlayerRepository;
import com.project.ultimateteam.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;

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

        Team team = teamRepository.findByName(teamObject.getName());

        if(team != null){
            throw new InformationExistException("team with name " + team.getName() + " already exists");
        } else {
            return teamRepository.save(teamObject);
        }
    }

    public Team updateTeam(Long teamId, Team teamObject) {

        Optional<Team> team = teamRepository.findById(teamId);

        if(team.isPresent()){
            if(teamObject.getName().equals(team.get().getName())){
                throw new InformationExistException("no changes were made to team " + team.get().getName());
            } else {
                Team updateTeam = teamRepository.findById(teamId).get();
                updateTeam.setName(teamObject.getName());
                updateTeam.setDescription(teamObject.getDescription());
                return teamRepository.save(updateTeam);
            }
        } else {
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }
    }

    public String deleteTeam(Long teamId) {

        Optional<Team> team = teamRepository.findById(teamId);

        if (team != null) {
            teamRepository.deleteById(teamId);
            return "team with id " + teamId + " has been successfully deleted";
        } else {
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }
    }

    public Player createPlayer(Player playerObject){
        Player player = playerRepository.findByName(playerObject.getName());

        if(player != null){
            throw new InformationExistException("team with name " + player.getName() + " already exists");
        } else {
            return playerRepository.save(playerObject);
        }
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional getAPlayer(Long playerId) {

        Optional player = playerRepository.findById(playerId);

        if(player.isPresent()){
            return player;
        } else {
            throw new InformationNotFoundException("player with id " + playerId + " not found");
        }
    }
}
