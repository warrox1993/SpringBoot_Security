package com.example.Decouverte_Spring_boot.dal.repository;

import com.example.Decouverte_Spring_boot.dal.domain.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
