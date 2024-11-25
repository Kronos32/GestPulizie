package it.rf.gestpulizie.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.gestpulizie.model.Eformata;
import it.rf.gestpulizie.repository.EformataRepository;

@Service
public class EformataService {

	@Autowired
	EformataRepository eFr;
	
	public Boolean addeFormata(Eformata ef) {

        eFr.save(ef);
        return true;
    }
	
	
	public Integer countPerCfOperaio(Long idSquadra)
	{
		return eFr.contPerCfOp(idSquadra);
	}
	
	

	
}
