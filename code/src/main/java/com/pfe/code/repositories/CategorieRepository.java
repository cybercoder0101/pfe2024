package com.pfe.code.repositories;

import com.pfe.code.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {

    @Query("select c.nom from Categorie c")
    List<String>nomscats();

    List<Categorie>findByNomContains(String nom);
}
