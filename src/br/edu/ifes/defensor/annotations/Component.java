package br.edu.ifes.defensor.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Define que o atributo será um componente da janela do objeto pai.
 * 
 * Esta anotação deve ser utilizada em atributos de uma classe mapeada pela anotação <code>DObject</code>
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    public enum InterfaceComponent { TEXTFIELD, COMBOBOX, CHECKBOX };
    
    /**
     * Componente de interface que representará o atributo sendo mapeado na tela.
     */
    InterfaceComponent swingComponent();
    
    /**
     * Label que será exibida à frente do componente (outro atributo)
     * 
     * Este valor também aparecerá no cabeçalho da tabela na tela de listagens.
     */
    String label();
    
    /**
     * Argumentos extras.
     * 
     * Pode ser um vetor contendo as opções de um JComboBox, por exemplo.
     */
    String[] args();
}
