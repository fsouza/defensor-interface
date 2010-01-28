package br.edu.ifes.defensor.exception;

/**
 * Disparada quando um método não é encontrado dentro de uma classe.
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 *
 */
public class MethodNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MethodNotFoundException(String arg0) {
        super(arg0);
    }

    public MethodNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
