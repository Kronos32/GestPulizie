package it.rf.gestpulizie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Comprende;
import it.rf.gestpulizie.repository.ComprendeRepository;

@Service
public class ComprendeService {

	@Autowired
	private ComprendeRepository compR;
	
	
	public void insertCOmprende(Comprende comp)
	{
		compR.save(comp);
	}
	
	
	public List<Comprende>ricercaComprende()
	{
		return compR.findAll();
	}
	
	
	public void aggiornaComprende(Comprende comp)
	{

			compR.save(comp);
		
	}
	
	
	public Optional<Comprende>ricercaComprendeId(Long idComprende)
	{
		return compR.findById(idComprende);
	}
	
	
	public Integer totMinLav(Long idLavorazione)
	{
		return compR.totMinLav(idLavorazione);
	}
	
	public List<Comprende> ricercaByIdLav(Long idLavorazione)
	{
		return compR.selectByIdLavorazione(idLavorazione);
	}
	
	
	public Double totPrezzoLav(Long idLavorazione)
	{
		return compR.totPrezzoLav(idLavorazione);
	}
}
