package it.rf.gestpulizie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Squadra;

@Repository
public interface SquadraRepository extends JpaRepository<Squadra, Long> {

	public Optional<Squadra> findByNomeSquadra(String nomeSquadra);
	@Query(value="Select * from squadra where id_squadra=1", nativeQuery = true)
	public Squadra selezionaSquadraFinta();
}
