package it.rf.gestpulizie.model;

import java.sql.Date;
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
public class Squadra {

	@Column
	private String nomeSquadra;

	@Column
	private String Descrizione;

	@Column
	private Date dataOperativita;

	@Column
	private Boolean squadraFinta;
	
	@Column
	private Integer minutiTotali;

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSquadra;

	@OneToMany(mappedBy = "sqF")
	private List<Eformata> elencoEf;

	@OneToMany(mappedBy = "sqEsegue")
	private List<Esegue> elencoEsegue;

	public Squadra() {}

	public Squadra(String nomeSquadra, String descrizione, Date dataOperativita, Boolean squadraFinta, Long idSquadra,
			List<Eformata> elencoEf, List<Esegue> elencoEsegue, Integer minutiTotali) {
		super();
		this.nomeSquadra = nomeSquadra;
		Descrizione = descrizione;
		this.dataOperativita = dataOperativita;
		this.squadraFinta = squadraFinta;
		this.idSquadra = idSquadra;
		this.elencoEf = elencoEf;
		this.elencoEsegue = elencoEsegue;
		this.minutiTotali=minutiTotali;
	}

	public String getNomeSquadra() {
		return nomeSquadra;
	}

	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}

	public Date getDataOperativita() {
		return dataOperativita;
	}

	public void setDataOperativita(Date dataOperativita) {
		this.dataOperativita = dataOperativita;
	}

	public Boolean getSquadraFinta() {
		return squadraFinta;
	}

	public void setSquadraFinta(Boolean squadraFinta) {
		this.squadraFinta = squadraFinta;
	}

	public Long getIdSquadra() {
		return idSquadra;
	}

	public void setIdSquadra(Long idSquadra) {
		this.idSquadra = idSquadra;
	}

	public List<Eformata> getElencoEf() {
		return elencoEf;
	}

	public void setElencoEf(List<Eformata> elencoEf) {
		this.elencoEf = elencoEf;
	}

	public List<Esegue> getElencoEsegue() {
		return elencoEsegue;
	}

	public void setElencoEsegue(List<Esegue> elencoEsegue) {
		this.elencoEsegue = elencoEsegue;
	}

	public Integer getMinutiTotali() {
		return minutiTotali;
	}

	public void setMinutiTotali(Integer minutiTotali) {
		this.minutiTotali = minutiTotali;
	}

	
	
}
