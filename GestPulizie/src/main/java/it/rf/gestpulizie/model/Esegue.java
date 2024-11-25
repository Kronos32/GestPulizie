package it.rf.gestpulizie.model;



import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Esegue {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEsegue;
	
	
	@Column
	private Boolean completato;
	
	@Column
	private Double Acconto;
	
	@Column
	private LocalDate dataLavoroEseguito;
	
	@Column
	private String descrizione;
	
	
	@ManyToOne
	@JoinColumn(name = "idSquadra")
	private Squadra sqEsegue;
	
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="idLavorazione")
	private Lavorazione lavEsegue;
	
	
	@ManyToOne
	@JoinColumn(name="idSede")
	private Sede sedeEsegue;
	
	
	
	public Esegue() {}


	public Esegue(Long idEsegue, Boolean completato, Double acconto, LocalDate dataLavoroEseguito, String descrizione,
			Squadra sqEsegue, Lavorazione lavEsegue, Sede sedeEsegue) {
		super();
		this.idEsegue = idEsegue;
		this.completato = completato;
		Acconto = acconto;
		this.dataLavoroEseguito = dataLavoroEseguito;
		this.descrizione = descrizione;
		this.sqEsegue = sqEsegue;
		this.lavEsegue = lavEsegue;
		this.sedeEsegue = sedeEsegue;
	}






	public Long getIdEsegue() {
		return idEsegue;
	}


	public void setIdEsegue(Long idEsegue) {
		this.idEsegue = idEsegue;
	}


	public Boolean getCompletato() {
		return completato;
	}


	public void setCompletato(Boolean completato) {
		this.completato = completato;
	}


	public Double getAcconto() {
		return Acconto;
	}


	public void setAcconto(Double acconto) {
		Acconto = acconto;
	}


	public LocalDate getDataLavoroEseguito() {
		return dataLavoroEseguito;
	}


	public void setDataLavoroEseguito(LocalDate dataLavoroEseguito) {
		this.dataLavoroEseguito = dataLavoroEseguito;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Squadra getSqEsegue() {
		return sqEsegue;
	}


	public void setSqEsegue(Squadra sqEsegue) {
		this.sqEsegue = sqEsegue;
	}


	public Lavorazione getLavEsegue() {
		return lavEsegue;
	}


	public void setLavEsegue(Lavorazione lavEsegue) {
		this.lavEsegue = lavEsegue;
	}


	public Sede getSedeEsegue() {
		return sedeEsegue;
	}


	public void setSedeEsegue(Sede sedeEsegue) {
		this.sedeEsegue = sedeEsegue;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	

}
