package org.acme.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
public class Consommable {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Le nom ne peut pas être null")
    @Size(min = 2, max = 30, message = "Le nom doit contenir entre 2 et 30 caractères")
    public String nom;

    @ManyToMany(mappedBy = "consommables")
    Set<Tache> taches;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
