package it.prova.gestionetratte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.repository.airbus.AirbusRepository;

@Service
public class AirbusServiceImpl implements AirbusService{
	
	@Autowired
	private AirbusRepository repository;

	@Override
	public List<Airbus> listAllElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Airbus> listAllElementsEager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airbus caricaSingoloElemento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airbus caricaSingoloElementoConFilms(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airbus aggiorna(Airbus airbusInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Airbus inserisciNuovo(Airbus airbusInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rimuovi(Long idToRemove) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Airbus> findByExample(Airbus example) {
		// TODO Auto-generated method stub
		return null;
	}

}
