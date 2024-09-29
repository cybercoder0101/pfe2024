package com.pfe.code.repositories;

import com.pfe.code.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo  extends JpaRepository<Administrateur,Long> {
}
