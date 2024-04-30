package com.pfe.code.services.impl;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Produit;
import com.pfe.code.entities.Role;
import com.pfe.code.repositories.FournisseurRepository;
import com.pfe.code.services.FourniseurService;
import com.pfe.code.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FourniseurServiceImpl implements FourniseurService {
    @Autowired
    FournisseurRepository fournisseurRepository;

    @Autowired
    ProduitService produitService;



    @Override
    public List<Fournisseur> getAll() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        fournisseur.setRole(Role.FOURNISSEUR);
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public List<Fournisseur> getByNomContains(String nom) {
        return fournisseurRepository.findByNomContains(nom);
    }

    @Override
    public List<Fournisseur> getByNomACS() {
return fournisseurRepository.trierOrderByNomASC();
    }

    @Override
    public List<Fournisseur> getByNomDESC() {
        return fournisseurRepository.trierOrderByNomDESC();
    }

    @Override
    public List<Fournisseur> getByPreAcs() {
        return fournisseurRepository.trierOrderByPreASC();
    }

    @Override
    public Optional<Fournisseur> findByEmail(String email) {
        return fournisseurRepository.findByEmail(email);
    }

    @Override
    public List<Fournisseur> getByPreDesc() {
        return fournisseurRepository.trierOrderByPreDESC();
    }



    @Override
    public void deleteFournisseurById(Long id) {
        fournisseurRepository.deleteById(id);

    }



    @Override
    public Fournisseur updateFour(String email, Produit produit) {
        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findByEmail(email);
        if (optionalFournisseur.isPresent()) {
            Fournisseur fournisseur = optionalFournisseur.get();
            List<Produit> produits = fournisseur.getProduits();

            produits.add(produit);
            produit.setFournisseur(fournisseur); // Mettre à jour la référence du produit vers le fournisseur
            fournisseur.setProduits(produits);


            return fournisseurRepository.save(fournisseur);
        } else {
            // Gérer le cas où aucun fournisseur avec cet ID n'est trouvé
            // Par exemple, vous pouvez lever une exception ou retourner null
            return null;
        }
    }

    @Override
    public Fournisseur updateFourbyid(Long id, Produit produit) {
        Optional<Fournisseur> optionalFournisseur= fournisseurRepository.findById(id);
        if (optionalFournisseur.isPresent()){
            Fournisseur fournisseur= optionalFournisseur.get();
            List<Produit> produits= fournisseur.getProduits();
            produits.add(produit);
            produit.setFournisseur(fournisseur);
            return fournisseurRepository.save(fournisseur);
        }
        return null;
    }


}
