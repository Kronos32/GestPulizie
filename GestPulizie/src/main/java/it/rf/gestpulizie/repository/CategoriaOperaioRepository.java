package it.rf.gestpulizie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.CategoriaOperaio;

@Repository
public interface CategoriaOperaioRepository extends JpaRepository<CategoriaOperaio, Long> {

	public Optional<CategoriaOperaio> findByNomeCategoria(String nomeCategoria);
}
