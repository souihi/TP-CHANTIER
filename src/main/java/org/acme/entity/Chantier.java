package org.acme.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Chantier {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Le nom ne peut pas être null")
    @Size(min = 2, max = 30, message = "Le nom doit contenir entre 2 et 30 caractères")
    public String nom;
    @NotBlank(message = "L'adresse ne peut pas être null")
    @Size(min = 2, max = 30, message = "L'adresse doit contenir entre 2 et 30 caractères")
    public String adresse;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    public Utilisateur proprietaire;
    @ManyToOne()
    @JoinColumn(name = "directeur_id")
    public Utilisateur directeur;

    @OneToMany(mappedBy = "chantier")
    List<Operation> operations;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Utilisateur getDirecteur() {
        return directeur;
    }

    public void setDirecteur(Utilisateur directeur) {
        this.directeur = directeur;
    }
}
