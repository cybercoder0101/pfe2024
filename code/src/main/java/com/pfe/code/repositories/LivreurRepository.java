package com.pfe.code.repositories;

import com.pfe.code.entities.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreurRepository extends JpaRepository<Livreur, Long> {

    List<Livreur> getLivreursByServiceLivraisonId(Long id);



}
