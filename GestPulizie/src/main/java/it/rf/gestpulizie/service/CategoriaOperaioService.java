package it.rf.gestpulizie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.CategoriaOperaio;
import it.rf.gestpulizie.repository.CategoriaOperaioRepository;

@Service
public class CategoriaOperaioService {

	@Autowired
	private CategoriaOperaioRepository cO;
	
	
	public List<CategoriaOperaio> ricercaCategoriaAll()
	{
		List<CategoriaOperaio> opTrovato=cO.findAll();
			return opTrovato;

	}
	
	
	
	public Optional<CategoriaOperaio> ricercaCategoriaId(CategoriaOperaio cat,Long idCate)
	{
		Optional<CategoriaOperaio> catIdTrovato=this.cO.findById(idCate);
		if(catIdTrovato.isPresent())
		{
			return catIdTrovato;
		}
		else
		{
			return null;
		}
	}
	
	
	public Optional<CategoriaOperaio> ricercaCategoriaNome(CategoriaOperaio op, String nomeCategoria)
	{
		Optional<CategoriaOperaio> catNomeTrovato=this.cO.findByNomeCategoria(nomeCategoria);
			return catNomeTrovato;
		
				
	}
	
	
	
	public boolean inserisciCategoria(CategoriaOperaio cat, String nomeCategoria)
	{
		Optional<CategoriaOperaio> nomeTrovato=this.cO.findByNomeCategoria(nomeCategoria);
		if(nomeTrovato.isPresent())
		{
			return false;
		}
		else {
			this.cO.save(cat);
			return true;
			
		}
		
	}
	
	
	
	public boolean modificaCategoria(CategoriaOperaio cat, String nomeCategoria)
	{
		
		Optional <CategoriaOperaio> catDaModTrovata=cO.findByNomeCategoria(nomeCategoria);
		if(catDaModTrovata.isPresent())
		{
			this.cO.save(cat);
			return true;
		}
		else {
			
			return false;
			
		}
	}
	
	
	
	public boolean eliminaCategoria(CategoriaOperaio cat, Long idCategoria)
	{
		Optional<CategoriaOperaio> catDaEliminare=cO.findById(idCategoria);
		if(catDaEliminare.isPresent())
		{
			this.cO.delete(cat);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
