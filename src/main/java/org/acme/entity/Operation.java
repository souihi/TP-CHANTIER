package org.acme.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


@Entity
public class Operation {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Le nom ne peut pas être null")
    @Size(min = 2, max = 30, message = "Le nom doit contenir entre 2 et 30 caractères")
    public String nom;
    @NotBlank(message = "La date ne peut pas être null")
    @Size(min = 2, max = 30, message = "La date doit contenir entre 2 et 30 caractères")
    public LocalDate date;

    @ManyToOne
    @JoinColumn(name = "chantier_id")
    Chantier chantier;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "tache_id")
    Tache tache;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
}
