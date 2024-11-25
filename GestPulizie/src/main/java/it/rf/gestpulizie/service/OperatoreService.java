package it.rf.gestpulizie.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.repository.OperatoreRepository;


@Service
public class OperatoreService {

	@Autowired
	private OperatoreRepository Or;
	
	
	
	public boolean inserisciOperaio(Operaio op,String cf)
	{
		Optional<Operaio> opTrovato=this.Or.findById(cf);
		if(opTrovato.isPresent())
		{
			return false;
		}
		else {
			this.Or.save(op);
			return true;
			
		}
		
	}
	
	
	
	
	public Optional<Operaio> ricercaOperaioCf(String cfOperaio)
	{
		
		Optional<Operaio> opTrovato=Or.findById(cfOperaio);
		if(opTrovato.isPresent())
		{
			System.out.println(cfOperaio);
			return opTrovato;
			
		}
		else {
			return null;
		}
	}
	
	
	
	public  List<Operaio> ricercaOperaioNomeCognome(Operaio op, String nomeOperaio, String cognomeOperaio)
	{
		
		return Or.findByNomeAndCognome(nomeOperaio, cognomeOperaio);
	}
	
	
	
	
	
	
	public boolean modificaOperaio(Operaio op, String cfOperaio, String nomeOperaio, String cognomeOperaio)
	{
		Optional<Operaio> opTrovato=this.Or.findById(cfOperaio);
		List <Operaio> opList=Or.findByNomeAndCognome(nomeOperaio, cognomeOperaio);
		if(opTrovato.isPresent())
		{
			this.Or.save(op);
			return true;
		}
		else if(opList.size()>0)
		{
			this.Or.save(op);
			return true;
		}
		else {
			
			return false;
			
		}
	}
	
	
	
	public boolean eliminaOperaio(Operaio op, String cfOperaio)	
	{
		Optional<Operaio> opTrovato=this.Or.findById(cfOperaio);
		if(opTrovato.isPresent())
		{
			this.Or.delete(op);
			return true;
		}
		else {
			
			return false;
			
		}
	}
	
	
	public List<Operaio> ricercaOperaioLibero( Date dataOperativita)
	{
		List<Operaio> o=this.Or.selectOpLibero(dataOperativita);
		return o;
	}
	
	
	public Optional<Operaio> ricOperaioUserPsw(String pswOperaio, String usernameOperaio)
	{
		return Or.ricUserPswOp(usernameOperaio, pswOperaio);
	}
	
	
	public List<Operaio>ricercaOperaioAll()
	{
		return Or.findAll();
	}
}
