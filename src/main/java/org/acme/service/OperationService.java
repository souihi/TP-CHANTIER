package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.ws.rs.WebApplicationException;
import org.acme.entity.Operation;

import org.acme.repository.OperationRepository;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class OperationService {
    @Inject
    OperationRepository operationRepository;

    @Transactional
    public List<Operation> listOperation(){
        return operationRepository.listAll();
    }

    @Transactional
    public Operation operationById(long id){
        return operationRepository.findById(id);
    }

    @Transactional
    public void creatOperation(Operation operation){
        // Validation des données
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Operation>> violations = validator.validate(operation);
        if (!violations.isEmpty()) {
            // Gérer les violations
            throw new ConstraintViolationException(violations);
        }
        operationRepository.persist(operation);
    }

    @Transactional
    public void updateOperation(long id, Operation updateOperation){
        Operation existingOperation = operationRepository.findById(id);
        if (existingOperation == null){
            throw new WebApplicationException("Operation not found", 404);
        }
        existingOperation.setNom(updateOperation.getNom());
        existingOperation.setDate(updateOperation.getDate());
        existingOperation.setChantier(updateOperation.getChantier());
        existingOperation.setUtilisateur(updateOperation.getUtilisateur());
        existingOperation.setTache(existingOperation.getTache());
        operationRepository.persist(existingOperation);
    }

    @Transactional
    public void deleteOperation(long id){
        Operation existingOperation = operationRepository.findById(id);
        if (existingOperation == null){
            throw new WebApplicationException("Operation not found", 404);
        }
        operationRepository.delete(existingOperation);
    }
}
