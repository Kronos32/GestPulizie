package it.rf.gestpulizie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Squadra;
import it.rf.gestpulizie.repository.SquadraRepository;

@Service
public class SquadraService {
	
	
	@Autowired
	private SquadraRepository sR;
	
	
	public boolean creaSquadra(Squadra sq, String nomeSquadra)
	{
		Optional<Squadra> sqTrov=sR.findByNomeSquadra(nomeSquadra);
		if(sqTrov.isPresent())
		{
			return false;
		}
		else
		{
			sR.save(sq);
			return true;
		}
	}
	
	
	
	public Optional<Squadra> cercaSquadraId(Long idSquadra)
	{
		Optional<Squadra>squadraTrovata=this.sR.findById(idSquadra);
		return squadraTrovata;

	}
	
	
	public Squadra SeleSquadraFinta()
	{
		return sR.selezionaSquadraFinta();
	}
	
	
	
	public List<Squadra> cercaSquadra()
	{
		return sR.findAll();
	}

}
