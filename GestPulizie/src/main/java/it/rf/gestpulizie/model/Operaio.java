package it.rf.gestpulizie.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table
public class Operaio {
	@Column
	private String nomeOperaio;
	@Column
	private String cognomeOperaio;
	@Id
	@Column
	private String cfOperaio;
	@Column
	private String usernameOperaio;
	@Column
	private String pswOperaio;
	@Column
	private Boolean statoOperativita;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private CategoriaOperaio opCat;
	
	
	
	@OneToMany(mappedBy = "opF")
	private List<Eformata> elencoEf;
	
	
	
	
	
	public Operaio() {}





	public Operaio(String nomeOperaio, String cognomeOperaio, String cfOperaio, String usernameOperaio,
			String pswOperaio, Boolean statoOperativita, CategoriaOperaio opCat, List<Eformata> elencoEf) {
		super();
		this.nomeOperaio = nomeOperaio;
		this.cognomeOperaio = cognomeOperaio;
		this.cfOperaio = cfOperaio;
		this.usernameOperaio = usernameOperaio;
		this.pswOperaio = pswOperaio;
		this.statoOperativita = statoOperativita;
		this.opCat = opCat;
		this.elencoEf = elencoEf;
	}





	public String getNomeOperaio() {
		return nomeOperaio;
	}





	public void setNomeOperaio(String nomeOperaio) {
		this.nomeOperaio = nomeOperaio;
	}





	public String getCognomeOperaio() {
		return cognomeOperaio;
	}





	public void setCognomeOperaio(String cognomeOperaio) {
		this.cognomeOperaio = cognomeOperaio;
	}





	public String getCfOperaio() {
		return cfOperaio;
	}





	public void setCfOperaio(String cfOperaio) {
		this.cfOperaio = cfOperaio;
	}





	public String getUsernameOperaio() {
		return usernameOperaio;
	}





	public void setUsernameOperaio(String usernameOperaio) {
		this.usernameOperaio = usernameOperaio;
	}





	public String getPswOperaio() {
		return pswOperaio;
	}





	public void setPswOperaio(String pswOperaio) {
		this.pswOperaio = pswOperaio;
	}





	public Boolean getStatoOperativita() {
		return statoOperativita;
	}





	public void setStatoOperativita(Boolean statoOperativita) {
		this.statoOperativita = statoOperativita;
	}





	public CategoriaOperaio getOpCat() {
		return opCat;
	}





	public void setOpCat(CategoriaOperaio opCat) {
		this.opCat = opCat;
	}





	public List<Eformata> getElencoEf() {
		return elencoEf;
	}





	public void setElencoEf(List<Eformata> elencoEf) {
		this.elencoEf = elencoEf;
	}
}
