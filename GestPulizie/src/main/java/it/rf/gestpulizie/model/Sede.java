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
public class Sede {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSede;
	
	@Column
	private Integer pianoSede;
	@Column
	private String viaSede;
	@Column
	private String cittaSede;
	@Column
	private String nomeSede;
	
	
	
	@OneToMany(mappedBy = "sedeEsegue")
	private List<Esegue> elencoSedeEsegue;
	
	
	@OneToMany(mappedBy =  "sedeApp")
	private List<AppSede> elencoSedeApp;
	
	public Sede() {}
	

	public Sede(Long idSede, Integer pianoSede, String viaSede, String cittaSede, String nomeSede,
			List<Esegue> elencoSedeEsegue, List<AppSede> elencoSedeApp) {
		super();
		this.idSede = idSede;
		this.pianoSede = pianoSede;
		this.viaSede = viaSede;
		this.cittaSede = cittaSede;
		this.nomeSede = nomeSede;
		this.elencoSedeEsegue = elencoSedeEsegue;
		this.elencoSedeApp = elencoSedeApp;
	}



	public List<AppSede> getElencoSedeApp() {
		return elencoSedeApp;
	}



	public void setElencoSedeApp(List<AppSede> elencoSedeApp) {
		this.elencoSedeApp = elencoSedeApp;
	}



	public Long getIdSede() {
		return idSede;
	}



	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}



	public Integer getPianoSede() {
		return pianoSede;
	}



	public void setPianoSede(Integer pianoSede) {
		this.pianoSede = pianoSede;
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



	public String getNomeSede() {
		return nomeSede;
	}



	public void setNomeSede(String nomeSede) {
		this.nomeSede = nomeSede;
	}



	public List<Esegue> getElencoSedeEsegue() {
		return elencoSedeEsegue;
	}



	public void setElencoSedeEsegue(List<Esegue> elencoSedeEsegue) {
		this.elencoSedeEsegue = elencoSedeEsegue;
	}
	
	
	
	
}
