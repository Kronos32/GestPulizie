package it.rf.gestpulizie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long>{

	
	
	@Query(value="select sede.* from sede, app_sede where sede.id_sede=app_sede.id_sede and cf_cliente= :cfCLiente", nativeQuery=true)
	public List<Sede> selezionaSedeAssociata(@Param("cfCLiente") String cfCliente);
	
	
	@Query(value="SELECT max(sede.id_sede), sede.* "
			+ "from sede "
			+ "WHERE "
			+ "sede.nome_sede=?1", nativeQuery = true)
	public List<Sede>ricercaSedeNomeSede(String nomeSede);
}
