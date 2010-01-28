package daplicativo;

import javax.swing.JTextField;

import br.edu.ifes.defensor.annotations.Component;
import br.edu.ifes.defensor.annotations.DObject;
import br.edu.ifes.defensor.annotations.Component.InterfaceComponent;
import br.edu.ifes.defensor.base.DComponent;
import br.edu.ifes.defensor.base.WindowObject;
import br.edu.ifes.defensor.exception.DefensorException;
import br.edu.ifes.defensor.exception.MethodNotFoundException;
import br.edu.ifes.defensor.exception.NotAnnotedClassException;

@DObject(titleOfListWindow = "Listagem de clientes", titleOfSingleWindow = "Cadastro de cliente")
public class Cliente {

    @Component(label = "Nome", swingComponent = InterfaceComponent.TEXTFIELD, args = "")
    private String nome;

    @Component(label = "Idade", swingComponent = InterfaceComponent.TEXTFIELD, args = "")
    private Integer Idade;
    
    private String nomeDoPai;

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return Idade;
    }

    public void setIdade(Integer idade) {
        Idade = idade;
    }
    
    public static void main(String[] args) {
        try {
            Cliente cliente = new Cliente();
            cliente.setNome("Francisco");
            cliente.setIdade(20);
            cliente.setNomeDoPai("Fernando");
            
            WindowObject w = new WindowObject(cliente);
            for (DComponent dc : w.components) {
                System.out.print(dc.getLabel() + ": ");
                System.out.println(((JTextField)dc.getComponent()).getText());
            }
        } catch (NotAnnotedClassException e) {
            e.printStackTrace();
        } catch (MethodNotFoundException e) {
            e.printStackTrace();
        } catch (DefensorException e) {
            e.printStackTrace();
        }
    }

}
