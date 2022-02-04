package com.project.ultimateteam.repository;

import com.project.ultimateteam.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {

    List<Stadium> findByTeamId(Long teamId);
}
