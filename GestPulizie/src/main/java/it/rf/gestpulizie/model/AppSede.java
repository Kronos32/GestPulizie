package it.rf.gestpulizie.model;

import java.sql.Date;

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
public class AppSede {
	
	@Column
	private Date dataContratto;
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAppSede;

	
	
	@ManyToOne
	@JoinColumn(name="idSede")
	private Sede sedeApp;
	
	
	@ManyToOne
	@JoinColumn(name="cfCliente")
	private Cliente clienteApp;
	
	
	public AppSede() {}


	public AppSede(Date dataContratto, Long idAppSede, Sede sedeApp, Cliente clienteApp) {
		super();
		this.dataContratto = dataContratto;
		this.idAppSede = idAppSede;
		this.sedeApp = sedeApp;
		this.clienteApp = clienteApp;
	}


	public Date getDataContratto() {
		return dataContratto;
	}


	public void setDataContratto(Date dataContratto) {
		this.dataContratto = dataContratto;
	}


	public Long getIdAppSede() {
		return idAppSede;
	}


	public void setIdAppSede(Long idAppSede) {
		this.idAppSede = idAppSede;
	}


	public Sede getSedeApp() {
		return sedeApp;
	}


	public void setSedeApp(Sede sedeApp) {
		this.sedeApp = sedeApp;
	}


	public Cliente getClienteApp() {
		return clienteApp;
	}


	public void setClienteApp(Cliente clienteApp) {
		this.clienteApp = clienteApp;
	}
	
	
	
	
	
}
