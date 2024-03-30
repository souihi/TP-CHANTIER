package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.ws.rs.WebApplicationException;
import org.acme.entity.Consommable;

import org.acme.repository.ConsommableRepository;


import java.util.List;
import java.util.Set;

@ApplicationScoped
    public class ConsommableService {
        @Inject
        ConsommableRepository consommableRepository;

        @Transactional
        public List<Consommable> listConsommable(){
            return consommableRepository.listAll();
        }

        @Transactional
        public Consommable listConsommableById(long id){
            return consommableRepository.findById(id);
        }

        @Transactional
        public void createConsommable(Consommable consommable){
            // Validation des données
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Consommable>> violations = validator.validate(consommable);
            if (!violations.isEmpty()) {
                // Gérer les violations
                throw new ConstraintViolationException(violations);
            }
            consommableRepository.persist(consommable);
        }

        @Transactional
        public void updateConsommable(long id, Consommable updateConsommable){
            Consommable existingConsommable = consommableRepository.findById(id);
            if (existingConsommable == null){
                throw new WebApplicationException("Consommable not found", 404);
            }
            existingConsommable.setNom(updateConsommable.getNom());
            consommableRepository.persist(updateConsommable);
        }

        @Transactional
        public void delete(long id){
            Consommable existingConsommable = consommableRepository.findById(id);
            if (existingConsommable == null){
                throw new WebApplicationException("Consommable not found", 404);
            }
            consommableRepository.delete(existingConsommable);
        }
    }
