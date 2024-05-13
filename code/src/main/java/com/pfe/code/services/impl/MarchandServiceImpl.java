package com.pfe.code.services.impl;

import com.pfe.code.entities.Marchand;
import com.pfe.code.entities.Role;
import com.pfe.code.repositories.MarchandRepository;
import com.pfe.code.repositories.ProduitRepository;
import com.pfe.code.services.MarchandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MarchandServiceImpl implements MarchandService {
    @Autowired
    MarchandRepository marchandRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public List<Marchand> getAll() {
        return marchandRepository.findAll();
    }



    @Override
    public Marchand createMarchand(Marchand marchand) {
        //envoi de l'envoi de l'email
        marchand.setRole(Role.ACHETEUR);
        return marchandRepository.save(marchand);
    }



    @Override
    public List<Marchand> getByNomContains(String nom) {
        return marchandRepository.findByNomContains(nom);
    }

    @Override
    public List<Marchand> getByNomAsc() {
        return marchandRepository.trierOrderByNomASC();
    }

    @Override
    public List<Marchand> getByNomDESC() {
        return marchandRepository.trierOrderByPreDESC();
    }

    @Override
    public List<Marchand> getByPreAcs() {
        return marchandRepository.trierOrderByPreASC();
    }

    @Override
    public Optional<Marchand> findByEmail(String email) {
        return marchandRepository.findByEmail(email);
    }

    @Override
    public List<Marchand> getByPreDesc() {
        return marchandRepository.trierOrderByPreDESC();
    }

    @Override
    public void deleteMarchandById(Long id) {
    marchandRepository.deleteById(id);
    }
}
