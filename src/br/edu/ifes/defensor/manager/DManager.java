package br.edu.ifes.defensor.manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que atua como controladora no Defensor Interface, gerenciando a geração das janelas e seus eventos.
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 *
 * TODO: Refazer documentação desta classe
 *
 */
public class DManager {
    
    private List<Object> objects;
    
    /**
     * TODO: Documentar método construtor da classe DManager
     * 
     * @param object
     */
    public DManager(Object object) {
        super();
        this.objects = new ArrayList<Object>();
        this.objects.add(object);
    }
    
    /**
     * TODO: Documentar método construtor da classe DManager
     * 
     * @param objects
     */
    public DManager(List<Object> objects) {
        super();
        this.objects = objects;
    }
    
    public DManager() {
        this(new ArrayList<Object>());
    }

    /**
     * Cria uma janela de cadastro de um objeto simples
     * 
     * @param object
     *          Objeto para o qual a janela será gerada.
     */
    public void createSingleObjectWindow() {
        this.createSingleObjectWindow(this.objects.get(0)); 
    }
    
    /**
     * Cria uma janela nova (vazia) de um objeto simples
     * 
     * @param cls
     *          Classe que modela o objeto vazio para o qual a janela será gerada.
     * @throws Exception
     *          Caso ocorra problemas para instanciar um objeto vazio (InstantiationException ou IllegalAccessException)  
     */
    public void createEmptySingleObjectWindow(Class<? extends Object> cls) throws Exception {
        try {
            Object object = cls.newInstance();
            this.objects.add(object);
            this.createSingleObjectWindow(object);
        } catch (Exception e) {
            throw new Exception("Exceção lançada ao tentar instanciar a classe " + cls.getName() + " no método de geração da janela de cadastro para um novo objeto.", e);
        }
    }
    
    private void createSingleObjectWindow(Object object) {
        // TODO Auto-generated method stub
    }

    /**
     * Cria uma janela de listagem dos objetos através da lista passada como parâmetro.
     * 
     * @param objects
     *          Lista de objetos presentes na janela.
     */
    public void createListObjectWindow() {
        // TODO Construir o método de criação da janela de listagem. 
    }
    
}
