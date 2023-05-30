package com.example.demo.repository;

import com.example.demo.entities.Apliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplianceRepository extends JpaRepository<Apliance,Long>{
}