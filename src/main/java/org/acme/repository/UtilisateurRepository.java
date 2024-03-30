package org.acme.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.acme.entity.Utilisateur;

@ApplicationScoped
public class UtilisateurRepository implements PanacheRepository<Utilisateur> {
}
