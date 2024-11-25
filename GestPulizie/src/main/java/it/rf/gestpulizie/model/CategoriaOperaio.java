package it.rf.gestpulizie.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class CategoriaOperaio {
	@Column
	private String nomeCategoria;
	@Column
	private Double stipendioCategoria;
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	
	@Column
	@OneToMany(mappedBy = "opCat")
	private List<Operaio> elencoOperaio;

	
	
	
	
	
	public CategoriaOperaio() {}


	public CategoriaOperaio(String nomeCategoria, Double stipendioCategoria, Long idCategoria,
			List<Operaio> elencoOperaio) {
		super();
		this.nomeCategoria = nomeCategoria;
		this.stipendioCategoria = stipendioCategoria;
		this.idCategoria = idCategoria;
		this.elencoOperaio = elencoOperaio;
	}






	public String getNomeCategoria() {
		return nomeCategoria;
	}


	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}


	public Double getStipendioCategoria() {
		return stipendioCategoria;
	}


	public void setStipendioCategoria(Double stipendioCategoria) {
		this.stipendioCategoria = stipendioCategoria;
	}


	public Long getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}


	public List<Operaio> getElencoOperaio() {
		return elencoOperaio;
	}


	public void setElencoOperaio(List<Operaio> elencoOperaio) {
		this.elencoOperaio = elencoOperaio;
	}
	
	
	
	
	

}
