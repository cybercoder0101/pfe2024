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
    List<Produit> findByNomProdContains(String nom);
    List<Produit> findByFournisseurId(Long id);









    //Filtre categorie
@Query("select p from Produit p order by p.categorie.nom ASC")

List<Produit>OrderedByCategorieAsc();


@Query("select p from Produit p order by p.categorie.nom DESC")
List<Produit>orderByCategorieDesc();

    List<Produit> findByCategorieId(Long id);

    @Query("select p from Produit p where p.categorie.nom like ?1")
    List<Produit> findByCategorie(String nomcat);




    //Filtre prix

    List<Produit> findByPrixProd(Double prixProd);
    @Query("select p from  Produit p order by p.prixProd ASC")
    List<Produit>OrderByPrixA();

    @Query("select p from Produit p order by p.prixProd DESC ")
    List<Produit>OrderByPrixD();

    List<Produit>findByPrixProdBetween(Double prix1, Double prix2);

    //filtre
    @Query("SELECT p FROM Produit p " +
            "WHERE (coalesce(:minPrix,null )IS NULL OR p.prixProd >= :minPrix ) " +
            "AND (coalesce(:maxPrix ,null ) IS NULL OR p.prixProd <= :maxPrix) " +
            "AND (coalesce(:categories,null ) IS NULL OR p.categorie.nom IN :categories) " +

            "AND (coalesce(:souscategories,null ) IS NULL OR p.sousCategorie.nom IN :souscategories)" +


            "AND (coalesce(:quantiteMin,null ) IS NULL OR p.quantite >= :quantiteMin) " +
            "AND (coalesce(:quantiteMax,0) IS NULL OR p.quantite <= :quantiteMax)")
    List<Produit> filtrerProduits(
            @Param("minPrix") Double minPrix,
            @Param("maxPrix") Double maxPrix,
            @Param("categories") List<String> categories,
            @Param("souscategories") List<String> souscategories,
            @Param("quantiteMin") Long quantiteMin,
            @Param("quantiteMax") Long quantiteMax);
    @Query("SELECT p FROM Produit p WHERE " +
            "(LOWER(p.nomProd) LIKE LOWER(CONCAT('%', :terme, '%')) OR p.nomProd IS NULL) " +
            "AND (LOWER(p.categorie.nom) LIKE LOWER(CONCAT('%', :terme, '%')) OR p.categorie IS NULL) " +
            "AND (LOWER(p.sousCategorie.nom) LIKE LOWER(CONCAT('%', :terme, '%')) OR p.sousCategorie IS NULL)")
    List<Produit> rechercherProduits(@Param("terme") String terme);






}
