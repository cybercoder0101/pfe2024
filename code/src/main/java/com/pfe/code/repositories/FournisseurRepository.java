package com.pfe.code.repositories;

import com.pfe.code.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {

List<Fournisseur> findByNom(String nom);

}
