package com.project.ultimateteam.repository;

import com.project.ultimateteam.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByName(String name);

    Player findByNameAndIdIsNot(String playerName,Long playerId);

    List<Player> findByTeamId(Long playerId);
}
