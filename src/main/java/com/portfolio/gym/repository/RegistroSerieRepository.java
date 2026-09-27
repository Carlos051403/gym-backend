package com.portfolio.gym.repository;

import com.portfolio.gym.entity.RegistroSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroSerieRepository extends JpaRepository<RegistroSerie, Integer> {
}
