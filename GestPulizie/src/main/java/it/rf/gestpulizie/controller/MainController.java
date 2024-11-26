package it.rf.gestpulizie.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.rf.gestpulizie.model.Cliente;
import it.rf.gestpulizie.model.Comprende;
import it.rf.gestpulizie.DTO.AppSedeDto;
import it.rf.gestpulizie.DTO.ComprendeDto;
import it.rf.gestpulizie.model.AppSede;
import it.rf.gestpulizie.model.CategoriaOperaio;
import it.rf.gestpulizie.model.Eformata;
import it.rf.gestpulizie.model.Esegue;
import it.rf.gestpulizie.model.Lavorazione;
import it.rf.gestpulizie.model.Operaio;
import it.rf.gestpulizie.model.Sede;
import it.rf.gestpulizie.model.Servizio;
import it.rf.gestpulizie.model.Squadra;
import it.rf.gestpulizie.service.AppSedeService;
import it.rf.gestpulizie.service.CategoriaOperaioService;
import it.rf.gestpulizie.service.ClienteService;
import it.rf.gestpulizie.service.ComprendeService;
import it.rf.gestpulizie.service.EformataService;
import it.rf.gestpulizie.service.EsegueService;
import it.rf.gestpulizie.service.LavorazioneService;
import it.rf.gestpulizie.service.OperatoreService;
import it.rf.gestpulizie.service.SedeService;
import it.rf.gestpulizie.service.ServiziService;
import it.rf.gestpulizie.service.SquadraService;
import jakarta.servlet.http.HttpSession;


@Controller
public class MainController {

	@Autowired
	private AppSedeService appS;
	
	@Autowired
	private SedeService SedS;
	
	@Autowired
	private ClienteService cliS;
	
	@Autowired
	private OperatoreService Os;
	
	@Autowired
	private CategoriaOperaioService cS;
	
	@Autowired
	private EformataService eFs;
	
	
	@Autowired
	private SquadraService sS;
	
	@Autowired
	private ComprendeService compS;
	
	@Autowired
	private LavorazioneService lS;
	
	@Autowired
	private ServiziService servS;
	
	@Autowired
	private EsegueService eS;
	

	
	
	
	
	
	@GetMapping("/admin")
	public String admin(HttpSession session, Model x)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			return "admin";
		}
		else
		{
			
			x.addAttribute("errore","I dati inseriti non sono corretti");
			return "redirect:/GestPulizie/loginOperaioHome";
			
		}
	}
	
	
	//Gestione Clienti
	
	@GetMapping("/gestioneClienti")
	public String gestioneClienti()
	{
		return "gestioneClienti";
	}
	
	
	@GetMapping("/ricercaClienti")
	public String ricercaClienti()
	{
		return "ricercaClienti";
	}
	
	
	
	@GetMapping("/inserisciClientiHome")
	public String inserisciClienti(HttpSession session)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			return "inserisciClienti";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	@PostMapping("/inserisciClienti")
	public String insertClienti(HttpSession session, @ModelAttribute Cliente cliente, @RequestParam String cfCliente, Model model)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			Boolean insertCliente=cliS.inserisciCliente(cliente, cfCliente);
			if(insertCliente==true)
			{
				model.addAttribute("insCliente", "Cliente inserito con successo");
			}
			else
			{
				model.addAttribute("insCliente", "Cliente già presenete");
			}
			return "inserisciClienti";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	
	
	@GetMapping("/modificaClientiHome")
	public String modificaClienti(HttpSession session, Model model)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			List<Cliente> cliente = cliS.ricercaCliente();
			model.addAttribute("cliente",cliente);
			return "modificaClienti";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	@PostMapping("/modificaClienti")
	public String modClienti(HttpSession session, String cfCliente, Model model)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			
			Optional<Cliente> cli=cliS.ricercaClienteCf(cfCliente);
			if(cli.isPresent())
			{
				model.addAttribute("clienteDaMod", cli.get());
			}
			return "modificaClienti";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	@PostMapping("/modCli")
	public String modCli(HttpSession session, @RequestParam String nomeCliente, String cfCliente,
			String cognomeCliente, String usernameCliente, String pswCliente)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			Optional <Cliente>clie=cliS.ricercaClienteCf(cfCliente);
			Cliente cliente=clie.get();
			cliente.setCognomeCliente(cognomeCliente);
			cliente.setNomeCliente(nomeCliente);
			cliente.setUsernameCliente(usernameCliente);
			cliente.setPswCliente(pswCliente);
			cliS.modificaCliente(cliente);
			return "redirect:/GestPulizie/modificaClientiHome";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	//Gestione Categoria
	@GetMapping("/gestioneCategoria")
	public String gestioneCategoria()
	{
		return "gestioneCategoria";
	}
	
	@GetMapping("/ricercaCategoriaHome")
	public String ricercaCategoria()
	{
		return "ricercaCategoria";
	}
	
	
	@PostMapping("/ricercaCategoria")
	public String ricCategoria(@ModelAttribute CategoriaOperaio m,Model x, @RequestParam String nomeCategoria, Long idCategoria)
	{
		if(idCategoria!=null)
		{
			Optional <CategoriaOperaio> catList=this.cS.ricercaCategoriaId(m, idCategoria);
			x.addAttribute("catList", catList);
			
		}
		if(nomeCategoria!=null)
		{
			Optional<CategoriaOperaio> catTrovata=this.cS.ricercaCategoriaNome(m, nomeCategoria);
			x.addAttribute("catTrovata", catTrovata);
		}	
		else {
			x.addAttribute("essito", "Nessuna Categoria Trovata");
		}
		
		

		
		
		return "ricercaCategoria";
	}
	
	
	@GetMapping("/eliminaCategoria")
	public String eliminaCategoria()
	{
		return "eliminaCategoria";
	}
	
	
	@GetMapping("/inserisciCategoriaHome")
	public String inserisciCategoria()
	{
		return "inserisciCategoria";
	}
	
	
	@PostMapping("/inserisciCategoria")
	public String inserisciCategoria(@ModelAttribute CategoriaOperaio m, String nomeCategoria, Model x)
	{
		
		boolean  catTrovata=this.cS.inserisciCategoria(m, nomeCategoria);	
		if(catTrovata==false)
		{
			String esito="La categoria è gia presente";
			x.addAttribute("catTrovata", catTrovata);
			x.addAttribute("esito",esito);
			
			return "inserisciCategoria";
			
		}
		else
		{
			
			x.addAttribute("catTrovata", catTrovata);
			String esito="La categoria è stata inserita correttamente";
			x.addAttribute("esito",esito);
			return "inserisciCategoria";
		}
	}
	
	
	@GetMapping("/modificaCategoriaHome")
	public String modificaCategoria()
	{
		return "modificaCategoria";
	}
	
	
	@PostMapping("/modificaCategoria")
	public String modificaCategoria(@ModelAttribute CategoriaOperaio m, Model x, @RequestParam String nomeCategoria )
	{
	
			
			Optional<CategoriaOperaio>  catTrov=this.cS.ricercaCategoriaNome(m, nomeCategoria);
			x.addAttribute("catTrovata", catTrov);
		
		

		return "modificaCategoria";
	}
	
	
	@PostMapping("/updateCategoria")
	public String updateCategoria(@ModelAttribute CategoriaOperaio m,@RequestParam String nomeCategoria, Model x)
	{
		boolean trovato=this.cS.modificaCategoria(m, nomeCategoria);
		if(trovato==false)
		{
			String esito="La categoria non esiste";
			x.addAttribute("esito",esito);
			
			
		}
		else
		{
			String esito="La categoria è stata aggiornata correttamente";
			x.addAttribute("esito",esito);
			
		}
		Optional <CategoriaOperaio> catTrov=this.cS.ricercaCategoriaNome(m, nomeCategoria);
		x.addAttribute("catTrovata", catTrov);
		return "updateCategoria";
	}
	
	
	@PostMapping("/eliminaCategoria")
	public String eliminaCategoria(@ModelAttribute CategoriaOperaio m, @RequestParam Long idCategoria, Model x)
	{
		boolean trovata=this.cS.eliminaCategoria(m, idCategoria);
		if(trovata==false)
		{
			String esito="La categoria non esiste";
			x.addAttribute("esito",esito);
			
			
		}
		else
		{
			String esito="La categoria è stata eliminata con successo";
			x.addAttribute("esito",esito);
			
		}
		return "modificaCategoria";
		
	}
	
	
	
	//Gestione Operaio
	
	@GetMapping("/gestioneOperaio")
	public String gestioneOperaio()
	{
		return "gestioneOperaio";
	}
	
	
	
	@GetMapping("/ricercaOperaioHome")
	public String ricercaOperaio()
	{
		return "ricercaOperaio";
	}
	
	
	
	@PostMapping("/ricercaOperaio")
	public String ricercaOperatore(@ModelAttribute Operaio m,Model x, @RequestParam String cfOperaio, @RequestParam String nomeOperaio, String cognomeOperaio)
	{
		Optional <Operaio> opTrovato=this.Os.ricercaOperaioCf( cfOperaio);
		List <Operaio> opList=this.Os.ricercaOperaioNomeCognome(m, nomeOperaio, cognomeOperaio);
		
		
		
		x.addAttribute("opList", opList);
		
		x.addAttribute("opTrovato", opTrovato);
		return "ricercaOperaio";
	}
	
	
	
	@GetMapping("/inserisciOperaioHome")
	public String insertOperaio(Model x)
	{
		List<CategoriaOperaio> catTrovata=this.cS.ricercaCategoriaAll();
		x.addAttribute("catTrovata", catTrovata);
		return "inserisciOperaio";
	}
	
	
	@PostMapping("/inserisciOperaio")
	public String inserisciOperaio(@ModelAttribute Operaio m, String cfOperaio, Model x)
	{
		
		List<CategoriaOperaio> catTrovata=this.cS.ricercaCategoriaAll();	
		boolean trovato=this.Os.inserisciOperaio(m, cfOperaio);
		if(trovato==false)
		{
			String esito="L'operaio è gia presente";
			x.addAttribute("catTrovata", catTrovata);
			x.addAttribute("esito",esito);
			
			return "inserisciOperaio";
			
		}
		else
		{
			
			x.addAttribute("catTrovata", catTrovata);
			String esito="L'operaio è stato inserito correttamente";
			x.addAttribute("esito",esito);
			return "inserisciOperaio";
		}
	}
	
	
	@GetMapping("/modificaOperaioHome")
	public String modificaOperaio()
	{
		return "modificaOperaio";
	}
	
	
	@PostMapping("/modificaOperaio")
	public String modificaOperatore(@ModelAttribute Operaio m, Model x, @RequestParam String cfOperaio, @RequestParam String nomeOperaio, String cognomeOperaio)
	{
		Optional <Operaio> opTrovato=this.Os.ricercaOperaioCf( cfOperaio);
		List <Operaio> opList=this.Os.ricercaOperaioNomeCognome(m, nomeOperaio, cognomeOperaio);
		List<CategoriaOperaio> catTrovata=this.cS.ricercaCategoriaAll();	
		x.addAttribute("opList", opList);
		x.addAttribute("catTrovata", catTrovata);

		x.addAttribute("opTrovato", opTrovato);
		return "modificaOperaio";
	}
	
	
	@GetMapping("/updateOperaioHome")
	public String updateOperaio()
	{
		return "updateOperaio";
	}
	
	
	@PostMapping("/updateOperaio")
	public String updateOperaio(@ModelAttribute Operaio m, @RequestParam String cfOperaio, Model x,  @RequestParam String nomeOperaio, String cognomeOperaio)
	{
		boolean trovato=this.Os.modificaOperaio(m, cfOperaio, nomeOperaio, cognomeOperaio);
		if(trovato==false)
		{
			String esito="L'operaio non è presente";
			x.addAttribute("esito",esito);
			
			
		}
		else
		{
			String esito="L'operaio è stato aggiornato correttamente";
			x.addAttribute("esito",esito);
			
		}
		Optional <Operaio> opTrovato=this.Os.ricercaOperaioCf( cfOperaio);
		List <Operaio> opList=this.Os.ricercaOperaioNomeCognome(m, nomeOperaio, cognomeOperaio);
		

		List<CategoriaOperaio> catTrovata=this.cS.ricercaCategoriaAll();
		x.addAttribute("catTrovata", catTrovata);
		x.addAttribute("opList", opList);
		
		x.addAttribute("opTrovato", opTrovato);
		return "updateOperaio";
	}
	
	
	
	/*@PostMapping("/eliminaOperaio")
	public String eliminaOperaio(@ModelAttribute Operaio m, @RequestParam String cfOperaio, Model x)
	{
		boolean trovato=this.Os.eliminaOperaio(m, cfOperaio);
		if(trovato==false)
		{
			String esito="L'operaio non è presente";
			x.addAttribute("esito",esito);
			
			
		}
		else
		{
			String esito="L'operaio è stato eliminato con successo";
			x.addAttribute("esito",esito);
			
		}
		return "eliminaOperaio";
		
	}*/
	
	
	
	
	
	//Gestione Ordini
	
	@GetMapping("/gestioneOrdini")
	public String gestioneOrdini()
	{
		return "gestioneOrdini";
	}
	
	
	
	@GetMapping("/ricercaOrdini")
	public String ricercaOrdini()
	{
		return "ricercaOrdini";
	}
	
	
	
	@GetMapping("/modificaOrdiniHome")
	public String modificaOrdini(HttpSession session, Model mod)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{	
			List<ComprendeDto>listLav =lS.selezionaTutto();
			mod.addAttribute("listLav", listLav);
			return "modificaOrdini";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	@PostMapping("/modificaOrdini")
	public String modOrdini(HttpSession session, @RequestParam Long idLavorazione, Model modifica)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{	
			Optional <Esegue> ese=eS.ricercaIdLav(idLavorazione);
			Optional<Lavorazione> lav=lS.ricercaLavorazioneId(idLavorazione);
			List<Servizio> servi=servS.ricercaServizio();
			List<Squadra> sq=sS.cercaSquadra();

			Date dataEse=lav.get().getDataPrevistaEsecuzione();
			String descrizione=ese.get().getDescrizione();
			
			modifica.addAttribute("servi", servi);
			modifica.addAttribute("sq",sq);
			modifica.addAttribute("dataEse",dataEse);
			modifica.addAttribute("idLavorazione",idLavorazione);
			modifica.addAttribute("descrizione", descrizione);
			
			
			System.out.println("---------------------------------------------------------");
			System.out.println(dataEse);
			System.out.println(descrizione);
			System.out.println(idLavorazione);
			System.out.println(sq.get(0).getNomeSquadra());
			System.out.println(servi.get(0).getNomeServizio());
			
			return "modOrdini";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	@PostMapping("/visOrdDaMod")
	public String visOrdDaMod(HttpSession session, @RequestParam Long idLavorazione, Date dataPrevistaEsecuzione, String descrizione,
		Long idSquadra, List<Long> idServizio, Long idEsegue)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{	
			
			Optional <Squadra> sq=sS.cercaSquadraId(idSquadra);
			Optional<Esegue> ese=eS.ricercaIdLav(idLavorazione);
			Optional<Lavorazione> lav=lS.ricercaLavorazioneId(idLavorazione);
			
			lav.get().setDataPrevistaEsecuzione(dataPrevistaEsecuzione);
			ese.get().setDescrizione(descrizione);
			ese.get().setSqEsegue(sq.get());
			
			LocalDate dataAssociazione=LocalDate.now();
			Comprende comp=new Comprende();
			
			for(Long idServ: idServizio)
			{
				Optional<Servizio> serv=servS.ricercaServizioId(idServ);			
				
				comp.setDataAssociazioneComprende(dataAssociazione);
				comp.setLavComprende(lav.get());
				comp.setFineEsecuzioneServizio(false);
				comp.setServizioComprende(serv.get());
				
			}
			
			List <Comprende> comprende=compS.ricercaByIdLav(idLavorazione);
			Double prezzoTotale=compS.totPrezzoLav(idLavorazione);
	        Integer minutiTotaliLavorazione = compS.totMinLav(idLavorazione);
	        for(int i=0;i<comprende.size();i++)
	        {
	        	comprende.get(i).setMinutiTotaliLavorazione(minutiTotaliLavorazione);
	        }
	             
	         
	        
	       Optional <Esegue> esegue=eS.ricercaEsegueId(idEsegue);
	       Integer totOperai = eFs.countPerCfOperaio(idSquadra);
	       
	       esegue.get().setIdEsegue(esegue.get().getIdEsegue());
	       Integer totMin= minutiTotaliLavorazione + sq.get().getMinutiTotali();
	       if(totMin<=450*totOperai)
	       {
	    	   esegue.get().setSqEsegue(sq.get());
	    	   sq.get().setMinutiTotali(totMin);	    	   
	       }
	       else
	       {
	    	   
	    	   Optional <Squadra>sqFinta=sS.cercaSquadraId(1L);
	    	   esegue.get().setSqEsegue(sqFinta.get());
	    	   
	       }
	       eS.aggiungiEsegue(esegue.get());
	         lav.get().setPrezzoTotale(prezzoTotale);
	        
			
			
			
			compS.insertCOmprende(comp);
			lS.modificaLavorazione(lav.get());
			eS.aggiungiEsegue(ese.get());
			return "modificaOrdini";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	
	
	
	
	@GetMapping("/cancellaLavorazioneHome")
	public String cancLavorazione(HttpSession session, Model mod)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{	
			List <ComprendeDto> listLav = lS.selezionaTutto();
			mod.addAttribute("listLav",listLav);
			return "cancellaLavorazione";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
		
	}
	
	
	@PostMapping("/cancellaLavorazione")
	public String cancellaLavorazione(HttpSession session, Model mod, @RequestParam Long[] idLavorazione)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{	
			for(Long id: idLavorazione)
			{
				lS.cancellaLavorazione(id);
			}
			return "cancellaLavorazione";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
		
	}
	
	

	
	
	
	@PostMapping("/stampaServizi")
    public String inserisciOrdini(@RequestParam Long idLavorazione,Model model, HttpSession session) {
           List<Servizio> elencoServizi = this.servS.ricercaServizio();
           if(elencoServizi.size()>0)
           {
            session.setAttribute("idLav",idLavorazione);
            List<Squadra> sqDaAssoc=sS.cercaSquadra();
            model.addAttribute("elencoSq", sqDaAssoc);
            model.addAttribute("elencoServizi", elencoServizi);
            return "AssociaServizi"; 
           }
           else
           {
        	   return "AssociaServizi"; 
           }
        
	}
	
	@GetMapping("/inserisciServizi")
	public String insertServizi()
	{
		return "AssociaServizi";
	}
	
	
	 @PostMapping("/associaServzio")
	public String associaClienti(Model model, @RequestParam Long idSquadra, @RequestParam List<Long> idServizio, @RequestParam String descrizioneComprende, HttpSession session, @ModelAttribute Comprende comp) {
		 Long idLav = (Long) session.getAttribute("idLav");	        
	        
		 	Optional<Lavorazione> lavorazione = lS.ricercaLavorazioneId(idLav);
	        Lavorazione Lavo=lavorazione.get();
	       
	        LocalDate dataAssociazione=LocalDate.now();
	        Esegue ese= (Esegue)session.getAttribute("esegue");
	        Long idEsegue=ese.getIdEsegue();
	        for (Long id : idServizio) 
	        {
	        	Optional<Servizio> servizio = servS.ricercaServizioId(id);
	        	Servizio ser=servizio.get();
	            Comprende comprende = new Comprende();
	            comprende.setDataAssociazioneComprende(dataAssociazione);
	            comprende.setDescrizioneComprende(descrizioneComprende);
	            comprende.setLavComprende(Lavo);
	            comprende.setServizioComprende(ser);
	            comprende.setFineEsecuzioneServizio(false);
            
	            compS.insertCOmprende(comprende);
            }
	        Double prezzoTotale=compS.totPrezzoLav(idLav);
	        Integer minutiTotaliLavorazione = compS.totMinLav(idLav); 
	        List<Comprende> compre=compS.ricercaByIdLav(idLav);
	        for(int i=0;i<compre.size();i++)
	        {
	        	compre.get(i).setMinutiTotaliLavorazione(minutiTotaliLavorazione);
	        }
	             
	         
	        
	       Optional <Esegue> esegue=eS.ricercaEsegueId(idEsegue);
	       Optional <Squadra>sq=sS.cercaSquadraId(idSquadra);
	       Integer totOperai = eFs.countPerCfOperaio(idSquadra);
	       
	       esegue.get().setIdEsegue(esegue.get().getIdEsegue());
	       Integer totMin= minutiTotaliLavorazione + sq.get().getMinutiTotali();
	       if(totMin<=450*totOperai)
	       {
	    	   esegue.get().setSqEsegue(sq.get());
	    	   sq.get().setMinutiTotali(totMin);	    	   
	       }
	       else
	       {
	    	   
	    	   Optional <Squadra>sqFinta=sS.cercaSquadraId(1L);
	    	   esegue.get().setSqEsegue(sqFinta.get());
	    	   model.addAttribute("OrePiene", "la squadra ha scelta non può effettuare questa lavorazione");
	       }
	       eS.aggiungiEsegue(esegue.get());
	         Lavo.setPrezzoTotale(prezzoTotale);
	         lS.aggiungiLavorazione(Lavo);
			List<Cliente> cliList=cliS.ricercaCliente();
			model.addAttribute("cliList",cliList);
	        model.addAttribute("Messaggio", "Servizi inseriti correttamente");
	        return "redirect:/GestPulizie/EsegueHome"; 		 	  
	   }
	

	 @GetMapping("/associaServizioHome")
	 public String assocServizio(Model model, HttpSession session)
	 {
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			List<Cliente> cliList=cliS.ricercaCliente();
			model.addAttribute("cliList",cliList);
			return "redirect:/GestPulizie/Esegue";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	 }
	 
	
	
	
	//Gestione Sede
	
	@GetMapping("/gestioneSede")
	public String gestioneSede(HttpSession session)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			return "gestioneSede";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	@GetMapping("/inserisciSedeHome")
	public String inserisciSede(HttpSession session)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			return "inserisciSede";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	@PostMapping("/inserisciSede")
    public String inserisciSede(Model model, @RequestParam String nomeSede,  @RequestParam Integer pianoSede, @RequestParam String viaSede, @RequestParam String cittaSede, HttpSession session) {
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			Sede sede = new Sede();
	        sede.setNomeSede(nomeSede);
	        sede.setCittaSede(cittaSede);
	        sede.setPianoSede(pianoSede);
	        sede.setViaSede(viaSede);
	        this.SedS.aggiungiSede(sede);
	  
	           List<Cliente> elencoClienti = cliS.ricercaCliente();
	            session.setAttribute("idSede", sede.getIdSede());
	            model.addAttribute("elencoClienti", elencoClienti);
	            model.addAttribute("Messaggio", "Nuova sede inserita");
	            return "inserisciSede"; 
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	
	@PostMapping("/associaClienti")
	public String associaClienti(Model model, @RequestParam Date dataContratto, @RequestParam String[] cfCliente, HttpSession session, @ModelAttribute Sede sede) {
	 	
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
		 	Long idSede = (Long) session.getAttribute("idSede");
	        Optional<Sede> sed = SedS.ricercaSedeId( idSede);
	       
	        Sede Sedi=sed.get();        
	        for (String cf : cfCliente) {
	        	Optional<Cliente> cliente = cliS.ricercaClienteCf(cf);
	        	Cliente cli=cliente.get();
	            AppSede appsede = new AppSede();
	                appsede.setClienteApp(cli);
	            
	            appsede.setIdAppSede(idSede);
	            appsede.setSedeApp(Sedi);
	            appsede.setDataContratto(dataContratto);
	            
	            
	            appS.aggiungiAppSede(appsede);
	            
	        }
	
	        model.addAttribute("Messaggio", "Operai associati alla squadra con successo");
	        return "inserisciSquadre"; 
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
    }



	@GetMapping("/modificaSedeHome")
	public String modificaSede(HttpSession session,  Model sed)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			return "modificaSede";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	@PostMapping("/modificaSede")
	public String modSede(HttpSession session, @RequestParam String nomeSede, Model sed)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			List<Sede> sede =SedS.ricercaSedeNomeSede(nomeSede);
			if(sede!=null)
			{
				sed.addAttribute("sede",sede);
			}
			return "modificaSede";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	@PostMapping("/modSed")
	public String modSed(HttpSession session, @RequestParam Long idSede, String nomeSede, String viaSede, String cittaSede, Integer pianoSede)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			Optional<Sede> sede= SedS.ricercaSedeId(idSede);
			Sede s=sede.get();
			s.setCittaSede(cittaSede);
			s.setNomeSede(nomeSede);
			s.setViaSede(viaSede);
			s.setPianoSede(pianoSede);
			
			SedS.aggiungiSede(s);
			return "modificaSede";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	//Gestione Squadra
	
	
	@GetMapping("/gestioneSquadre")
	public String gestioneSquadre(HttpSession session)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			return "gestioneSquadre";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	

	
	@GetMapping("/ricercaSquadre")
	public String ricercaSquadre(HttpSession session)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			return "ricercaSquadre";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	@GetMapping("/inserisciSquadreHome")
	public String inserisciSquadre(HttpSession session)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			return "inserisciSquadre";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	

    @PostMapping("/inserisciSquadre")
    public String creaSquadra(Model model, @RequestParam String nomeSquadra,  @RequestParam String descrizioneSquadra, @RequestParam Date dataOperativita, HttpSession session) {
        Squadra squadra = new Squadra();
        squadra.setNomeSquadra(nomeSquadra);
        squadra.setDescrizione(descrizioneSquadra);
        squadra.setDataOperativita(dataOperativita);
        squadra.setSquadraFinta(false);
        squadra.setMinutiTotali(0);

        Boolean esito = sS.creaSquadra(squadra, nomeSquadra);
        		

        if (esito) {
            List<Operaio> elencoDisponibili = Os.ricercaOperaioLibero(dataOperativita);
            session.setAttribute("idSquadra", squadra.getIdSquadra());
            model.addAttribute("elencoDisponibili", elencoDisponibili);
            model.addAttribute("Messaggio", "Nuova squadra inserita");
            model.addAttribute("esito", true);
            return "inserisciSquadre"; 
        } else {
            model.addAttribute("Messaggio", "Nome Squadra già utilizzato");
            return "inserisciSquadre";
        }
    }

    @PostMapping("/associaSquadra")
    public String associaSquadra(Model model, @RequestParam String[] cfOperaio, HttpSession session) {
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{    
    		Long idSquadra = (Long) session.getAttribute("idSquadra");
	        Optional<Squadra> squadra = sS.cercaSquadraId(idSquadra);
	       
	        Squadra squad=squadra.get();
	        List <Eformata> listaSquadra=new ArrayList<Eformata>();        
	        for (String cf : cfOperaio) {
	        	Optional<Operaio> operaio = Os.ricercaOperaioCf(cf);
	        	Operaio oper=operaio.get();
	            Eformata eformata = new Eformata();
	                eformata.setResponsabileSquadra(false);
	            
	            eformata.setOpF(oper);
	            eformata.setSqF(squad);
	            eformata.setDataCreazione(LocalDate.now());
	            
	            eFs.addeFormata(eformata);
	            
	            listaSquadra.add(eformata);
	        }
	
			session.setAttribute("listaSquadra",listaSquadra);
			model.addAttribute("ListSquad",listaSquadra);
	        model.addAttribute("Messaggio", "Operai associati alla squadra con successo");
	        return "inserisciSquadre"; 
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
    }

    
    @PostMapping("/associaResponsabile")
    public String associaResponsabile(@RequestParam String setResp, HttpSession session, Model x) {
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
	        List<Eformata> listaSquadra = (List<Eformata>) session.getAttribute("listaSquadra");
	       
	        if (listaSquadra != null) {
	            for (int i=0;i<listaSquadra.size();i++) {
	                if (listaSquadra.get(i).getOpF().getCfOperaio().equals(setResp)) {
	                	Optional<Squadra> squadra = sS.cercaSquadraId(listaSquadra.get(i).getSqF().getIdSquadra());
	                	Optional<Operaio> op = Os.ricercaOperaioCf(setResp);
	                	Eformata setRespon = new Eformata();
	                	Operaio Op=op.get();
	                	Squadra Sq=squadra.get();
	                    setRespon.setResponsabileSquadra(true);
	                    
	                    setRespon.setIdAssociazione(listaSquadra.get(i).getIdAssociazione());
		                setRespon.setOpF(Op);
		                setRespon.setSqF(Sq);
		                setRespon.setDataCreazione(LocalDate.now());
		                
		                eFs.addeFormata(setRespon);
	                }
	            }
	            x.addAttribute("Messaggio", "Responsabile assegnato con successo");
	        } else {
	            x.addAttribute("Messaggio", "Errore: lista della squadra non trovata");
	            return "errore";
	        }
	        return "inserisciSquadre";
    	}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
    }
    
    
	
	@GetMapping("/modificaSquadreHome")
	public String modificaSquadre(HttpSession session, Model model)
	{
		String cfVerificato=(String) session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			List <Squadra> listaSquadre = sS.cercaSquadra();
			model.addAttribute("listaSquadra", listaSquadre);
			return "modificaSquadre";
		}
		else
		{
					
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	@PostMapping("/modificaSquadre")
	public String modSquadre(HttpSession session, Model model, @RequestParam Long idSquadra)
	{
		String cfVerificato=(String) session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			

			List<Operaio> opAll=Os.ricercaOperaioAll();
			model.addAttribute("opAll", opAll);
			return "modificaSquadre";
		}
		else
		{
					
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	@PostMapping("/aggiungiNuoviOperatori")
	public String newOp (@RequestParam Long idSquadra, HttpSession session, String cfOperaio)
	{
		String cfVerificato=(String) session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			Optional<Operaio> operaio = Os.ricercaOperaioCf(cfOperaio);
			Optional <Squadra> squadra = sS.cercaSquadraId(idSquadra);
			Operaio Op = operaio.get();
			Squadra squad = squadra.get();
			Eformata eF = new Eformata();
			LocalDate dataCreazione=LocalDate.now();
			eF.setSqF(squad);
			eF.setOpF(Op);
			eF.setDataCreazione(dataCreazione);
			eF.setResponsabileSquadra(false);
			
			
			
			return "redirect:/GestPulizie/modificaSquadre";
		}
		else
		{
					
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	//Gestione Servizi
	
	
	
	@GetMapping("/gestioneServizi")
	public String gestioneServizi(HttpSession session)
	{
		String cfVerificato=(String) session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			return "gestioneServizi";
		}
		else
		{
					
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}

	
	

	
	@GetMapping("/modificaServiziHome")
	public String modificaServizi(HttpSession session)
	{
		String cfVerificato=(String) session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			return "modificaServizi";
		}
		else
		{
					
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	@PostMapping("/modificaServizi")
	public String modServizi(HttpSession session, @RequestParam String nomeServizio, Model servizi)
	{
		String cfVerificato=(String) session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			Optional<Servizio> servizio=servS.ricercaServizioNome(nomeServizio);
			if(servizio.isPresent()	)
			{
				servizi.addAttribute("servizio", servizio.get());
				return "modificaServizi";
			}
			else
			{
				servizi.addAttribute("serv", "Nessun servizio corrispondente");
				return "modificaServizi";
			}
			
		}
		else
		{
					
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	

	
	
	@PostMapping("/modSer")
	public String modSer(HttpSession session, @RequestParam String nomeServizio, String descrizioneServizio,
			Integer minServizio, Double prezzoServizio, Long idServizio, Model servizi)
	{
		String cfVerificato=(String) session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			Optional <Servizio> serv=servS.ricercaServizioId(idServizio);
			Servizio servDaMod=serv.get();
			servDaMod.setDescrizioneServizio(descrizioneServizio);
			servDaMod.setMinServizio(minServizio);
			servDaMod.setNomeServizio(nomeServizio);
			servDaMod.setPrezzoServizio(prezzoServizio);
			servS.aggiornaServizio(servDaMod);
			return "redirect:/GestPulizie/modificaServizi";
		}
		else
		{
					
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	@PostMapping("/insertServizi")
	public String inserisciServizi(HttpSession session, @RequestParam String nomeServizio, String descrizioneServizio,
			Integer minServizio, Double prezzoServizio, Model serv)
	{
		String cfVerificato=(String) session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			Servizio servizio=new Servizio();
			servizio.setDescrizioneServizio(descrizioneServizio);
			servizio.setPrezzoServizio(prezzoServizio);
			servizio.setNomeServizio(nomeServizio);
			servizio.setMinServizio(minServizio);
			Boolean aggServ=servS.inserisciServizio(servizio, nomeServizio);
			if(aggServ==true)
			{
				serv.addAttribute("inserimento","Servizio aggiunto correttamente");
			}
			else
			{
				serv.addAttribute("inserimento","Servizio già esistente");
			}
			return "inserisciServizi";
		}
		else
		{
					
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	@GetMapping("/insertServiziHome")
	public String insertServ(HttpSession session)
	{
		String cfVerificato=(String) session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			return "inserisciServizi";
		}
		else
		{
					
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	
	

	//Esegue
	
	@GetMapping("/EsegueHome")
	public String esegue(Model model, HttpSession session)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			List<Cliente> cliList=cliS.ricercaCliente();
			model.addAttribute("cliList",cliList);
			return "Esegue";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}

	
	@PostMapping("/Esegue")
	public String esegue(@RequestParam String cfCliente, Model model, HttpSession session)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{	
			List<Cliente> cliList=cliS.ricercaCliente();
			model.addAttribute("cliList",cliList);
			Optional<Cliente> clienteCercato=cliS.ricercaClienteCf(cfCliente);
			Cliente clienteTrovato=clienteCercato.get();
			
			List<Sede> sediCliente=SedS.ricercaSedeCfCliente(clienteTrovato.getCfCliente());
			session.setAttribute("clienteTrovato", clienteTrovato);
			model.addAttribute("sediCliente",sediCliente);
			
			return "Esegue";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	
	
	@PostMapping("/sceltaSede")
	public String sceltaSede(HttpSession session, Model model, @RequestParam String descrizioneLavorazione, @RequestParam Long idSede, @RequestParam Date dataPrevistaEsecuzione, @RequestParam String descrizione)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{	
			
			LocalDate dataPrenotazioneLavorazione=LocalDate.now();
			Cliente cliente=(Cliente)session.getAttribute("clienteTrovato");
		  	Lavorazione lav = new Lavorazione();
	        lav.setDataPrenotazioneLavorazione(dataPrenotazioneLavorazione);
	        lav.setDataPrevistaEsecuzione(dataPrevistaEsecuzione);
	        lav.setDescrizioneLavorazione(descrizioneLavorazione);
	        
	        Lavorazione lavorazione=lav;
	        this.lS.aggiungiLavorazione(lav);
	        Squadra squadraFinta=sS.SeleSquadraFinta();
	        
	        
	        Optional<Sede>sedeSelezionata =SedS.ricercaSedeId(idSede);
	        Sede sedeSele=sedeSelezionata.get();	        
	        Esegue esegue=new Esegue();
	        esegue.setAcconto(0D);
	        esegue.setDescrizione(descrizione);
	        esegue.setLavEsegue(lavorazione);
	        esegue.setSqEsegue(squadraFinta);
	        esegue.setSedeEsegue(sedeSele);
	        
	        eS.aggiungiEsegue(esegue);
	        
	        
	        AppSedeDto appSedeDto=new AppSedeDto();
            appSedeDto.setCfCliente(cliente.getCfCliente());
            appSedeDto.setNomeCliente(cliente.getNomeCliente());
            appSedeDto.setCognomeCliente(cliente.getCognomeCliente());
            appSedeDto.setIdSede(esegue.getSedeEsegue().getIdSede());
            appSedeDto.setIdLavorazione(esegue.getLavEsegue().getIdLavorazione());
	        appSedeDto.setDataPrevistaLavorazione(dataPrevistaEsecuzione);
	        model.addAttribute("appSedeDto",appSedeDto);
	        session.setAttribute("esegue",esegue);
	        session.setAttribute("appSedeDto", appSedeDto);
	        return "Esegue";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
		}
	}
	

	//Cliente
	

	@GetMapping("/cliente")
	public String clientelog(HttpSession session, Model x)
	{
		
		String cfVerificatoCli=(String)session.getAttribute("cfVerificatoCli");
		if(cfVerificatoCli!=null)
		{
			return "cliente";
		}
		else
		{
			
			x.addAttribute("errore","I dati inseriti non sono corretti");
			return "redirect:/GestPulizie/loginClienteHome";
			
		}
	}

	
	
	@GetMapping("/effettuaPrenotazione")
	public String effettuaPrenotazione(HttpSession session, Model x)
	{
		String cfVeriicatoCli=(String)session.getAttribute("cfVerificatoCli");
		if(cfVeriicatoCli!=null)
		{
			List <Sede> sediCliente=SedS.ricercaSedeCfCliente(cfVeriicatoCli);
			x.addAttribute("sediCliente", sediCliente);
			return "effettuaPrenotazione";
		}
		else
		{
			
			x.addAttribute("errore","I dati inseriti non sono corretti");
			return "redirect:/GestPulizie/loginClienteHome";
			
		}
	}
	
	
	
	@PostMapping("/stampaServiziCliente")
    public String insertOrdini(@RequestParam Long idLavorazione,Model model, HttpSession session) {
		String cfVeriicatoCli=(String)session.getAttribute("cfVerificatoCli");
		if(cfVeriicatoCli!=null)
		{
			List<Servizio> elencoServizi = this.servS.ricercaServizio();
           if(elencoServizi.size()>0)
           {
            model.addAttribute("elencoServizi", elencoServizi);
            model.addAttribute("idLav", idLavorazione);
            return "associaServiziCliente"; 
           }
           else
           {
        	   return "associaServiziCliente"; 
           }
		}
		else
		{
			
			return "redirect:/GestPulizie/loginClienteHome";
		}
		
        
	}
	

	
	
	 @PostMapping("/associaServzioCliente")
	public String associaServizioClienti(Model model, @RequestParam List<Long> idServizio, @RequestParam String descrizioneComprende, Long idLavorazione, HttpSession session) {
	      
		String cfVeriicatoCli=(String)session.getAttribute("cfVerificatoCli");
		if(cfVeriicatoCli!=null)
		{
	        Optional<Lavorazione> lavorazione = lS.ricercaLavorazioneId(idLavorazione);
	        Lavorazione Lavo=lavorazione.get();
	       
	        LocalDate dataAssociazione=LocalDate.now();
	        for (Long id : idServizio) 
	        {
	        	Optional<Servizio> servizio = servS.ricercaServizioId(id);
	        	Servizio ser=servizio.get();
	            Comprende comprende = new Comprende();
	            comprende.setDataAssociazioneComprende(dataAssociazione);
	            comprende.setDescrizioneComprende(descrizioneComprende);
	            comprende.setLavComprende(Lavo);
	            comprende.setServizioComprende(ser);
	            comprende.setFineEsecuzioneServizio(false);
            
	            compS.insertCOmprende(comprende);
            }
	        model.addAttribute("Messaggio", "Servizi inseriti correttamente");
	        return "redirect:/GestPulizie/effettuaPrenotazione";
 		}
		else
		{
			
			return "redirect:/GestPulizie/loginClienteHome";
		}
 
   }
 
 
 
 
	@PostMapping("/sceltaSedeCliente")
	public String sceltaSedeCliente(HttpSession session, Model model, @RequestParam String descrizioneLavorazione, @RequestParam Long idSede, @RequestParam Date dataPrevistaEsecuzione, @RequestParam String descrizione)
	{
		String cfVeriicatoCli=(String)session.getAttribute("cfVerificatoCli");
		if(cfVeriicatoCli!=null)
		{	
			
			LocalDate dataPrenotazioneLavorazione=LocalDate.now();
			Optional<Cliente> cliente= cliS.ricercaClienteCf(cfVeriicatoCli);
		  	Lavorazione lav = new Lavorazione();
	        lav.setDataPrenotazioneLavorazione(dataPrenotazioneLavorazione);
	        lav.setDataPrevistaEsecuzione(dataPrevistaEsecuzione);
	        lav.setDescrizioneLavorazione(descrizioneLavorazione);
	        
	        Lavorazione lavorazione=lav;
	        this.lS.aggiungiLavorazione(lav);
	        Squadra squadraFinta=sS.SeleSquadraFinta();
	        
	        
	        Optional<Sede>sedeSelezionata =SedS.ricercaSedeId(idSede);
	        Sede sedeSele=sedeSelezionata.get();	        
	        Esegue esegue=new Esegue();
	        esegue.setAcconto(0D);
	        esegue.setDescrizione(descrizione);
	        esegue.setLavEsegue(lavorazione);
	        esegue.setSqEsegue(squadraFinta);
	        esegue.setSedeEsegue(sedeSele);
	        esegue.setCompletato(false);
	        
	        eS.aggiungiEsegue(esegue);
	        
	        
	        AppSedeDto appSedeDto=new AppSedeDto();
            appSedeDto.setCfCliente(cliente.get().getCfCliente());
            appSedeDto.setNomeCliente(cliente.get().getNomeCliente());
            appSedeDto.setCognomeCliente(cliente.get().getCognomeCliente());
            appSedeDto.setIdSede(esegue.getSedeEsegue().getIdSede());
            appSedeDto.setIdLavorazione(esegue.getLavEsegue().getIdLavorazione());
	        appSedeDto.setDataPrevistaLavorazione(dataPrevistaEsecuzione);
	        model.addAttribute("appSedeDto",appSedeDto);
	        session.setAttribute("esegue",esegue);
	        session.setAttribute("appSedeDto", appSedeDto);
	        return "effettuaPrenotazione";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginClienteHome";
		}
	}
 
 
	
	@GetMapping("/cancellaPrenotazioneHome")
	public String cancPrenotazione(HttpSession session, Model mod)
	{
		String cfVeriicatoCli=(String)session.getAttribute("cfVerificatoCli");
		if(cfVeriicatoCli!=null)
		{	
			List <ComprendeDto> listLavCli = lS.ottieniListaDtoCliente(cfVeriicatoCli);
			mod.addAttribute("listLavCli", listLavCli);
			return "cancellaPrenotazione";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginClienteHome";
		}
		
	}
	
	
	@PostMapping("/cancellaPrenotazione")
	public String cancellaPrenotazione(HttpSession session, Model mod, @RequestParam Long[] idLavorazione)
	{
		String cfVeriicatoCli=(String)session.getAttribute("cfVerificatoCli");
		if(cfVeriicatoCli!=null)
		{	
			for(Long id: idLavorazione)
			{
				lS.cancellaLavorazione(id);
			}
			return "redirect:/GestPulizie/cancellaPrenotazioneHome";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginClienteHome";
		}
		
	}
	
	 

	
	@GetMapping("/index")
	public String ind() {

		return "index";
	}
	
	
	@GetMapping("/operaioHome")
	public String operaio(HttpSession session, Model x)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{			
			return "operaio";
		}
		else
		{
			
			x.addAttribute("errore","I dati inseriti non sono corretti");
			return "redirect:/GestPulizie/loginOperaioHome";
			
		}
	}		
	
	
	@PostMapping("/operaio")
	public String opServ(HttpSession session, Model x, @RequestParam Date primaData, Date secondaData)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			List<ComprendeDto> lavIntervalloDate = lS.selezioneIntervalloDate(cfVerificato, primaData, secondaData);
			if(lavIntervalloDate.size()>0)
			{
				x.addAttribute("lavIntervalloDate" ,lavIntervalloDate);
			}
			else
			{
				x.addAttribute("nonPresenti" ,"Non ci sono lavorazioni effettuate in queste date");
			}
			
			return "operaio";
		}
		else
		{
			
			x.addAttribute("errore","I dati inseriti non sono corretti");
			return "redirect:/GestPulizie/loginOperaioHome";
			
		}

	}
	
	
	
	@PostMapping("/viewLavInt")
	public String viewLavInt(HttpSession session, Model x, @RequestParam Long idLavorazione)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{
			List<ComprendeDto> lavData = lS.ottieniListaDtoIdLav(idLavorazione);
			
			x.addAttribute("lavData" ,lavData);
			
			return "viewLavInt";
		}
		else
		{
			
			x.addAttribute("errore","I dati inseriti non sono corretti");
			return "redirect:/GestPulizie/loginOperaioHome";
			
		}
	}
	
	
	
	
	
	@GetMapping("/lavoriHome")
	public String lavori(HttpSession session, Model x)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{			
			return "lavori";
		}
		else
		{
			
			x.addAttribute("errore","I dati inseriti non sono corretti");
			return "redirect:/GestPulizie/loginOperaioHome";
			
		}
	}
		
	
	@PostMapping("/lavori")
	public String lavori(HttpSession session, Model x, @RequestParam Date dataPrevistaEsecuzione)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{			

			List<ComprendeDto>compDto= lS.ottieniListaDto(cfVerificato);
			x.addAttribute("compDto", compDto);
			x.addAttribute("dataDaRic", dataPrevistaEsecuzione);
			session.setAttribute("compDto", compDto);
			return "lavori";
		}
		else
		{
			
			x.addAttribute("errore","I dati inseriti non sono corretti");
			return "redirect:/GestPulizie/loginOperaioHome";
			
		}
	}
	
	
	@GetMapping("/visualizzaLavoriHome")
	public String visualizzaLav(HttpSession session, Model x)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{	
			Date dataPrevistaEsecuzione=(Date)session.getAttribute("dataPrevistaEsecuzione");
			Long idLavorazione=(Long)session.getAttribute("idLavorazione");
			List<ComprendeDto>compDto= lS.ottieniListaDto(cfVerificato);
			x.addAttribute("compDto", compDto);
			x.addAttribute("dataDaRic",dataPrevistaEsecuzione);
			x.addAttribute("lavori",idLavorazione);
			return "visualizzaLavori";
		}
		else
		{
			
			return "redirect:/GestPulizie/loginOperaioHome";
			
		}
	}
	
	
	
	@PostMapping("/visualizzaLavori")
	public String visualizzaLavori(HttpSession session, @RequestParam Long idLavorazione, Model x, @RequestParam Date dataPrevistaEsecuzione)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{	
			
			
			
			List<ComprendeDto>compDto= lS.ottieniListaDto(cfVerificato);
			x.addAttribute("compDto", compDto);
			x.addAttribute("dataDaRic",dataPrevistaEsecuzione);
			x.addAttribute("lavori",idLavorazione);
			return "visualizzaLavori";
		}
		else
		{
			
			x.addAttribute("errore","I dati inseriti non sono corretti");
			return "redirect:/GestPulizie/loginOperaioHome";
			
		}
		
	}
	
	
	
	@GetMapping("/aggiornaServizioHome")
	public String aggiornaServiz(HttpSession session, Model x, @RequestParam Long idComprende, Long idLavorazione, Date dataPrevistaEsecuzione)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{	
			List<ComprendeDto>compDto= lS.ottieniListaDto(cfVerificato);
			
			Optional<Comprende> co=compS.ricercaComprendeId(idComprende);
			Comprende compre=co.get();
	
			compre.setFineEsecuzioneServizio(true);
			
			compS.aggiornaComprende(compre);
			Long idEsegue=0L;
			Optional<Lavorazione> lav = lS.ricercaLavorazioneId(idLavorazione);
			for(int k=0;k<lav.get().getElencoLavorazione().size();k++)
			{
				idEsegue=lav.get().getElencoLavorazione().get(k).getIdEsegue();
			}
			
			Optional<Esegue> ese=eS.ricercaEsegueId(idEsegue);
			List<Comprende> comprende=compS.ricercaByIdLav(idLavorazione);
			int count=0;
			for(int j=0; j<comprende.size();j++)
			{
				if(comprende.get(j).getFineEsecuzioneServizio()==true)
				{
					count++;
				}
			}
			LocalDate dataLavoroEseguito =LocalDate.now();
			if(count==comprende.size())
			{
				ese.get().setDataLavoroEseguito(dataLavoroEseguito);
				ese.get().setCompletato(true);
			}
			
			
			
			x.addAttribute("compDto", compDto);
			x.addAttribute("dataDaRic",dataPrevistaEsecuzione);
			x.addAttribute("lavori",idLavorazione);
			return "redirect:/GestPulizie/visualizzaLavori";
		}
		else
		{
			
			x.addAttribute("errore","I dati inseriti non sono corretti");
			return "redirect:/GestPulizie/loginOperaioHome";
			
		}
	}
	
	@PostMapping("/aggiornaServizio")
	public String aggiornaServizio(HttpSession session, Model x, @RequestParam Long idComprende, Long idLavorazione, Date dataPrevistaEsecuzione)
	{
		String cfVerificato=(String)session.getAttribute("cfOperaio");
		if(cfVerificato!=null)
		{	
			List<ComprendeDto>compDto= lS.ottieniListaDto(cfVerificato);
			
			Optional<Comprende> co=compS.ricercaComprendeId(idComprende);
			Comprende compre=co.get();
	
			compre.setFineEsecuzioneServizio(true);
			
			compS.aggiornaComprende(compre);
			session.setAttribute("idLavorazione", idLavorazione);
			session.setAttribute("dataPrevistaEsecuzione", dataPrevistaEsecuzione);
			x.addAttribute("compDto", compDto);
			x.addAttribute("dataDaRic",dataPrevistaEsecuzione);
			x.addAttribute("lavori",idLavorazione);
			return "redirect:/GestPulizie/visualizzaLavori";
		}
		else
		{
			
			x.addAttribute("errore","I dati inseriti non sono corretti");
			return "redirect:/GestPulizie/loginOperaioHome";
			
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		
		session.invalidate();
		return "redirect:/GestPulizie/index";
	}
	
	
	
	
			//Login Cliente
	@GetMapping("/loginClienteHome")
	public String LoginCliente() {
		return "loginCliente";
	}
		
	@PostMapping("/loginCliente")
	public String loginCliente(HttpSession session,@RequestParam String usernameCliente, String pswCliente, Model model) {
		Optional<Cliente> cli=cliS.ricClienteUserPsw(pswCliente, usernameCliente);
		if(cli.isPresent())
		{
			session.setAttribute("cfVerificatoCli", cli.get().getCfCliente());
			return "cliente";
			
		}
		
		else
		{
			return "loginCliente";
		}
	}	
		
	//Login Operaio
	@GetMapping("/loginOperaioHome")
	public String LoginOperaio() {
		return "loginOperaio";
	}
	
	
	@PostMapping("/loginOperaio")
	public String loginOperaio(HttpSession session,@RequestParam String usernameOperaio, String pswOperaio, Model model) 
	{
		Optional<Operaio> op= Os.ricOperaioUserPsw(pswOperaio, usernameOperaio);
		if(op.isPresent())
		{
			session.setAttribute("cfOperaio", op.get().getCfOperaio());
			if(op.get().getOpCat().getIdCategoria()==1)
			{
				return "admin";
			}
			else
			{		
				return "operaio";
			}
		}
		else {
			return "redirect:/GestPulizie/loginOperaioHome";
		}
		
	}
	
	
	
	
	@GetMapping("/registrazioneHome")
	public String registrazione()
	{
		return "registrazione";
	}
	
	
	@PostMapping("/registrazione")
	public String registrati(@ModelAttribute Cliente c, Model reg) {
		Optional<Cliente> cliUserPsw = cliS.ricClienteUserPsw(c.getPswCliente(), c.getUsernameCliente());
		Optional <Cliente> cliCf = cliS.ricercaClienteCf(c.getCfCliente());
		if(cliCf.isPresent()==false)
		{
			if(cliUserPsw.isPresent()==false)
			{
				cliS.registrazione(c);
				reg.addAttribute("registrazione", "La registrazione è avvenuta con successo");
			}
			else
			{
				reg.addAttribute("Non è possibile registrarsi");
			}
		}
		else
		{
			reg.addAttribute("registrazione", "Utente già presente");
		}
		return "redirect:/GestPulizie/loginClienteHome";
	}
	
	
	
	
	
}