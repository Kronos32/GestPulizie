package it.rf.gestpulizie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.Cliente;

@Repository
public interface ClientiRepository extends JpaRepository<Cliente, String>{
	
	@Query(value="SELECT cliente.* FROM cliente WHERE  psw_cliente= ?2  and username_cliente= ?1", nativeQuery = true)
	public Optional<Cliente> ricUserPswCli( String usernameCliente, String pswCliente);

}
