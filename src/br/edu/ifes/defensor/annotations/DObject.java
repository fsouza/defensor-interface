package br.edu.ifes.defensor.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Define que um POJO é gerenciado pelo framework.
 *  
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DObject {
    /**
     * Atributo que indica qual será o título da janela de cadastrado simples.
     * 
     * Será o valor para título do JFrame relativo ao objeto.
     */
    String titleOfSingleWindow();
    
    /**
     * Atributo que indica qual será o título da janela de listagem.
     * 
     * Será o valor para título do JFrame relativo à lista de objetos.
     */
    String titleOfListWindow();
}
