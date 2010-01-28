package br.edu.ifes.defensor.graphic;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * Esta classe gerencia o layout da janela de cadastro, sendo responsável pelo
 * tamanho da janela, o tamanho e o posiccionamento dos componentes e dos
 * labels.
 * 
 * @author Francisco Antônio da Silva Souza
 * @version 1.0
 * 
 */
public class DLayoutBuilder {
	private int labelX, labelY, labelWidth, labelHeight;
	private int componentX, componentY, componentWidth, componentHeight;
	private final int increment = 30;

	/**
	 * Método que constrói o objeto do tipo <code>DLayoutBuilder</code>,
	 * configurando todos os elementos encapsulados pelo objeto.
	 */
	public DLayoutBuilder() {
		super();
		this.labelX = 2;
		this.labelY = 2;
		this.labelWidth = 180;
		this.labelHeight = 30;

		this.componentX = 190;
		this.componentY = 2;
		this.componentWidth = 400;
	}

	/**
	 * Calcula e retorna o tamanho e o posicionamento da próxima label a ser
	 * adicionada na janela.
	 * 
	 * @param label
	 *            Objeto do tipo <code>JLabel</code> utilizado no cálculo.
	 * @return Objeto com informações de tamanho e posicionamento do próximo
	 *         rótulo a ser adicionado na janela.
	 */
	public Rectangle getNextLabelBounds(JLabel label) {
		int size = label.getText().length() * 6;
		if (size > this.labelWidth) {
			this.labelWidth = size;
		}
		Rectangle rectangle = new Rectangle(this.labelX, this.labelY, this.labelWidth, this.labelHeight);
		this.labelY += this.increment;
		return rectangle;
	}

	/**
	 * Calcula e retorna o tamanho e o posicionamento do próximo componente a
	 * ser adicionado na janela.
	 * 
	 * @param component
	 *            Objeto do tipo <code>Component</code> utilizado para cálculos.
	 * @return Objeto com informações de tamanho e posicionamento do próximo
	 *         rótulo a ser adicionado na janela.
	 */
	public Rectangle getNextComponentBounds(Component component) {
		if (component.getClass() == JScrollPane.class) {
			this.componentHeight = 80;
		} else {
			this.componentHeight = component.getSize().height > this.increment ? component.getSize().height : this.increment;
		}
		this.labelY += this.componentHeight - this.increment;
		Rectangle rectangle = new Rectangle(this.componentX, this.componentY, this.componentWidth, this.componentHeight);
		this.componentY += this.componentHeight;
		return rectangle;
	}

	/**
	 * Método que informa o layout utilizado na janela.
	 * 
	 * @return Layout utilizado.
	 */
	public LayoutManager getLayout() {
		return null;
	}

	/**
	 * Método que informa a largura utilizada para os rótulos (labels).
	 * 
	 * @return Largura dos rótulos.
	 */
	public int getLabelWidth() {
		return labelWidth;
	}

}
