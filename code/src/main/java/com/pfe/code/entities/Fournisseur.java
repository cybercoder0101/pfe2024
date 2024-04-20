package com.pfe.code.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Entity

@NoArgsConstructor
@AllArgsConstructor


public class Fournisseur extends Utilisateur{

    private String description;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "fournisseur_produit", joinColumns = @JoinColumn(name = "fournisseur_id"), inverseJoinColumns = @JoinColumn(name = "produit_id"))
    private List<Produit> produits;
    private boolean etat;
}
