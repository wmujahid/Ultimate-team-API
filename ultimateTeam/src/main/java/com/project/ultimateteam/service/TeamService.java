package com.project.ultimateteam.service;

import com.project.ultimateteam.exception.InformationExistException;
import com.project.ultimateteam.exception.InformationNotFoundException;
import com.project.ultimateteam.model.Coach;
import com.project.ultimateteam.model.Player;
import com.project.ultimateteam.model.Team;
import com.project.ultimateteam.repository.PlayerRepository;
import com.project.ultimateteam.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeamService {

    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    @Autowired
    public void setPlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
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

    public Optional<Team> deleteTeam(Long teamId) {

        Optional<Team> team = teamRepository.findById(teamId);

        if (team.isPresent()) {
            teamRepository.deleteById(teamId);
            return team;
        } else {
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }
    }

    public Player createPlayer(Long teamId, Player playerObject){
        try{
            Optional team = teamRepository.findById(teamId);
            playerObject.setTeam((Team) team.get());
            return playerRepository.save(playerObject);
        } catch (NoSuchElementException e){
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }

    }

    public List<Player> getAllPlayers(Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isPresent()) {
            return team.get().getPlayerList();
        } else {
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }
    }

    public Player getAPlayer(Long teamId, Long playerId) {

        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isPresent()) {
            Optional<Player> player = playerRepository.findByTeamId(teamId).stream().filter(
                    p -> p.getId().equals(playerId)).findFirst();
            if (player.isEmpty()) {
                throw new InformationNotFoundException("player with id " + playerId + " not found");
            } else {
                return player.get();
            }
        } else {
            throw new InformationNotFoundException("team with id " + teamId + " not found");
        }
    }

    public Player updatePlayer(Long teamId, Long playerId, Player playerObject) {
        try {
            Player player = (playerRepository.findByTeamId(
                    teamId).stream().filter(p -> p.getId().equals(playerId)).findFirst()).get();
            player.setName(playerObject.getName());
            player.setCountry(playerObject.getCountry());
            player.setRating(playerObject.getRating());
            player.setPace(playerObject.getPace());
            player.setShowboating(playerObject.getShowboating());
            player.setPassing(playerObject.getPassing());
            player.setDribbling(playerObject.getDribbling());
            player.setDefense(playerObject.getDefense());
            player.setPhysicality(playerObject.getPhysicality());
            player.setPrimaryFoot(playerObject.getPrimaryFoot());
            return playerRepository.save(player);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("player or team not found");
        }
    }

    public void deletePlayer(Long teamId, Long playerId) {
        try {
            Player player = (playerRepository.findByTeamId(
                    teamId).stream().filter(p -> p.getId().equals(playerId)).findFirst()).get();
            playerRepository.deleteById(player.getId());
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("player or team not found");
        }
    }

    public Coach createCoach(Long teamId, Coach coachObject) {
    }

    public List<Coach> getAllCoaches(Long teamId) {
    }

    public Coach getACoach(Long teamId, Long coachId) {
    }

    public Coach updateCoach(Long teamId, Long coachId, Coach coachObject) {
    }

    public void deleteCoach(Long teamId, Long coachId) {
    }
}
