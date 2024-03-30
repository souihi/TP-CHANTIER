package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.ws.rs.WebApplicationException;
import org.acme.entity.Chantier;
import org.acme.repository.ChantierRepository;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class ChantierService {

    @Inject
    ChantierRepository chantierRepository;


    @Transactional
    public List<Chantier> listChantier(){
        return chantierRepository.listAll();
    }

    @Transactional
    public void creatChantier(Chantier chantier){
        // Validation des données
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Chantier>> violations = validator.validate(chantier);
        if (!violations.isEmpty()) {
            // Gérer les violations
            throw new ConstraintViolationException(violations);
        }
        chantierRepository.persist(chantier);
    }

    @Transactional
    public Chantier listChantierById(long id){
        return chantierRepository.findById(id);
    }

    @Transactional
    public void updateChantier(long id, Chantier updatedChantier){
        Chantier existingChantier = chantierRepository.findById(id);
        if (existingChantier == null){
            throw new WebApplicationException("Chantier not found", 404);
        }
        existingChantier.setNom(updatedChantier.getNom());
        existingChantier.setAdresse(updatedChantier.getAdresse());
        existingChantier.setProprietaire(updatedChantier.getProprietaire());
        existingChantier.setDirecteur(updatedChantier.getDirecteur());

        chantierRepository.persist(existingChantier);
    }

    @Transactional
    public void deleteChantier(long id){
        Chantier existingChantier = chantierRepository.findById(id);
        if (existingChantier == null){
            throw new WebApplicationException("Chantier not found", 404);
        }
        chantierRepository.delete(existingChantier);
    }
}
