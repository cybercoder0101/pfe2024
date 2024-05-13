package com.pfe.code.repositories;

import com.pfe.code.entities.ServiceLivraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ServiceLivraisonRepository extends JpaRepository<ServiceLivraison, Long> {
}
