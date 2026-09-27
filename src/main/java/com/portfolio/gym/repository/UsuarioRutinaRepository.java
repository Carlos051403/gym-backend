package com.portfolio.gym.repository;

import com.portfolio.gym.entity.UsuarioRutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRutinaRepository extends JpaRepository<UsuarioRutina, Integer> {
}
