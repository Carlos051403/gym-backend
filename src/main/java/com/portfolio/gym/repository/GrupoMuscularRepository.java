package com.portfolio.gym.repository;

import com.portfolio.gym.entity.GrupoMuscular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoMuscularRepository extends JpaRepository<GrupoMuscular, Integer> {
}
