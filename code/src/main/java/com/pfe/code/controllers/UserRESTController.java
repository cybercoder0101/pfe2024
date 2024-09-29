package com.pfe.code.controllers;

import com.pfe.code.entities.Utilisateur;
import com.pfe.code.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserRESTController {
    @Autowired
    UserService userService;

@PreAuthorize("hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAnyAuthority('ADMIN','SERVICE_LIVRAISON')")
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id")Long id){
        userService.deleteUserByid(id);
    }

    @PutMapping("/changepassword/{id}")
    public Utilisateur change(@PathVariable("id")Long id,@RequestBody String change){
       return userService.changepasseword(id,change);
    }

    @PutMapping("/updateinfosuser")
    public Utilisateur update(@RequestBody Utilisateur u){
    return userService.updateinfos(u);
    }
}
