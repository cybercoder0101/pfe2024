package com.pfe.code.controllers;

import com.pfe.code.entities.Fournisseur;
import com.pfe.code.entities.Produit;
import com.pfe.code.services.FournisseurService;
import com.pfe.code.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fournisseurs")
public class FournisseurRESTController {
    @Autowired
    FournisseurService fournisseurService;

    @Autowired
   ProduitService produitService;

    @GetMapping("/all")
    public List<Fournisseur>getAll(){
        return fournisseurService.getAll();
    }


    @GetMapping("/allnomsf")
    public List<String>getAllnoms(){
        return fournisseurService.getAllnoms();
    }
    @GetMapping("/getid/{id}")
    public Fournisseur getByid(@PathVariable("id")Long id){
        return fournisseurService.getByid(id);
    }

    @GetMapping("/nomContains/{nom}")
    public List<Fournisseur>getByNomContains(@PathVariable("nom") String nom){
        return fournisseurService.getByNomContains(nom);
    }

    @GetMapping("/pays/{pays}")
    public List<Fournisseur>getByPays(@PathVariable("pays")String pays){
        return fournisseurService.findByAdresse_Pays(pays);
    }
    @GetMapping("/nomAcs")
    public List<Fournisseur>getByNomAcs(){
        return fournisseurService.getByNomACS();
    }

    @GetMapping("/nomDesc")
    public List<Fournisseur>getByNomDesc(){

        return fournisseurService.getByNomDESC();
    }

    @GetMapping("/preAcs")
    public List<Fournisseur>getByPreAcs(){
        return fournisseurService.getByPreAcs();
    }

    @GetMapping("/preDesc")
    public List<Fournisseur>getByPresDes(){
        return fournisseurService.getByPreDesc();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addFournisseur")
    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur){
        return fournisseurService.saveFournisseur(fournisseur);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN','FOURNISSEUR','SERVICE_LIVRAISON')")
    @DeleteMapping("/supprimerFournisseur/{id}")
    public void deleteById(@PathVariable("id") Long id){
      fournisseurService.deleteFournisseurById(id);
  }

    @PreAuthorize("hasAuthority('FOURNISSEUR')")

  @PutMapping("/fouraddprod/{id}")
    public Fournisseur updateF(@PathVariable("id") Long id,@RequestBody Produit produit){
        return fournisseurService.updateFourbyid(id,produit);
  }
    @PreAuthorize("hasAuthority('FOURNISSEUR')")
@PutMapping("/updateinfos")
    public Fournisseur updateinfos(@RequestBody Fournisseur fournisseuru){
     return fournisseurService.updateinfoFour(fournisseuru);
}


}
