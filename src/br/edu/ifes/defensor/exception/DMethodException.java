/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.defensor.exception;

/**
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 * 
 */
public class DMethodException extends Exception {

	public DMethodException() {
	}

	public DMethodException(String msg) {
		super(msg);
	}

	public DMethodException(Throwable t) {
		super(t);
	}

	public DMethodException(String msg, Throwable t) {
		super(msg, t);
	}
}
