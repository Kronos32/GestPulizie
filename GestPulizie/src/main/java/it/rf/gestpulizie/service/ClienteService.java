package it.rf.gestpulizie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Cliente;
import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.repository.ClientiRepository;

@Service
public class ClienteService {

	@Autowired
	private ClientiRepository Cr;
	
	
	public List<Cliente> ricercaCliente()
	{
		
		List<Cliente> clienteTrovato=Cr.findAll();
		if(clienteTrovato.size()>0)
		{
			return clienteTrovato;
			
		}
		else {
			return null;
		}
	}
	
	
	
	public Optional<Cliente>ricercaClienteCf(String cfCliente)
	{
		
		return this.Cr.findById(cfCliente);
		
	}
	
	
	
	public Optional<Cliente> ricClienteUserPsw(String pswCliente, String usernameCliente)
	{
		return Cr.ricUserPswCli(usernameCliente, pswCliente);
	}
	
	
	
	public Boolean inserisciCliente(Cliente cli, String cfCliente)
	{
		Optional<Cliente> clienteDaRic=Cr.findById(cfCliente);
		if(clienteDaRic.isPresent())
		{
			return false;
		}
		else
		{
			Cr.save(cli);
			return true;
		}
	}
	
	
	
	public void modificaCliente(Cliente cli)
	{
			Cr.save(cli);
	
	}
	
	
	public void eliminaCliente(Cliente cli)
	{
		
			Cr.delete(cli);
		
	}
	
	
	
	public void registrazione(Cliente cli)
	{
		Cr.save(cli);
	}
}
