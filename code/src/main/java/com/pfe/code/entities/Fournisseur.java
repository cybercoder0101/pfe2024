package com.pfe.code.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
    @OneToMany(mappedBy = "fournisseur",fetch = FetchType.EAGER)
    private List<Produit> produits;

}
