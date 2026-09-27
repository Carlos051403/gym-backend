package com.portfolio.gym.repository;

import com.portfolio.gym.entity.Suplemento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuplementoRepository extends JpaRepository<Suplemento, Integer> {
}
