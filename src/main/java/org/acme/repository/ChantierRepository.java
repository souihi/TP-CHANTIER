package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Chantier;

@ApplicationScoped
public class ChantierRepository implements PanacheRepository<Chantier> {
}
