package it.rf.gestpulizie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Servizio;
import it.rf.gestpulizie.repository.ServiziRepository;

@Service
public class ServiziService {

	@Autowired
	private ServiziRepository serR;
	
	public Optional<Servizio>ricercaServizioNome(String nomeServizio)
	{
		return this.serR.findBynomeServizio(nomeServizio);
	}
	
	
	public List<Servizio>ricercaServizio()
	{
		return this.serR.findAll();
	}
	
	
	
	public Optional<Servizio>ricercaServizioId(Long idServizio)
	{
		return this.serR.findById(idServizio);
	}
	
	
	public void aggiornaServizio (Servizio serv)
	{
		serR.save(serv);
	}

	
	public Boolean inserisciServizio(Servizio serv, String nomeServizio)
	{
		Optional <Servizio> nomeTrovato = serR.findBynomeServizio(nomeServizio);
		if(nomeTrovato.isPresent())
		{
			return false;
		}
		else
		{
			serR.save(serv);
			return true;
				
		}
	}
	
	
}

