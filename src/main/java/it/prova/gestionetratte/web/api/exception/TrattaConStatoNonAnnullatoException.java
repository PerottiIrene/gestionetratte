package it.prova.gestionetratte.web.api.exception;

public class TrattaConStatoNonAnnullatoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public TrattaConStatoNonAnnullatoException(String message) {
		super(message);
	}

}
