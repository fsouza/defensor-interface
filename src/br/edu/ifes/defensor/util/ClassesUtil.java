package br.edu.ifes.defensor.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.edu.ifes.defensor.exception.MethodNotFoundException;

/**
 * Classe com utilitários para trabalhar com instâncias.
 * 
 * @author Francisco Antônio da Silva souza
 * @version 1.0
 * 
 */
public class ClassesUtil {

	/**
	 * Gera uma instância completa de uma classe, com valores padrões para
	 * tipos.
	 * 
	 * Caso a classe esteja associada a outra classe, é ativada a recursividade,
	 * que cria instâncias completas em todas as associações de todas as
	 * classes.
	 * 
	 * Este método pode ser lento em modelos de classes complexos e com muitas
	 * associações.
	 * 
	 * @param cls
	 *            Classe que terá uma instância completa.
	 * @return Objeto instanciado.
	 * @throws Exception
	 *             Problemas de instanciação ou argumentos inválidos.
	 */
	public static Object getCompleteInstance(Class<? extends Object> cls) throws Exception {
		Method[] methods = cls.getDeclaredMethods();
		Object obj = cls.newInstance();
		for (Method method : methods) {
			if (method.getName().substring(0, 3).equals("set")) {
				Class<? extends Object> parameter = method.getParameterTypes()[0];
				Object value = null;
				if (parameter.equals(Integer.class)) {
					value = 0;
				} else if (parameter.equals(Double.class)) {
					value = 0.0;
				} else if (parameter.equals(Boolean.class)) {
					value = false;
				} else if (parameter.equals(String.class)) {
					value = "";
				} else {
					try {
						value = ClassesUtil.getCompleteInstance(parameter);
					} catch (Exception e) {
						value = null;
					}
				}
				Object[] args = { value };
				method.invoke(obj, args);
			}
		}
		return obj;
	}
	
	/**
	 * Localiza um método pelo nome dentro da classe.
	 * 
	 * @param cls
	 *         Classe na qual o método será buscado
	 *         
	 * @param methodName
	 *         Nome do método que será buscado
	 *         
	 * @return Método encontrado
	 * 
	 * @throws MethodNotFoundException
	 *             Caso não encontre o método dentro da classe 
	 */
	public static Method getMethodByName(Class<? extends Object> cls, String methodName) throws MethodNotFoundException {
	    Method[] methods = cls.getDeclaredMethods();
	    for (Method method : methods) {
	        if (method.getName().equals(methodName)) {
	            return method;
	        }
	    }
	    throw new MethodNotFoundException("Método " + methodName + " não existe na classe " + cls.getName() + ".");
	}
	
	/**
	 * Retorna o método getter de um atributo informado.
	 * 
	 * @param cls
	 *         Classe na qual o método deve ser buscado.
	 * @param field
	 *         Atributo do qual pretende-se obter o método getter.
	 * 
	 * @return Método getter do atributo informado
	 * @throws MethodNotFoundException
	 *         Caso o método não seja encontrado dentro da classe. Pode ocorrer caso o atributo não pertença à classe ou não possua um método getter padronizado.
	 */
	public static Method getGetterMethodOfField(Class<? extends Object> cls, Field field) throws MethodNotFoundException {
	    return ClassesUtil.getMethodByName(cls, ClassesUtil.buildMethodName("get", field.getName()));
	}
	
	/**
     * Retorna o método setter de um atributo informado.
	 * @param cls TODO
	 * @param field
     *         Atributo do qual pretende-se obter o método setter.
     * 
     * @return Método setter do atributo informado
	 * @throws MethodNotFoundException
	 *         Caso o método não seja encontrado dentro da classe. Pode ocorrer caso o atributo não pertença à classe ou não possua um método setter padronizado.
     */
	public static Method getSetterMethodOfField(Class<? extends Object> cls, Field field) throws MethodNotFoundException {
	    return ClassesUtil.getMethodByName(cls, ClassesUtil.buildMethodName("set", field.getName()));
	}
	
	/**
	 * Constrói o nome de um método (getter ou setter, especificamente)
	 * 
	 * @param prefix
	 *         Prefixo do nome do método (geralmente "get" ou "set")
	 * @param fieldName
	 *         Nome do atributo para o qual o método de acesso será criado
	 * 
	 * @return O nome do método
	 */
	private static String buildMethodName(String prefix, String fieldName) {
	    String sufix = fieldName.substring(0, 1).toUpperCase();
	    sufix += fieldName.substring(1);
	    return prefix + sufix;
	}
}
