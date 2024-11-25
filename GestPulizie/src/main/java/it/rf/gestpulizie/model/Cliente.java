package it.rf.gestpulizie.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Cliente {
	
	@Column
	private String nomeCliente;
	@Column
	private String cognomeCliente;
	@Column
	@Id
	private String cfCliente;
	@Column
	private String pswCliente;
	@Column
	private String usernameCliente;
	
	
	@OneToMany(mappedBy = "clienteApp")
	private List<AppSede> elencoClientiApp;
	
	
	public Cliente() {}


	public Cliente(String nomeCliente, String cognomeCliente, String cfCliente, List<AppSede> elencoClientiApp, String pswCliente, String usernameCliente) {
		super();
		this.nomeCliente = nomeCliente;
		this.cognomeCliente = cognomeCliente;
		this.cfCliente = cfCliente;
		this.elencoClientiApp = elencoClientiApp;
		this.pswCliente=pswCliente;
		this.usernameCliente=usernameCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getCognomeCliente() {
		return cognomeCliente;
	}


	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}


	public String getCfCliente() {
		return cfCliente;
	}


	public void setCfCliente(String cfCliente) {
		this.cfCliente = cfCliente;
	}


	public List<AppSede> getElencoClientiApp() {
		return elencoClientiApp;
	}


	public void setElencoClientiApp(List<AppSede> elencoClientiApp) {
		this.elencoClientiApp = elencoClientiApp;
	}


	public String getPswCliente() {
		return pswCliente;
	}


	public void setPswCliente(String pswCliente) {
		this.pswCliente = pswCliente;
	}


	public String getUsernameCliente() {
		return usernameCliente;
	}


	public void setUsernameCliente(String usernameCliente) {
		this.usernameCliente = usernameCliente;
	}
	
	
	
	

}
