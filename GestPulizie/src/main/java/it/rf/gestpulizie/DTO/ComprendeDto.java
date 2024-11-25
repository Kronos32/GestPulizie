package it.rf.gestpulizie.DTO;

import java.sql.Date;

public class ComprendeDto {

	private Long idComprende;
	private String nomeServizio;
	private Boolean fineEsecuzioneServizio;
	private Date dataPrevistaEsecuzione;
	private String descrizioneComprende;
	private String nomeSede;
	private String viaSede;
	private String cittaSede;
	private Integer pianoSede;
	private Long idLavorazione;
	private Boolean responsabileSquadra;


	public ComprendeDto() {}

	public ComprendeDto(Long idComprende, String nomeServizio, Boolean fineEsecuzioneServizio,
			Date dataPrevistaEsecuzione, String descrizioneComprende, String nomeSede, String viaSede,
			String cittaSede, Integer pianoSede, Long idLavorazione, Boolean responsabileSquadra) {
		super();
		this.idComprende = idComprende;
		this.nomeServizio = nomeServizio;
		this.fineEsecuzioneServizio = fineEsecuzioneServizio;
		this.dataPrevistaEsecuzione = dataPrevistaEsecuzione;
		this.descrizioneComprende = descrizioneComprende;
		this.nomeSede = nomeSede;
		this.viaSede = viaSede;
		this.cittaSede = cittaSede;
		this.pianoSede = pianoSede;
		this.idLavorazione=idLavorazione;
		this.responsabileSquadra=responsabileSquadra;
	}

	

	public Long getIdLavorazione() {
		return idLavorazione;
	}

	public void setIdLavorazione(Long idLavorazione) {
		this.idLavorazione = idLavorazione;
	}

	public Long getIdComprende() {
		return idComprende;
	}

	public void setIdComprende(Long idComprende) {
		this.idComprende = idComprende;
	}

	public String getNomeServizio() {
		return nomeServizio;
	}

	public void setNomeServizio(String nomeServizio) {
		this.nomeServizio = nomeServizio;
	}

	public Boolean getFineEsecuzioneServizio() {
		return fineEsecuzioneServizio;
	}

	public void setFineEsecuzioneServizio(Boolean fineEsecuzioneServizio) {
		this.fineEsecuzioneServizio = fineEsecuzioneServizio;
	}

	public Date getDataPrevistaEsecuzione() {
		return dataPrevistaEsecuzione;
	}

	public void setDataPrevistaEsecuzione(Date dataPrevistaEsecuzione) {
		this.dataPrevistaEsecuzione = dataPrevistaEsecuzione;
	}

	public String getDescrizioneComprende() {
		return descrizioneComprende;
	}

	public void setDescrizioneComprende(String descrizioneComprende) {
		this.descrizioneComprende = descrizioneComprende;
	}

	public String getNomeSede() {
		return nomeSede;
	}

	public void setNomeSede(String nomeSede) {
		this.nomeSede = nomeSede;
	}

	public String getViaSede() {
		return viaSede;
	}

	public void setViaSede(String viaSede) {
		this.viaSede = viaSede;
	}

	public String getCittaSede() {
		return cittaSede;
	}

	public void setCittaSede(String cittaSede) {
		this.cittaSede = cittaSede;
	}

	public Integer getPianoSede() {
		return pianoSede;
	}

	public void setPianoSede(Integer pianoSede) {
		this.pianoSede = pianoSede;
	}

	public Boolean getResponsabileSquadra() {
		return responsabileSquadra;
	}

	public void setResponsabileSquadra(Boolean responsabileSquadra) {
		this.responsabileSquadra = responsabileSquadra;
	}

	
	
	
}
