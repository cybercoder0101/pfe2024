package com.pfe.code.repositories;

import com.pfe.code.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {

List<Fournisseur> findByNom(String nom);
List<Fournisseur> findByNomContains(String nom);


}
