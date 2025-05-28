package com.nassau.gerenciamentodeveiculos.repository;

import com.nassau.gerenciamentodeveiculos.entity.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoEntityRepository extends JpaRepository<VeiculoEntity, Long> {
}