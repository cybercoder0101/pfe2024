package com.pfe.code.services;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Marchand;
import com.pfe.code.entities.Produit;

import java.util.List;
import java.util.Optional;

public interface MarchandService {
    List<Marchand>getAll();
    Marchand createMarchand(Marchand marchand);

    List<Marchand>getByNomContains(String nom);

    List<Marchand>getByNomAsc();
    List<Marchand>getByNomDESC();
    List<Marchand>getByPreAcs();

    Optional<Marchand> findByEmail(String email);

    List<Marchand>getByPreDesc();


    void deleteMarchandById(Long id);

}
