package it.rf.gestpulizie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.model.AppSede;

@Repository
public interface AppSedeRepository extends JpaRepository<AppSede, Long> {

}
