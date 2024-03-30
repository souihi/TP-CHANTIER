package org.acme.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

@Entity
public class Tache {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Le nom ne peut pas être null")
    @Size(min = 2, max = 30, message = "Le nom doit contenir entre 2 et 30 caractères")
    public String nom;
    @NotBlank(message = "Le temps ne peut pas être null")
    @Size(min = 2, max = 30, message = "Le temps doit contenir entre 2 et 30 caractères")
    public Integer temps;

    @OneToMany(mappedBy = "tache")
    List<Operation> operations;

    @ManyToMany
     @JoinTable(
             name = "tache_consommable",
             joinColumns = {@JoinColumn(name = "tache_id")},
             inverseJoinColumns = {@JoinColumn(name = "consommable_id")}
     )
    Set<Consommable> consommables;

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

    public Integer getTemps() {
        return temps;
    }

    public void setTemps(Integer temps) {
        this.temps = temps;
    }

    public void setConsommables(Set<Consommable> consommables) {
        this.consommables = consommables;
    }
}
