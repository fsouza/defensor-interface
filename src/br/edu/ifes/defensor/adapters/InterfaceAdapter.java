package br.edu.ifes.defensor.adapters;

import java.awt.Component;

import br.edu.ifes.defensor.annotations.Component.InterfaceComponent;
import br.edu.ifes.defensor.exception.DefensorException;

/**
 * Fornece métodos para um interface adapter (Swing, etc.)
 * 
 * @param <C>
 *          Tipo de componente com o qual a interface trabalhará (JComponent, etc.)
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 *
 */
public interface InterfaceAdapter {
    
    /**
     * Obtém o componente de acordo com o tipo especificado na enumeração <code>InterfaceComponent</code>
     * 
     * @param iComponent
     *              Tipo do componente (enum <code>InterfaceComponent</code> dentro da anotação <code>Component</code> 
     * @return Componente
     * 
     * @throws DefensorException
     *              Encapsulamento de qualquer exceção ocorrida internamente.
     */
    public Component getComponentFor(InterfaceComponent iComponent) throws DefensorException;
    
    /**
     * Obtém o valor de um componente informado.
     * 
     * @param component
     *              Componente do qual deseja-se obter o valor.
     * @return Valor do componente passado por parâmetro
     * 
     * @throws DefensorException
     *              Encapsulamento de qualquer exceção ocorrida internamente.
     */
    public Object getValueOfComponent(Component component) throws DefensorException;
    
    /**
     * Grava um valor em um determinado componente.
     * 
     * @param component
     *              Componente no qual o valor será armazenado.
     * @param value
     *              Valor que será armazenado
     * 
     * @throws DefensorException
     *              Encapsulamento de qualquer exceção ocorrida internamente.
     */
    public void setValueOfComponent(Component component, Object value) throws DefensorException;

}
