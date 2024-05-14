package com.pfe.code.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Livreur extends Utilisateur{
    private String matricule;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "serviceLivraison_id")
    private ServiceLivraison serviceLivraison;

    @OneToMany(mappedBy = "livreur")
    private List<Commande> commandesLivreur;
}
