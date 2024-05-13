package com.pfe.code.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProd;
    private String nomProd;
    private Double prixProd;
    private String descriptionPro;
    private Long quantite= 400L;
    private Date datecreation;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fourniseur_id")
    private Fournisseur fournisseur;

    @ManyToOne
    private Categorie categorie;
    @ManyToOne
    private SousCategorie sousCategorie;

    @OneToMany(mappedBy = "produit")
    private List<Image> images;


}
