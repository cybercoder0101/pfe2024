package com.pfe.code.controllers;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.services.FourniseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class FournisseurRESTController {
    @Autowired
    FourniseurService fourniseurService;
  @PostMapping("/addFournisseur")
    public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur){
      return fourniseurService.saveFournisseur(fournisseur);
  }

  @DeleteMapping("/supprimerFournisseur/{id}")
    public void deleteByIdF(@PathVariable("id") Long id){
      fourniseurService.deleteFournisseurById(id);
  }


}
