package br.edu.ifes.defensor.manager;

import java.util.List;

/**
 * Classe que atua como controladora no Defensor Interface, gerenciando a geração das janelas e seus eventos.
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 *
 */
public class DManager {

    /**
     * Esta classe não deve ser instanciada externamente, por isso possui um construtor privado.
     */
    private DManager() {
        
    }
    
    /**
     * Cria uma janela de cadastro de um objeto simples
     * 
     * @param object
     *          Objeto para o qual a janela será gerada.
     */
    public static void createSingleObjectWindow(Object object) {
        // TODO: Construir o método de criação da janela de cadastro de um objeto 
    }
    
    /**
     * Cria uma janela nova (vazia) de um objeto simples
     * 
     * @param cls
     *          Classe que modela o objeto vazio para o qual a janela será gerada.
     * @throws Exception
     *          Caso ocorra problemas para instanciar um objeto vazio (InstantiationException ou IllegalAccessException)  
     */
    public static void createSingleObjectWindow(Class<? extends Object> cls) throws Exception {
        try {
            DManager.createSingleObjectWindow(cls.newInstance());
        } catch (Exception e) {
            throw new Exception("Exceção lançada ao tentar instanciar a classe " + cls.getName() + " no método de geração da janela de cadastro para um novo objeto.", e);
        }
    }
    
    /**
     * Cria uma janela de listagem dos objetos através da lista passada como parâmetro.
     * 
     * @param objects
     *          Lista de objetos presentes na janela.
     */
    public static void createListObjectWindow(List<Object> objects) {
        // TODO Construir o método de criação da janela de listagem. 
    }
    
}
