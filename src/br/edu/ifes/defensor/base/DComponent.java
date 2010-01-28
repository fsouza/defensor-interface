package br.edu.ifes.defensor.base;

import java.awt.Component;
import java.lang.reflect.Field;


/**
 * 
 * Modela um componente de janela do framework.
 * 
 * Para o framework, um componente é composto por um rótulo (label) e um Component (da biblioteca java.awt)
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 * 
 */
public class DComponent {

    private String label;
    
    private Component component;
    
    private Field dataField;

    public DComponent(String label, Component component, Field dataField) {
        super();
        this.label = label;
        this.component = component;
        this.dataField = dataField;
    }

    /**
     * 
     * @return Rótulo do componente.
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * 
     * @return Objeto de interface (por exemplo, um componente Java Swing) do componente.
     */
    public Component getComponent() {
        return this.component;
    }

    /**
     * 
     * @return Objeto que contém os dados.
     */
    public Field getDataField() {
        return this.dataField;
    }
    
}
