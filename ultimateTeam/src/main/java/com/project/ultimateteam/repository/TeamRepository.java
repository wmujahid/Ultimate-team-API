package com.project.ultimateteam.repository;

import com.project.ultimateteam.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByName(String teamName);
}
