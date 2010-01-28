package br.edu.ifes.defensor.exception;

/**
 * Lançada em erros genéricos, geralmente para encapsular outras exceções.
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 * 
 */
public class DefensorException extends Exception {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public DefensorException() {
	}

	public DefensorException(String message) {
		super(message);
	}

	public DefensorException(Throwable cause) {
		super(cause);
	}

	public DefensorException(String message, Throwable cause) {
		super(message, cause);
	}

}
