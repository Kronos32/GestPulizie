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
public class Servizio {
	@Column
	private String nomeServizio;
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServizio;
	
	@Column
	private Double prezzoServizio;
	
	@Column
	private String descrizioneServizio;
	
	@Column
	private Integer minServizio;
	
	
	@OneToMany(mappedBy = "servizioComprende")
	private List<Comprende> elencoServiziComprende;
	
	
	public Servizio() {}


	public Servizio(String nomeServizio, Long idServizio, Double prezzoServizio, String descrizioneServizio,
			List<Comprende> elencoServiziComprende, Integer minServizio) {
		super();
		this.nomeServizio = nomeServizio;
		this.idServizio = idServizio;
		this.prezzoServizio = prezzoServizio;
		this.descrizioneServizio = descrizioneServizio;
		this.elencoServiziComprende = elencoServiziComprende;
		this.minServizio=minServizio;
	}


	public String getNomeServizio() {
		return nomeServizio;
	}


	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;
	}


	public Long getIdServizio() {
		return idServizio;
	}


	public void setIdServizio(Long idServizio) {
		this.idServizio = idServizio;
	}


	public Double getPrezzoServizio() {
		return prezzoServizio;
	}


	public void setPrezzoServizio(Double prezzoServizio) {
		this.prezzoServizio = prezzoServizio;
	}


	public String getDescrizioneServizio() {
		return descrizioneServizio;
	}


	public void setDescrizioneServizio(String descrizioneServizio) {
		this.descrizioneServizio = descrizioneServizio;
	}


	public List<Comprende> getElencoServiziComprende() {
		return elencoServiziComprende;
	}


	public void setElencoServiziComprende(List<Comprende> elencoServiziComprende) {
		this.elencoServiziComprende = elencoServiziComprende;
	}


	public Integer getMinServizio() {
		return minServizio;
	}


	public void setMinServizio(Integer minServizio) {
		this.minServizio = minServizio;
	}
	

	
	
	
}
