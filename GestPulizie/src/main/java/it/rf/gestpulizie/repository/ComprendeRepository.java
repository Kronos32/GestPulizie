package it.rf.gestpulizie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Comprende;

@Repository
public interface ComprendeRepository extends JpaRepository<Comprende, Long> {
	
	@Query(value="select sum(servizio.min_servizio) "
			+ "from servizio, lavorazione, comprende "
			+ "where "
			+ "servizio.id_servizio = comprende.id_servizio "
			+ "AND "
			+ "comprende.id_lavorazione=lavorazione.id_lavorazione "
			+ "AND "
			+ "lavorazione.id_lavorazione= ?1", nativeQuery = true)
	
	public Integer totMinLav(Long idLavorazione);
	
	
	
	@Query(value="SELECT comprende.* "
			+ "from comprende "
			+ "where comprende.id_lavorazione = ?1 ", nativeQuery = true)
	public List<Comprende> selectByIdLavorazione(Long idLavorazione);
	
	
	
	@Query(value="select sum(servizio.prezzo_servizio) "
			+ "from servizio, lavorazione, comprende "
			+ "where "
			+ "servizio.id_servizio = comprende.id_servizio "
			+ "AND "
			+ "comprende.id_lavorazione=lavorazione.id_lavorazione "
			+ "AND "
			+ "lavorazione.id_lavorazione= ?1", nativeQuery = true)
	
	public Double totPrezzoLav(Long idLavorazione);

}
