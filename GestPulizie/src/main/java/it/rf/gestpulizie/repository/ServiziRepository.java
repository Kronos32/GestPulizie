package it.rf.gestpulizie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Servizio;

@Repository
public interface ServiziRepository extends JpaRepository<Servizio, Long> {

	Optional<Servizio> findBynomeServizio(String nomeServizio);
}
