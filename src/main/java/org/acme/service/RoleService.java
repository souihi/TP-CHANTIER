package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.ws.rs.WebApplicationException;
import org.acme.entity.Role;

import org.acme.repository.RoleRepository;

import java.util.List;
import java.util.Set;

@ApplicationScoped
public class RoleService {
    @Inject
    RoleRepository roleRepository;

    @Transactional
    public List<Role> listRole(){
        return roleRepository.listAll();
    }

    @Transactional
    public Role listRoleById(long id){
        return roleRepository.findById(id);
    }

    @Transactional
    public void createRole(Role role){
        // Validation des données
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Role>> violations = validator.validate(role);
        if (!violations.isEmpty()) {
            // Gérer les violations
            throw new ConstraintViolationException(violations);
        }
        roleRepository.persist(role);
    }

    @Transactional
    public void updateRole(long id, Role role){
        Role existingRole = roleRepository.findById(id);
        if (existingRole == null){
            throw new WebApplicationException("Role not found", 404);
        }
        existingRole.setDesignation(role.getDesignation());
        roleRepository.persist(role);
    }

    @Transactional
    public void deleteRole(long id){
        Role existingRole = roleRepository.findById(id);
        if (existingRole == null){
            throw new WebApplicationException("Role not found",404);
        }
        roleRepository.delete(existingRole);
    }
}
