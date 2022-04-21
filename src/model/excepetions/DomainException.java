package model.excepetions;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L; //classes serializadas necessitam de n�mero de vers�o
	
	// � necess�rio esse construtor para passar a mensagem de erro para a super classe
	public DomainException (String msg) {
		super(msg);
	}	
	
}
