package com.portfolio.gym.repository;

import com.portfolio.gym.entity.MarcaFabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaFabricanteRepository extends JpaRepository<MarcaFabricante, Integer> {
}
