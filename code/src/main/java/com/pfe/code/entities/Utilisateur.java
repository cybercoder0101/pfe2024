package com.pfe.code.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long Id;
   private String nom;
   private String prenom;
   private String telephone;
   private String password;
   @Column(unique = true)
   private String email;
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "adresse")
   private Adresse adresse;
   @Enumerated(EnumType.STRING)
   private Role role;




}
