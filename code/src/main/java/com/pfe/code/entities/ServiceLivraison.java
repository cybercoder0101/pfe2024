package com.pfe.code.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor


public class ServiceLivraison extends Utilisateur{


    @OneToMany(mappedBy = "serviceLivraison", fetch = FetchType.EAGER)

    private List<Livreur> livreurs;
}
