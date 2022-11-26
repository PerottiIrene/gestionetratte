package it.prova.gestionetratte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.repository.airbus.AirbusRepository;
import it.prova.gestionetratte.web.api.exception.AirbusConTratteAssociateException;

@Service
public class AirbusServiceImpl implements AirbusService{
	
	@Autowired
	private AirbusRepository repository;

	@Override
	public List<Airbus> listAllElements() {
		return (List<Airbus>) repository.findAll();
	}

	@Override
	public List<Airbus> listAllElementsEager() {
		return (List<Airbus>) repository.findAllEager();
	}

	@Override
	public Airbus caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Airbus caricaSingoloElementoConTratte(Long id) {
		return repository.findByIdEager(id);
	}

	@Override
	public Airbus aggiorna(Airbus airbusInstance) {
		return repository.save(airbusInstance);
	}

	@Override
	public Airbus inserisciNuovo(Airbus airbusInstance) {
		return repository.save(airbusInstance);
	}

	@Override
	public void rimuovi(Long idToRemove) {
		
		Airbus airbus=repository.findById(idToRemove).orElse(null);
		
		if(airbus.getTratte().size() != 0) {
			throw new AirbusConTratteAssociateException("questo airbus non puo essere rimosso, e' associato a delle tratte!");
		}
		repository.deleteById(idToRemove);
	}

	@Override
	public List<Airbus> findByExample(Airbus example) {
		return repository.findByExample(example);
	}

	@Override
	public Airbus findByCodiceAndDescrizione(String codice, String descrizione) {
		return repository.findByCodiceAndDescrizione(codice, descrizione);
	}

}
