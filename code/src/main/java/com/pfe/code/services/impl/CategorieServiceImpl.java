package com.pfe.code.services.impl;

import com.pfe.code.entities.Categorie;
import com.pfe.code.repositories.CategorieRepository;
import com.pfe.code.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        Optional<Categorie>optional= categorieRepository.findById(categorie.getId());
        optional.get().setNom(categorie.getNom());
        optional.get().setDescription(categorie.getDescription());

        return categorieRepository.save(optional.get());
    }

    @Override
    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public void deleteCategorie(Long id) {

        categorieRepository.deleteById(id);

    }

    @Override
    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    @Override
    public List<Categorie> getByNomC(String nom) {
        return categorieRepository.findByNomContains(nom);
    }

    @Override
    public List<String> getnoms() {
        return categorieRepository.nomscats();
    }
}
