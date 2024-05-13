package com.pfe.code.repositories;

import com.pfe.code.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface CommandeRepository  extends JpaRepository<Commande,Long > {
    List<Commande>findByMarchandId(Long id);
    Commande findByReference(String ref);
    List<Commande>findByServiceLivraisonId(Long id);
    List<Commande>findByLivreurId(Long id);
}
