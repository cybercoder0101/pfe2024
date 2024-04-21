package com.pfe.code.repositories;

import com.pfe.code.entities.Categorie;
import com.pfe.code.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    //recherche par nom
    List<Produit> findByNomProd(String nom);
    // recherche contains string
    List<Produit> findByNomProdContains(String nom);
    List<Produit> findByPrixProd(Double prixProd);
    //filtre nom_prix
    @Query("select p from Produit p where p.nomProd like %?1 and p.prixProd > ?2")
    List<Produit>findByNomPrix( String nom, Double prix);

    @Query("select p from Produit p where p.categorie =?1")
    List<Produit> findByCategorie(Categorie categorie);


    List<Produit> findByCategorieId(Long id);




}
