package com.pfe.code.controllers;

import com.pfe.code.entities.Etat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/etats")
public class EtatCommandeRESTController {
    @GetMapping("/all")
    public List<Etat> getAll(){
        List<Etat> etats = Arrays.asList(Etat.values());
        return etats;
    }


}
