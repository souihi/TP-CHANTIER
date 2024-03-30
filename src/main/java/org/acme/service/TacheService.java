package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.ws.rs.WebApplicationException;
import org.acme.entity.Tache;

import org.acme.repository.TacheRepository;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class TacheService {

    @Inject
    TacheRepository  tacheRepository;

    @Transactional
    public List<Tache> listTache(){
        return tacheRepository.listAll();
    }

    @Transactional
    public Tache listTacheById(long id){
        return tacheRepository.findById(id);
    }

    @Transactional
    public void createTache(Tache tache){
        // Validation des données
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Tache>> violations = validator.validate(tache);
        if (!violations.isEmpty()) {
            // Gérer les violations
            throw new ConstraintViolationException(violations);
        }
        tacheRepository.persist(tache);
    }

    @Transactional
    public void updateTache(long id, Tache updateTache){
        Tache existingTache = tacheRepository.findById(id);
        if (existingTache == null){
            throw new WebApplicationException("Tache not found", 404);
        }
        existingTache.setNom(updateTache.getNom());
        existingTache.setTemps(updateTache.getTemps());
        tacheRepository.persist(updateTache);
    }

    @Transactional
    public void deleteTache(long id){
        Tache existingTache = tacheRepository.findById(id);
        if (existingTache == null){
            throw new WebApplicationException("Tache not found", 404);
        }
        tacheRepository.delete(existingTache);
    }
}
