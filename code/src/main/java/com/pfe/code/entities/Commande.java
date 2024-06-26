package com.pfe.code.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private Date dateCommande;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "marchand_id")
    private Marchand marchand;



    @JsonIgnore

    @ManyToOne
    @JoinColumn(name = "service_livraison_id")
    private ServiceLivraison serviceLivraison;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "livreur_id")
    private Livreur livreur;




    @Enumerated(EnumType.STRING)
    private Etat etat;




}
