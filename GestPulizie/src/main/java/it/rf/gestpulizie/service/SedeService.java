package it.rf.gestpulizie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Sede;
import it.rf.gestpulizie.repository.SedeRepository;

@Service
public class SedeService {

	@Autowired
	private SedeRepository sR;
	
	
	public void aggiungiSede(Sede sede)
	{
		
			this.sR.save(sede);
		
	}
	
	
	public Optional<Sede> ricercaSedeId( Long idSede)
	{
		return this.sR.findById(idSede);
	
			
	}
	
	
	public List<Sede> ricercaSedeCfCliente(String cfCliente)
	{
		return this.sR.selezionaSedeAssociata(cfCliente);
	}
	
	
	public List<Sede> ricercaSede()
	{
		return sR.findAll();
	}
	
	
	
	public List<Sede>ricercaSedeNomeSede(String nomeSede)
	{
		return sR.ricercaSedeNomeSede(nomeSede);
	}
	
	
}

