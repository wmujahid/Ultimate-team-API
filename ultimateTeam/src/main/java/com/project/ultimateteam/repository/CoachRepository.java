package com.project.ultimateteam.repository;

import com.project.ultimateteam.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, Long> {


    List<Coach> findByTeamId(Long teamId);
}
