package it.prova.gestionetratte;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.service.AirbusService;
import it.prova.gestionetratte.service.TrattaService;

@SpringBootApplication
public class GestionetratteApplication implements CommandLineRunner {

	@Autowired
	AirbusService airbusService;

	@Autowired
	TrattaService trattaService;

	public static void main(String[] args) {
		SpringApplication.run(GestionetratteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// creazione airbus1
		Airbus airbusAB = airbusService.findByCodiceAndDescrizione("23btr5", "Argentina-Milano");

		if (airbusAB == null) {
			airbusAB = new Airbus("23btr5", "Argetina-Milano",
					LocalDate.parse("29-09-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 150);
			airbusService.inserisciNuovo(airbusAB);
		}

		// creazione tratta1
		Tratta argentinaMilano = new Tratta("ctrgh6", "Argentina-Milano",
				LocalDate.parse("29-09-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
				LocalTime.parse("15:00:00"),
				LocalTime.parse("22:00:00"), airbusAB);
		
		if (trattaService.findByCodiceAndDescrizione(argentinaMilano.getCodice(), argentinaMilano.getDescrizione()).isEmpty()) {
			trattaService.inserisciNuovo(argentinaMilano);
		}


		// creazione airbus2
		Airbus airbusRS = airbusService.findByCodiceAndDescrizione("56rds2", "Roma-Spagna");

		if (airbusRS == null) {
			airbusRS = new Airbus("56rds2", "Roma-Spagna",
					LocalDate.parse("27-11-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")), 68);
			airbusService.inserisciNuovo(airbusRS);
		}

		// creazione tratta2
		Tratta romaSpagna = new Tratta("dsokaf6", "Roma-Spagna",
				LocalDate.parse("27-11-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
				LocalTime.parse("11:00:00"),
				LocalTime.parse("13:00:00"), airbusRS);

		if (trattaService.findByCodiceAndDescrizione(romaSpagna.getCodice(), romaSpagna.getDescrizione()).isEmpty()) {
			trattaService.inserisciNuovo(romaSpagna);
		}

	}

}
