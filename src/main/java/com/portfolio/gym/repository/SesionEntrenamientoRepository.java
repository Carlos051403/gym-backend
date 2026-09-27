package com.portfolio.gym.repository;

import com.portfolio.gym.entity.SesionEntrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionEntrenamientoRepository extends JpaRepository<SesionEntrenamiento, Integer> {
}
