package br.edu.ifes.defensor.adapters;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import br.edu.ifes.defensor.annotations.Component.InterfaceComponent;
import br.edu.ifes.defensor.exception.DefensorException;

public class SwingAdapter implements InterfaceAdapter {
   
    @Override
    public Component getComponentFor(InterfaceComponent iComponent) {
        switch (iComponent) {
            case TEXTFIELD:
                return new JTextField();
            case CHECKBOX:
                return new JCheckBox();
            case COMBOBOX:
                return new JComboBox();
        }
        return null;
    }

    @Override
    public Object getValueOfComponent(Component component) {
        Object returnValue = null;
        if (component.getClass().isAssignableFrom(JTextField.class)) {
            returnValue = ((JTextField)component).getText();
        } else if (component.getClass().isAssignableFrom(JComboBox.class)) {
            returnValue = ((JComboBox)component).getSelectedItem();
        } else if (component.getClass().isAssignableFrom(JCheckBox.class)) {
            returnValue = ((JCheckBox)component).isSelected();
        }
        return returnValue;
    }

    @Override
    public void setValueOfComponent(Component component, Object value) throws DefensorException {
        if (component.getClass().isAssignableFrom(JTextField.class)) {
            ((JTextField)component).setText(value.toString());
        } else if (component.getClass().isAssignableFrom(JComboBox.class)) {
            ((JComboBox)component).setSelectedItem(value);
        } else if (component.getClass().isAssignableFrom(JCheckBox.class)) {
            try {
                Boolean bValue = (Boolean) value;
                ((JCheckBox)component).setSelected(bValue);
            } catch (ClassCastException e) {
                throw new DefensorException("O valor para o componente JCheckBox não é booleano!", e);
            }
        }
    }


}
