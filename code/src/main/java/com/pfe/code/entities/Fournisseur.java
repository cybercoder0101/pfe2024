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
    @OneToMany(mappedBy = "fournisseur",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Produit> produits;

}
