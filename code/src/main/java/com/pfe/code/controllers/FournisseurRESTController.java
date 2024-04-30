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

    @GetMapping("/all")
    public List<Fournisseur>getAll(){
        return fourniseurService.getAll();


    }

    @GetMapping("/nomContains/{nom}")
    public List<Fournisseur>getByNomContains(@PathVariable("nom") String nom){
        return fourniseurService.getByNomContains(nom);
    }

    @GetMapping("/nomAcs")
    public List<Fournisseur>getByNomAcs(){
        return fourniseurService.getByNomACS();
    }

    @GetMapping("/nomDesc")
    public List<Fournisseur>getByNomDesc(){

        return fourniseurService.getByNomDESC();
    }

    @GetMapping("/preAcs")
    public List<Fournisseur>getByPreAcs(){
        return fourniseurService.getByPreAcs();
    }

    @GetMapping("/preDesc")
    public List<Fournisseur>getByPresDes(){
        return fourniseurService.getByPreDesc();
    }


    @PostMapping("/addFournisseur")
    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur){
        return fourniseurService.saveFournisseur(fournisseur);
    }

    @DeleteMapping("/supprimerFournisseur/{id}")
    public void deleteByIdF(@PathVariable("id") Long id){
      fourniseurService.deleteFournisseurById(id);
  }



  @PutMapping("/updateFour/{id}")
    public Fournisseur updateF(@PathVariable("id") Long id,@RequestBody Produit produit){
        return fourniseurService.updateFourbyid(id,produit);
  }


}
