package br.edu.ifes.defensor.base;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import net.vidageek.mirror.dsl.Mirror;
import br.edu.ifes.defensor.adapters.InterfaceAdapter;
import br.edu.ifes.defensor.adapters.SwingAdapter;
import br.edu.ifes.defensor.annotations.Component;
import br.edu.ifes.defensor.annotations.DObject;
import br.edu.ifes.defensor.annotations.Component.InterfaceComponent;
import br.edu.ifes.defensor.exception.DefensorException;
import br.edu.ifes.defensor.exception.MethodNotFoundException;
import br.edu.ifes.defensor.exception.NotAnnotedClassException;

/**
 * Classe que representa um objeto de janela, contendo um objeto de regra de
 * negócio e uma lista de objetos do tipo DComponent.
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 */
public class WindowObject {

    private Object dObject;

    public List<DComponent> components;

    private Boolean fill;

    private InterfaceAdapter adapter;

    /**
     * Método construtor que recebe apenas o objeto.
     * 
     * Gera a instância assumindo que o objeto não é novo e que será utilizado o adapter Swing
     * 
     * @param dObject
     *          Objeto correspondente à janela atual
     * @throws NotAnnotedClassException
     *          Caso o objeto passado por parâmetro não esteja com a anotação
     *          DObject.
     * @throws MethodNotFoundException
     * @throws DefensorException
     */
    public WindowObject(Object dObject) throws NotAnnotedClassException, MethodNotFoundException, DefensorException {
        this(dObject, new SwingAdapter(), false);
    }

    /**
     * Gera a instância assumindo que o objeto informado não é novo.
     * 
     * @param dObject
     *            Objeto correspondente à janela atual
     * @param adapter
     *            Adapter da interface responsável por gerenciar os componentes.
     * @throws NotAnnotedClassException
     *             Caso o objeto passado por parâmetro não esteja com a anotação
     *             DObject.
     * @throws MethodNotFoundException
     * @throws DefensorException
     */
    public WindowObject(Object dObject, InterfaceAdapter adapter) throws NotAnnotedClassException, MethodNotFoundException, DefensorException {
        this(dObject, adapter, false);
    }

    /**
     * 
     * @param dObject
     *            Objeto correspondente à janela atual
     * @param adapter
     *            Adapter da interface responsável por gerenciar os componentes.
     * @param empty
     *            Indica se o objeto está vazio
     * @throws NotAnnotedClassException
     *             Caso o objeto passado por parâmetro não esteja com a anotação
     *             DObject.
     * @throws MethodNotFoundException
     * @throws DefensorException
     */
    public WindowObject(Object dObject, InterfaceAdapter adapter, Boolean empty) throws NotAnnotedClassException, MethodNotFoundException,
            DefensorException {
        super();
        this.dObject = dObject;
        this.adapter = adapter;
        this.fill = !empty;
        this.buildComponentsList();
    }

    /**
     * Método que constrói a lista de componentes navegando pelo objeto.
     * 
     * @throws NotAnnotedClassException
     * @throws MethodNotFoundException
     * @throws DefensorException
     */
    private void buildComponentsList() throws NotAnnotedClassException, MethodNotFoundException, DefensorException {
        this.components = new LinkedList<DComponent>();
        Class<? extends Object> cls = this.dObject.getClass();
        DObject dObjectAnnotation = cls.getAnnotation(DObject.class);
        if (dObjectAnnotation == null) {
            throw new NotAnnotedClassException("A classe " + cls.getClass().getName()
                    + " não está anotada como um objeto gerenciado pelo framework Defensor Interface.");
        }
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            Component component = field.getAnnotation(Component.class);
            if (component != null) {
                this.components.add(this.buildComponent(component, field));
            }
        }
    }

    /**
     * 
     * @param componentAnnotation
     *            Anotação do tipo Component da qual o componente será extraído.
     * @param field
     *            Atributo contendo a informação do componente.
     * 
     * @return Um DComponent montado.
     * 
     * @throws MethodNotFoundException
     *             Caso algum field não possua um método getter.
     * @throws DefensorException
     *             Erros na invocação do método getter para obtenção do valor.
     */
    private DComponent buildComponent(Component componentAnnotation, Field field) throws MethodNotFoundException, DefensorException {
        try {
            Mirror mirror = new Mirror();
            String label = componentAnnotation.label();
            InterfaceComponent swingComponent = componentAnnotation.swingComponent();
            java.awt.Component component = this.adapter.getComponentFor(swingComponent);
            if (this.fill) {
                Object fieldValue = mirror.on(this.dObject).get().field(field);
                this.adapter.setValueOfComponent(component, fieldValue);
            } else {
                this.fill = Boolean.TRUE;
            }
            return new DComponent(label, component, field);
        } catch (Exception e) {
            throw new DefensorException("Erro na geração de um componente.", e);
        }
    }

}
