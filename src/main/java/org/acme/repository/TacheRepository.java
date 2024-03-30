package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Tache;

@ApplicationScoped
public class TacheRepository implements PanacheRepository<Tache> {
}
