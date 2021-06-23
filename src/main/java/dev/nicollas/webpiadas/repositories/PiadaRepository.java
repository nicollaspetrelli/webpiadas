package dev.nicollas.webpiadas.repositories;

import dev.nicollas.webpiadas.domain.Piada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiadaRepository extends JpaRepository<Piada, Integer> {
}
