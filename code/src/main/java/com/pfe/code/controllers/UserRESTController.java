package com.pfe.code.controllers;

import com.pfe.code.entities.Utilisateur;
import com.pfe.code.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserRESTController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
     public List<Utilisateur> getAll(){
        return userService.getAll();
    }


    @GetMapping("/email/{email}")
    public  Utilisateur getByemail(@PathVariable("email") String email){
        return userService.getByEmail(email);
    }

    @GetMapping("/nomcont/{nom}")
    public List<Utilisateur>getnomContains(@PathVariable("nom") String nom){
        return userService.getByNomcontains(nom);
    }
}
