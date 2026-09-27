package com.portfolio.gym.repository;

import com.portfolio.gym.entity.DetalleRutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRutinaRepository extends JpaRepository<DetalleRutina, Integer> {
}
