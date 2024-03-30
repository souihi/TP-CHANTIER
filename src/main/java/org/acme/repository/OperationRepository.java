package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Operation;

@ApplicationScoped
public class OperationRepository implements PanacheRepository<Operation> {
}
