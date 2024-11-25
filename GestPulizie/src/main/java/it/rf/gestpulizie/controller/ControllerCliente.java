package it.rf.gestpulizie.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rf.gestpulizie.model.Cliente;
import it.rf.gestpulizie.service.ClienteService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/gestCliente")
public class ControllerCliente {

	
	@Autowired
	private ClienteService cS;
	
	@PostMapping("/inserisciCliente")
	public String insertCliente(@ModelAttribute Cliente cli, @RequestParam String cfCliente)
	{
		Boolean clienteInserito=cS.inserisciCliente(cli, cfCliente);
		if(clienteInserito==true)
		{
			return "Cliente inserito con successo";
		}
		else
		{
			return "Cliente già presente";
		}
	}
	
	
	
	@GetMapping("/ricercaCliente")
	public Cliente ricercaCliente(@RequestParam() String cfCliente) {
		
		Optional<Cliente> cli=cS.ricercaClienteCf(cfCliente);
		return cli.get();
	}
	
	
	
	
	@DeleteMapping("/eliminaCliente")
	public String eliminaCliente(@RequestParam String cfCliente)
	{
		Optional<Cliente> cli=cS.ricercaClienteCf(cfCliente);
		if(cli.isPresent())
		{
			Cliente cliente=cli.get();
			cS.eliminaCliente(cliente);
			return "Cliente eliminato con successo";
		}
		else
		{
			return "Il cliente non è presente";
		}
	}
	
	
	
	@PutMapping("/aggiornaTuttoCliente")
	public String aggiornaTuttoCliente(@RequestParam String cfCliente, String nomeCliente,
			String cognomeCliente, String usernameCliente, String pswCliente)	
	{
		Optional<Cliente> cli=cS.ricercaClienteCf(cfCliente);
		if(cli.isPresent())
		{
			Cliente cliente=cli.get();
			cliente.setCognomeCliente(cognomeCliente);
			cliente.setNomeCliente(nomeCliente);
			cliente.setPswCliente(pswCliente);
			cliente.setUsernameCliente(usernameCliente);
			cS.modificaCliente(cliente);
			return "Cliente aggiornato con successo";
		}
		else
		{
			return "Il cliente non è presente";
		}
	}
	
	
	@PatchMapping("/aggiornaCampoCliente")
	public String aggiornaCampoCliente(@RequestParam String cfCliente, String pswCliente)	
	{
		Optional<Cliente> cli=cS.ricercaClienteCf(cfCliente);
		if(cli.isPresent())
		{
			Cliente cliente=cli.get();
			cliente.setPswCliente(pswCliente);
			cS.modificaCliente(cliente);
			return "Cliente aggiornato con successo";
		}
		else
		{
			return "Il cliente non è presente";
		}
	}
	
}
