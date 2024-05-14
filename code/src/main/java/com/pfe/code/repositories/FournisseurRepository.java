package com.pfe.code.repositories;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {


List<Fournisseur> findByNom(String nom);
List<Fournisseur> findByNomContains(String nom);
List<Fournisseur>findByAdresse_Pays(String pays);

 Optional<Fournisseur> findByEmail(String email);

    @Query("select f from Fournisseur f order by  f.nom ASC ")
    List<Fournisseur> trierOrderByNomASC();

    @Query("select f  from Fournisseur f order by f.nom DESC ")
    List<Fournisseur> trierOrderByNomDESC();

    @Query("select f from Fournisseur f order by f.prenom ASC ")
    List<Fournisseur>trierOrderByPreASC();

    @Query("select f from Fournisseur f order by f.prenom DESC ")
    List<Fournisseur>trierOrderByPreDESC();







}
