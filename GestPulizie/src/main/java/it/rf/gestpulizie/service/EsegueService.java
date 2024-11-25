package it.rf.gestpulizie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Esegue;
import it.rf.gestpulizie.repository.EsegueRepository;

@Service
public class EsegueService {
	@Autowired
	private EsegueRepository eR;

	public void aggiungiEsegue(Esegue Es)
	{
		eR.save(Es);
	}
	
	
	public Optional<Esegue> ricercaEsegueId(Long idEsegue)
	{
		return eR.findById(idEsegue);
	}
	
	
	public Optional<Esegue> ricercaIdLav(Long idLavorazione)
	{
		return eR.ricercaIdLav(idLavorazione);
	}
	
}
