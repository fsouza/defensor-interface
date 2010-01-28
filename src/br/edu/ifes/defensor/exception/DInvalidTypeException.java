package br.edu.ifes.defensor.exception;

/**
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 * 
 */
public class DInvalidTypeException extends Exception {

	public DInvalidTypeException() {
	}

	public DInvalidTypeException(String arg0) {
		super(arg0);
	}

	public DInvalidTypeException(Throwable arg0) {
		super(arg0);
	}

	public DInvalidTypeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
