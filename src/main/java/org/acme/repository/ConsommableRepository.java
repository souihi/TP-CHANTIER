package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Consommable;
@ApplicationScoped
public class ConsommableRepository implements PanacheRepository<Consommable> {
}
