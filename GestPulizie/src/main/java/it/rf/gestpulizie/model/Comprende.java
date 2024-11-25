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
public class Comprende {
	
	@Column
	private LocalDate dataAssociazioneComprende;
	@Column
	private Boolean fineEsecuzioneServizio;
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComprende;
	@Column
	private String descrizioneComprende;
	@Column
	private Integer minutiTotaliLavorazione;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="idLavorazione")
	private Lavorazione lavComprende;
	
	
	@ManyToOne
	@JoinColumn(name="idServizio")
	private Servizio servizioComprende;

	public Comprende() {}	

	public Comprende(LocalDate dataAssociazioneComprende, Boolean fineEsecuzioneServizio, Long idComprende,
			String descrizioneComprende, Lavorazione lavComprende, Servizio servizioComprende, Integer minutiTotaliLavorazione) {
		super();
		this.dataAssociazioneComprende = dataAssociazioneComprende;
		this.fineEsecuzioneServizio = fineEsecuzioneServizio;
		this.idComprende = idComprende;
		this.descrizioneComprende = descrizioneComprende;
		this.lavComprende = lavComprende;
		this.servizioComprende = servizioComprende;
		this.minutiTotaliLavorazione=minutiTotaliLavorazione;
	}

	public LocalDate getDataAssociazioneComprende() {
		return dataAssociazioneComprende;
	}

	public void setDataAssociazioneComprende(LocalDate dataAssociazioneComprende) {
		this.dataAssociazioneComprende = dataAssociazioneComprende;
	}

	public Boolean getFineEsecuzioneServizio() {
		return fineEsecuzioneServizio;
	}

	public void setFineEsecuzioneServizio(Boolean fineEsecuzioneServizio) {
		this.fineEsecuzioneServizio = fineEsecuzioneServizio;
	}

	public Long getIdComprende() {
		return idComprende;
	}

	public void setIdComprende(Long idComprende) {
		this.idComprende = idComprende;
	}

	public String getDescrizioneComprende() {
		return descrizioneComprende;
	}

	public void setDescrizioneComprende(String descrizioneComprende) {
		this.descrizioneComprende = descrizioneComprende;
	}

	public Lavorazione getLavComprende() {
		return lavComprende;
	}

	public void setLavComprende(Lavorazione lavComprende) {
		this.lavComprende = lavComprende;
	}

	public Servizio getServizioComprende() {
		return servizioComprende;
	}

	public void setServizioComprende(Servizio servizioComprende) {
		this.servizioComprende = servizioComprende;
	}

	public Integer getMinutiTotaliLavorazione() {
		return minutiTotaliLavorazione;
	}

	public void setMinutiTotaliLavorazione(Integer minutiTotaliLavorazione) {
		this.minutiTotaliLavorazione = minutiTotaliLavorazione;
	}
	
	
	
	
	
	
}
