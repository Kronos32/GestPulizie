package it.rf.gestpulizie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.AppSede;
import it.rf.gestpulizie.repository.AppSedeRepository;

@Service
public class AppSedeService {

	@Autowired
	private AppSedeRepository Ar;
	
	public void aggiungiAppSede(AppSede appS)
	{
		Ar.save(appS);
	}
}
