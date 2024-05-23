package com.pfe.code.repositories;

import com.pfe.code.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {

    List<LigneCommande>findByCommandeId(Long id);
}
