document.getElementById("associaServizio").addEventListener("submit", function(servizioScelto){
	const servizi = document.querySelectorAll('input[name="idServizio"]');
	let i;
	let servizioSelezionato=false;
	for(i=0;i<servizi.length;i++)
	{
		if(servizi[i].checked)
		{
			servizioSelezionato=true;
			break;
		}
	}
	if(!servizioSelezionato)
	{
		servizioScelto.preventDefault();
		alert("Seleziona almeno un servizio");
	}
	
	
});



document.getElementById("newOp").addEventListener("submit", function(opSelezionato){
	const operatore = document.querySelectorAll('input[name="cfOperaio"]');
	let j;
	let opSelezionato=false;
	for(j=0;j<servizi.length;j++)
	{
		if(operatore[j].checked)
		{
			opSelezionato=true;
			break;
		}
	}
	if(!opSelezionato)
	{
		opSelezionato.preventDefault();
		alert("Seleziona almeno un Operatore");
	}
	
	
});



document.getElementById("cancLav").addEventListener("submit", function(Lavorazione){
	const lavorazioni = document.querySelectorAll('input[name="idLavorazione"]');
	let k;
	let Lavorazione=false;
	for(k=0;k<servizi.length;k++)
	{
		if(lavorazioni[k].checked)
		{
			Lavorazione=true;
			break;
		}
	}
	if(!Lavorazione)
	{
		opSelezionato.preventDefault();
		alert("Seleziona almeno un Ordine");
	}
	
	
});


		
		
		