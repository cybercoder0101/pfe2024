package com.pfe.code.controllers;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Produit;
import com.pfe.code.services.FourniseurService;
import com.pfe.code.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fournisseur")
public class FournisseurRESTController {
    @Autowired
    FourniseurService fourniseurService;
    @Autowired
    ProduitService produitService;
    @GetMapping("/all")
    public List<Fournisseur> getAll(){
        return fourniseurService.getAll();
    }

    @GetMapping("/nomContains/{nom}")
    public List<Fournisseur>getByNomContains(@PathVariable("nom") String nom){
        return fourniseurService.getByNomContains(nom);
    }
  @PostMapping("/addFournisseur")
    public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur){
      return fourniseurService.saveFournisseur(fournisseur);
  }

  @DeleteMapping("/supprimerFournisseur/{id}")
    public void deleteByIdF(@PathVariable("id") Long id){
      fourniseurService.deleteFournisseurById(id);
  }

  @PostMapping("/addProd")
    public Produit saveProduit(Produit produit){
        return produitService.saveProduit(produit);
  }


}
