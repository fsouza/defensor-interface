package br.edu.ifes.defensor.util;

import java.util.Comparator;
import java.util.Vector;

/**
 * Classe utilizada para informar o critério de ordenação em dados. Esta classe
 * está preparada para trabalhar na ordenação de objetos do tipo
 * <code>Vector</code>.
 * 
 * @author Francisco Antônio da Silva Souza
 * @author Ameriana Gomes Santos
 * @version 1.5
 * 
 */
public class RowSorter implements Comparator<Vector> {

	private boolean asc;
	private int index;

	/**
	 * Constrói o objeto <code>RowSorter</code>.
	 * 
	 * @param index
	 *            Indica o índice a ser utilizado como referência para a
	 *            ordenação.
	 * @param asc
	 *            Indica se a ordenação é crescente ou decrescente.
	 */
	public RowSorter(int index, boolean asc) {
		this.index = index;
		this.asc = asc;
	}

	@Override
	public int compare(Vector x, Vector y) {
		Object o1 = x.get(this.index);
		Object o2 = y.get(this.index);

		if (o1 instanceof String && ((String) o1).length() == 0) {
			o1 = null;
		}
		if (o2 instanceof String && ((String) o2).length() == 0) {
			o2 = null;
		}

		double val1;
		double val2;
		try {
			val1 = Double.parseDouble(o1.toString());
			val2 = Double.parseDouble(o2.toString());
			if (this.asc) {
				if (val1 > val2) {
					return 1;
				} else if (val2 > val1) {
					return -1;
				} else {
					return 0;
				}
			} else {
				if (val1 > val2) {
					return -1;
				} else if (val2 > val1) {
					return 1;
				} else {
					return 0;
				}
			}
		} catch (NumberFormatException e) {
			if (o1 == null && o2 == null) {
				return 0;
			} else if (o1 == null) {
				return 1;
			} else if (o2 == null) {
				return -1;
			} else if (o1 instanceof String && o2 instanceof String) {
				if (this.asc) {
					return o1.toString().compareToIgnoreCase(o2.toString());
				} else {
					return o2.toString().compareToIgnoreCase(o1.toString());
				}
			} else if (o1 instanceof Comparable) {
				if (this.asc) {
					return ((Comparable) o1).compareTo(o2);
				} else {
					return ((Comparable) o2).compareTo(o1);
				}
			} else {
				if (this.asc) {
					return o1.toString().compareToIgnoreCase(o2.toString());
				} else {
					return o2.toString().compareToIgnoreCase(o1.toString());
				}
			}
		}
	}

}
