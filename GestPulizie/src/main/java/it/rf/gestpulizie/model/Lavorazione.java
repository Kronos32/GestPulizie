package it.rf.gestpulizie.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Lavorazione {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLavorazione;
	
	
	@Column
	private LocalDate dataPrenotazioneLavorazione;
	
	@Column
	private Date dataPrevistaEsecuzione;
	
	@Column
	private String descrizioneLavorazione;
	@Column
	private Double prezzoTotale;
	
	
	
	@OneToMany(mappedBy = "lavEsegue", cascade = CascadeType.ALL)
	private List<Esegue> elencoLavorazione;
	
	
	@OneToMany(mappedBy = "lavComprende")
	private List<Comprende> elencoLavComprende;
	
	
	
	public Lavorazione() {}



	public Lavorazione(Long idLavorazione, LocalDate dataPrenotazioneLavorazione, Date dataPrevistaEsecuzione,
			String descrizioneLavorazione, List<Esegue> elencoLavorazione, List<Comprende> elencoLavComprende,
			Double prezzoTotale) {
		super();
		this.idLavorazione = idLavorazione;
		this.dataPrenotazioneLavorazione = dataPrenotazioneLavorazione;
		this.dataPrevistaEsecuzione = dataPrevistaEsecuzione;
		this.descrizioneLavorazione = descrizioneLavorazione;
		this.elencoLavorazione = elencoLavorazione;
		this.elencoLavComprende = elencoLavComprende;
		this.prezzoTotale=prezzoTotale;
	}



	public Long getIdLavorazione() {
		return idLavorazione;
	}



	public void setIdLavorazione(Long idLavorazione) {
		this.idLavorazione = idLavorazione;
	}



	public LocalDate getDataPrenotazioneLavorazione() {
		return dataPrenotazioneLavorazione;
	}



	public void setDataPrenotazioneLavorazione(LocalDate dataPrenotazioneLavorazione) {
		this.dataPrenotazioneLavorazione = dataPrenotazioneLavorazione;
	}



	public Date getDataPrevistaEsecuzione() {
		return dataPrevistaEsecuzione;
	}



	public void setDataPrevistaEsecuzione(Date dataPrevistaEsecuzione) {
		this.dataPrevistaEsecuzione = dataPrevistaEsecuzione;
	}



	public String getDescrizioneLavorazione() {
		return descrizioneLavorazione;
	}



	public void setDescrizioneLavorazione(String descrizioneLavorazione) {
		this.descrizioneLavorazione = descrizioneLavorazione;
	}



	public List<Esegue> getElencoLavorazione() {
		return elencoLavorazione;
	}



	public void setElencoLavorazione(List<Esegue> elencoLavorazione) {
		this.elencoLavorazione = elencoLavorazione;
	}



	public List<Comprende> getElencoLavComprende() {
		return elencoLavComprende;
	}



	public void setElencoLavComprende(List<Comprende> elencoLavComprende) {
		this.elencoLavComprende = elencoLavComprende;
	}



	public Double getPrezzoTotale() {
		return prezzoTotale;
	}



	public void setPrezzoTotale(Double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}



	
	
	
	
	

}
