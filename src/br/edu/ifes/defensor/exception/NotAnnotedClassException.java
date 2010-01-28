package br.edu.ifes.defensor.exception;

/**
 * 
 * Ocorre quando é solicitado ao framework que trabalhe com um objeto não anotado com a anotação <code>DObject</code>.
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 *
 */
public class NotAnnotedClassException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotAnnotedClassException(String message) {
        super(message);
    }

}
