package it.rf.gestpulizie.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Eformata;

@Repository
public interface EformataRepository extends JpaRepository<Eformata, Long> {
	
	@Query(value="SELECT COUNT(cf_operaio) "
			+ "from eformata "
			+ "where eformata.id_squadra = ?1", nativeQuery = true)
	public Integer contPerCfOp(Long idSquadra);
}
