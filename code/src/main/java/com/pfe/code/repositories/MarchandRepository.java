package com.pfe.code.repositories;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Marchand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarchandRepository extends JpaRepository<Marchand, Long> {
    List<Marchand> findByNomContains(String nom);
    Optional<Marchand> findByEmail(String email);

    @Query("select m from Marchand m order by  m.nom ASC ")
    List<Marchand> trierOrderByNomASC();

    @Query("select m  from Marchand m order by m.nom DESC ")
    List<Marchand> trierOrderByNomDESC();

    @Query("select m from Marchand m order by m.prenom ASC ")
    List<Marchand>trierOrderByPreASC();

    @Query("select m from Marchand m order by m.prenom DESC ")
    List<Marchand>trierOrderByPreDESC();

}
