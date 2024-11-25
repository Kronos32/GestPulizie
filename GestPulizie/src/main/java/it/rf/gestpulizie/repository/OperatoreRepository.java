package it.rf.gestpulizie.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Operaio;

@Repository
public interface OperatoreRepository extends JpaRepository<Operaio, String> {

	@Query(  value="SELECT *FROM operaio WHERE nome_operaio= :nomeOperaio and cognome_operaio= :cognomeOperaio", nativeQuery=true )
	 List<Operaio> findByNomeAndCognome(@Param("nomeOperaio") String nomeOperaio, @Param("cognomeOperaio") String cognomeOperaio);
	
	@Query(value = "SELECT operaio.* FROM operaio "
	        + "LEFT JOIN ( "
	        + "    SELECT eformata.cf_operaio "
	        + "    FROM squadra "
	        + "    JOIN eformata ON eformata.id_squadra = squadra.id_squadra "
	        + "    WHERE squadra.data_operativita = :dataOperativita "
	        + ") AS partecipanti ON partecipanti.cf_operaio = operaio.cf_operaio "
	        + "WHERE partecipanti.cf_operaio IS NULL "
	        + "AND operaio.stato_operativita = 1", nativeQuery = true)
	List<Operaio> selectOpLibero(@Param("dataOperativita") Date dataOperativita);
	
	
	@Query(value="SELECT operaio.* FROM operaio WHERE  psw_operaio= :pswOperaio and username_operaio= :usernameOperaio", nativeQuery = true)
	public Optional<Operaio> ricUserPswOp(@Param("usernameOperaio") String usernameOperaio, @Param("pswOperaio") String pswOperaio);
}
