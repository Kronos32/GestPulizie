package it.rf.gestpulizie.model;


import java.time.LocalDate;

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
public class Eformata {

	@Column
	private boolean responsabileSquadra;
	
	@Column
	private LocalDate dataCreazione;

	
	@Column
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long idAssociazione;
	
	
	
	@ManyToOne
	@JoinColumn(name="cfOperaio")
	private Operaio opF;
	
	
	@ManyToOne
	@JoinColumn(name="idSquadra")
	private Squadra sqF;

	
	public Eformata() {}


	public Eformata(boolean responsabileSquadra, LocalDate dataCreazione, Long idAssociazione, Operaio opF,
			Squadra sqF) {
		super();
		this.responsabileSquadra = responsabileSquadra;
		this.dataCreazione = dataCreazione;
		this.idAssociazione = idAssociazione;
		this.opF = opF;
		this.sqF = sqF;
	}


	public boolean getResponsabileSquadra() {
		return responsabileSquadra;
	}


	public void setResponsabileSquadra(boolean responsabileSquadra) {
		this.responsabileSquadra = responsabileSquadra;
	}


	public LocalDate getDataCreazione() {
		return dataCreazione;
	}


	public void setDataCreazione(LocalDate dataCreazione) {
		this.dataCreazione = dataCreazione;
	}


	public Long getIdAssociazione() {
		return idAssociazione;
	}


	public void setIdAssociazione(Long idAssociazione) {
		this.idAssociazione = idAssociazione;
	}


	public Operaio getOpF() {
		return opF;
	}


	public void setOpF(Operaio opF) {
		this.opF = opF;
	}


	public Squadra getSqF() {
		return sqF;
	}


	public void setSqF(Squadra sqF) {
		this.sqF = sqF;
	}
	

	
	
	
	
}
