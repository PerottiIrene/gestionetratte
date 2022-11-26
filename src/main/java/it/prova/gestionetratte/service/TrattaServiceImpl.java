package it.prova.gestionetratte.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionetratte.model.Stato;
import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.repository.tratta.TrattaRepository;
import it.prova.gestionetratte.web.api.exception.TrattaConStatoNonAnnullatoException;

@Service
public class TrattaServiceImpl implements TrattaService {

	@Autowired
	private TrattaRepository repository;

	@Override
	public List<Tratta> listAllElements(boolean eager) {
		if (eager)
			return (List<Tratta>) repository.findAllTrattaEager();

		return (List<Tratta>) repository.findAll();
	}

	@Override
	public Tratta caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Tratta caricaSingoloElementoEager(Long id) {
		return repository.findSingleTrattaEager(id);
	}

	@Override
	public Tratta aggiorna(Tratta trattaInstance) {
		return repository.save(trattaInstance);
	}

	@Override
	public Tratta inserisciNuovo(Tratta trattaInstance) {
		return repository.save(trattaInstance);
	}

	@Override
	public void rimuovi(Long idToRemove) {
		
		Tratta tratta=repository.findById(idToRemove).orElse(null);
		
		if(tratta.getStato() == Stato.ATTIVA || tratta.getStato() == Stato.CONCLUSA) {
			throw new TrattaConStatoNonAnnullatoException("la tratta non puo essere rimossa, il suo stato non e' annullato");
		}
		repository.deleteById(idToRemove);
	}

	@Override
	public List<Tratta> findByExample(Tratta example) {
		return repository.findByExample(example);
	}

	@Override
	public List<Tratta> findByCodiceAndDescrizione(String codice, String descrizione) {
		return repository.findByCodiceAndDescrizione(codice, descrizione);
	}

	@Override
	public void concludiTratte() {
		
		List<Tratta> listaTratte= (List<Tratta>) repository.findAll();
		
		for(Tratta trattaItem: listaTratte) {
			if(trattaItem.getStato()== Stato.ATTIVA && LocalTime.now().isAfter(trattaItem.getOraAtterraggio()))
				trattaItem.setStato(Stato.CONCLUSA);
			repository.save(trattaItem);
		}
	}

}
