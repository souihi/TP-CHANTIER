package org.acme.entity;


import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Le nom ne peut pas être null")
    @Size(min = 2, max = 30, message = "Le nom doit contenir entre 2 et 30 caractères")
    public String nom;
    @NotNull(message = "Le mot de passe ne peut pas être null")
    @Size(min = 8, max = 30, message = "Le mot de passe doit contenir entre 8 et 30 caractères")
    public String motDePasse;

    @OneToMany(mappedBy = "proprietaire")
    List<Chantier> chantiersPossede;

    @OneToMany(mappedBy = "directeur")
    List<Chantier> chantiersDirige;

    @OneToMany(mappedBy = "utilisateur")
    List<Operation> operations;

    @ManyToOne
    Role role;

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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = BCrypt.hashpw(motDePasse, BCrypt.gensalt());
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
