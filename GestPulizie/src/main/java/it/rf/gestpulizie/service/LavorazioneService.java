package it.rf.gestpulizie.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.DTO.ComprendeDto;
import it.rf.gestpulizie.model.Lavorazione;
import it.rf.gestpulizie.repository.LavorazioneRepository;

@Service
public class LavorazioneService {

	@Autowired
	private LavorazioneRepository lR;
	
	
	public void aggiungiLavorazione(Lavorazione lav)
	{
		this.lR.save(lav);
	}
	
	
	public Optional<Lavorazione>ricercaLavorazioneId(Long idLavorazione)
	{
		return this.lR.findById(idLavorazione);
	}
	
	
	public List<Lavorazione> ricercaLavorazione()
	{
		return lR.findAll();
	}
	
	
	
	public void modificaLavorazione(Lavorazione lav)
	{
		lR.save(lav);
	}
	
	
	public List<ComprendeDto> ottieniListaDto(String cfOperaio)
	{
		return lR.selezionePar(cfOperaio);
	}
	

	public List<ComprendeDto> ottieniListaDtoCliente(String cfCliente)
	{
		return lR.selezionePerCliente(cfCliente);
	}
	
	
	public void cancellaLavorazione(Long idLavorazione)
	{
		lR.deleteById(idLavorazione);
	}
	
	
	public List<ComprendeDto>selezionaTutto()
	{
		return lR.selezioneTuttto();
		
	}
	
	
	public List<ComprendeDto>ottieniListaDtoIdLav(Long idLav)
	{
		return lR.selezionePerIdLav(idLav);
	}
	
	
	
	public List<ComprendeDto>selezioneIntervalloDate(String cfOperaio, Date primaData, Date secondaData)
	{
		return lR.selezioneIntervalloDate(cfOperaio, primaData, secondaData);
	}
	
	
	
}
