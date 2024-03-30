package org.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "La désignation ne peut pas être null")
    @Size(min = 2, max = 30, message = "La désignation doit contenir entre 2 et 30 caractères")
    public String designation;

    @OneToMany(mappedBy = "role")
    List<Utilisateur> utilisateurs;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
