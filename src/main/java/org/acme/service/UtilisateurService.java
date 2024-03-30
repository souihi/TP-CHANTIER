package org.acme.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.ws.rs.WebApplicationException;
import org.acme.entity.Utilisateur;
import org.acme.repository.UtilisateurRepository;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class UtilisateurService {
    @Inject
    UtilisateurRepository utilisateurRepository;

    @Transactional
    public List<Utilisateur> utilisateurList(){
        return utilisateurRepository.listAll();
    }
    @Transactional
    public Utilisateur listUtilidateurById(long id){
        return utilisateurRepository.findById(id);
    }
    @Transactional
    public void creatUtilisateur(Utilisateur utilisateur){
        // Validation des données
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Utilisateur>> violations = validator.validate(utilisateur);
        if (!violations.isEmpty()) {
            // Gérer les violations
            throw new ConstraintViolationException(violations);
        }
        utilisateurRepository.persist(utilisateur);
    }

    @Transactional
    public void updateUtilisateur(long id, Utilisateur updateUtilisateur){
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id);
        if (existingUtilisateur == null){
            throw new WebApplicationException("User not found", 404);
        }
        existingUtilisateur.setNom(updateUtilisateur.getNom());
//        existingUtilisateur.setMotDePasse(updateUtilisateur.getMotDePasse());
        utilisateurRepository.persist(existingUtilisateur);
    }

    @Transactional
    public void deleteUtilisateur(long id){
        Utilisateur existingUtilisateur = utilisateurRepository.findById(id);
        if (existingUtilisateur == null){
            throw new WebApplicationException("User not found", 404);
        }
        utilisateurRepository.delete(existingUtilisateur);
    }
}
