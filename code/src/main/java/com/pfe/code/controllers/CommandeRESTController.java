package com.pfe.code.controllers;

import com.pfe.code.entities.Commande;
import com.pfe.code.entities.Etat;
import com.pfe.code.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/commandes")
@CrossOrigin("*")
@RestController
public class CommandeRESTController {
    @Autowired
    CommandeService commandeService;

    @GetMapping("/all")
    public List<Commande> getAll(){
      return  commandeService.findAll();
    }

    @GetMapping("/getbyM/{id}")
    public List<Commande>getbyM(@PathVariable("id")Long id){
        return commandeService.findByMarchandId(id);
    }

    @GetMapping("/getbySL/{id}")
    public List<Commande>getbySL(@PathVariable("id") Long id){
        return commandeService.findBySLId(id);
    }

    @GetMapping("/getbyref/{ref}")
    public Commande getbyref(@PathVariable("ref")String ref){
        return commandeService.findByref(ref);
    }

    @GetMapping("/getbylivreur/{id}")
    public List<Commande>getbyLivreur(@PathVariable("id")Long id){
        return commandeService.findByLivreurId(id);
    }

    @PostMapping("/newcommande/{idM}/{idSL}/{idP}")
    public Commande create(@PathVariable("idM") Long idM,@PathVariable("idSL") Long idSL,@PathVariable("idP")Long idP, @RequestBody Commande commande){
        return commandeService.createCommande(idM,idSL,idP,commande);
    }

    @PutMapping("/setlivreur/{idC}/{idL}")
    public Commande setLivreur(@PathVariable("idC")Long idC,@PathVariable("idL")Long idL){
       return commandeService.setLivreurCommande(idC,idL);
    }

    @PutMapping("/etatcom/{idC}")
    public Commande setEtat(@PathVariable("idC")Long idC, @RequestBody String etat){
        return commandeService.updateEtat(idC,etat);
    }

    @DeleteMapping("/deletecom/{id}")
    public void deleteCom(@PathVariable("id") Long id){
        commandeService.deleteCommandeById(id);
    }


}
