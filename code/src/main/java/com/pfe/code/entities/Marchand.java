package com.pfe.code.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


public class Marchand extends Utilisateur{
    public  boolean isactive;
    @JsonIgnore

@OneToMany(mappedBy = "marchand")
    private List<Commande> commandes;

}
