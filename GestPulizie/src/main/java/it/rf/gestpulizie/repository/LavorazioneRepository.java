package it.rf.gestpulizie.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.gestpulizie.DTO.ComprendeDto;
import it.rf.gestpulizie.model.Lavorazione;

@Repository
public interface LavorazioneRepository extends JpaRepository<Lavorazione, Long> {
	
	@Query(value = "SELECT new it.rf.gestpulizie.DTO.ComprendeDto(com.idComprende, serv.nomeServizio, "
			+ "com.fineEsecuzioneServizio, lav.dataPrevistaEsecuzione, com.descrizioneComprende, "
			+ "sed.nomeSede, sed.viaSede, sed.cittaSede, sed.pianoSede,lav.idLavorazione, ef.responsabileSquadra) "
			+ "FROM Comprende com "
			+ "JOIN com.servizioComprende serv "
			+ "JOIN com.lavComprende lav "
			+ "JOIN lav.elencoLavorazione es "
			+ "JOIN es.sedeEsegue sed "
			+ "JOIN es.sqEsegue sq "
			+ "JOIN sq.elencoEf ef "
			+ "JOIN ef.opF op "
			+ "where op.cfOperaio = ?1", nativeQuery = false)
	public List<ComprendeDto> selezionePar(String cfOperaio);
	
	
	@Query(value = "SELECT new it.rf.gestpulizie.DTO.ComprendeDto(com.idComprende, serv.nomeServizio, "
			+ "com.fineEsecuzioneServizio, lav.dataPrevistaEsecuzione, com.descrizioneComprende, "
			+ "sed.nomeSede, sed.viaSede, sed.cittaSede, sed.pianoSede,lav.idLavorazione, ef.responsabileSquadra) "
			+ "FROM Comprende com "
			+ "JOIN com.servizioComprende serv "
			+ "JOIN com.lavComprende lav "
			+ "JOIN lav.elencoLavorazione es "
			+ "JOIN es.sedeEsegue sed "
			+ "JOIN es.sqEsegue sq "
			+ "JOIN sq.elencoEf ef "
			+ "JOIN sed.elencoSedeApp app "
			+ "JOIN app.clienteApp cli "
			+ "where cli.cfCliente = ?1", nativeQuery = false)
	public List<ComprendeDto> selezionePerCliente(String cfCliente);
	
	
	
	@Query(value = "SELECT new it.rf.gestpulizie.DTO.ComprendeDto(com.idComprende, serv.nomeServizio, "
			+ "com.fineEsecuzioneServizio, lav.dataPrevistaEsecuzione, com.descrizioneComprende, "
			+ "sed.nomeSede, sed.viaSede, sed.cittaSede, sed.pianoSede,lav.idLavorazione, ef.responsabileSquadra) "
			+ "FROM Comprende com "
			+ "JOIN com.servizioComprende serv "
			+ "JOIN com.lavComprende lav "
			+ "JOIN lav.elencoLavorazione es "
			+ "JOIN es.sedeEsegue sed "
			+ "JOIN es.sqEsegue sq "
			+ "JOIN sq.elencoEf ef ", nativeQuery = false)
	public List<ComprendeDto> selezioneTuttto();
	
	
	@Query(value = "SELECT new it.rf.gestpulizie.DTO.ComprendeDto(com.idComprende, serv.nomeServizio, "
			+ "com.fineEsecuzioneServizio, lav.dataPrevistaEsecuzione, com.descrizioneComprende, "
			+ "sed.nomeSede, sed.viaSede, sed.cittaSede, sed.pianoSede,lav.idLavorazione, ef.responsabileSquadra) "
			+ "FROM Comprende com "
			+ "JOIN com.servizioComprende serv "
			+ "JOIN com.lavComprende lav "
			+ "JOIN lav.elencoLavorazione es "
			+ "JOIN es.sedeEsegue sed "
			+ "JOIN es.sqEsegue sq "
			+ "JOIN sq.elencoEf ef "
			+ "JOIN ef.opF op "
			+ "where lav.idLavorazione = ?1", nativeQuery = false)
	public List<ComprendeDto> selezionePerIdLav(Long idLavorazione);
	
	
	
	@Query(value = "SELECT new it.rf.gestpulizie.DTO.ComprendeDto(com.idComprende, serv.nomeServizio, "
			+ "com.fineEsecuzioneServizio, lav.dataPrevistaEsecuzione, com.descrizioneComprende, "
			+ "sed.nomeSede, sed.viaSede, sed.cittaSede, sed.pianoSede,lav.idLavorazione, ef.responsabileSquadra) "
			+ "FROM Comprende com "
			+ "JOIN com.servizioComprende serv "
			+ "JOIN com.lavComprende lav "
			+ "JOIN lav.elencoLavorazione es "
			+ "JOIN es.sedeEsegue sed "
			+ "JOIN es.sqEsegue sq "
			+ "JOIN sq.elencoEf ef "
			+ "JOIN ef.opF op "
			+ "where op.cfOperaio = ?1 "
			+ "AND lav.dataPrevistaEsecuzione "
			+ "BETWEEN ?2 AND ?3", nativeQuery = false)
	public List<ComprendeDto> selezioneIntervalloDate(String cfOperaio, Date primaData, Date secondaData);
	
	
}
