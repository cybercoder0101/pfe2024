package com.pfe.code.repositories;

import com.pfe.code.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
Utilisateur findByEmail(String email);

List<Utilisateur>findByNomContains(String nom);



}
