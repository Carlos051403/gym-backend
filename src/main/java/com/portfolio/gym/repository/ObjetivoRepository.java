package com.portfolio.gym.repository;

import com.portfolio.gym.entity.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {
}
