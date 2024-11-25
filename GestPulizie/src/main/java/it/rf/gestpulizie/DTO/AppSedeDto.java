package it.rf.gestpulizie.DTO;

import java.sql.Date;

public class AppSedeDto {
	private Long idSede;
	private String cfCliente;
	private String nomeCliente;
	private String cognomeCliente;
	private Long idLavorazione;
	private Date dataPrevistaLavorazione;
	
	
	public AppSedeDto() {}


	public AppSedeDto(Long idSede, String cfCliente, String nomeCliente, String cognomeCliente, Long idLavorazione, Date dataPrevistaLavorazione) {
		super();
		this.idSede = idSede;
		this.cfCliente = cfCliente;
		this.nomeCliente = nomeCliente;
		this.cognomeCliente = cognomeCliente;
		this.idLavorazione=idLavorazione;
		this.dataPrevistaLavorazione=dataPrevistaLavorazione;
	}


	
	
	
	
	public Long getIdSede() {
		return idSede;
	}


	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}


	public String getCfCliente() {
		return cfCliente;
	}


	public void setCfCliente(String cfCliente) {
		this.cfCliente = cfCliente;
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


	public Long getIdLavorazione() {
		return idLavorazione;
	}


	public void setIdLavorazione(Long idLavorazione) {
		this.idLavorazione = idLavorazione;
	}


	public Date getDataPrevistaLavorazione() {
		return dataPrevistaLavorazione;
	}


	public void setDataPrevistaLavorazione(Date dataPrevistaLavorazione) {
		this.dataPrevistaLavorazione = dataPrevistaLavorazione;
	}
	
	
	
	
	
}
