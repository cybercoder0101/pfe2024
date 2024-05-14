package com.pfe.code.repositories;

import com.pfe.code.entities.Categorie;
import com.pfe.code.entities.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository


public interface SousCategorieRepository extends JpaRepository<SousCategorie, Long> {
    @Query("select c.nom from SousCategorie c")
    List<String> nomsouscats();
    List<SousCategorie>findByCategorieId(Long id);



    List<SousCategorie>findByNomContains(String nom);
}
