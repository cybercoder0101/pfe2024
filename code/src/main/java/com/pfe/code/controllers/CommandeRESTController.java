package com.pfe.code.controllers;

import com.pfe.code.entities.Commande;
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

    @PostMapping("/newcommande/{idM}/{idSL}/{idP}")
    public Commande create(@PathVariable("idM") Long idM,@PathVariable("idSL") Long idSL,@PathVariable("idP")Long idP, @RequestBody Commande commande){
        return commandeService.createCommande(idM,idSL,idP,commande);
    }

}
