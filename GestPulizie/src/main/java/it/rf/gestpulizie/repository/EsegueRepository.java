package it.rf.gestpulizie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Esegue;

@Repository
public interface EsegueRepository extends JpaRepository<Esegue, Long>{

	@Query(value="SELECT esegue.* "
			+ "FROM esegue "
			+ "WHERE id_lavorazione  = ?1", nativeQuery = true)
	public Optional<Esegue> ricercaIdLav(Long idLavorazione);
}