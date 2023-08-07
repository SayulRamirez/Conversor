package com.alura.logicaprincipal;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * EN ESTA CLASE SOLO SE AÑADEN LOS DIFERENTES TIPOS DE CONVERSIONES
 * DISPONIBLES.
 * @author sayul
 *
 */

public class Conversion {

	private String[] opciones = {"", "Divisas", "Temperaturas"};
	
	/**
	 * ESTE MÉTODO CARGA LOS DATOS DEL ARRAY EL EL COMOBO DESEADO
	 * EN ESTE CASO EN EL MENU
	 * 
	 * @param combo 
	 * COMBOOX DÓNDE SERÁN AGREGADOS LOS ITEMS DEL MISMO
	 */
	public void anadirDatos(JComboBox<String> combo, String[] array) {
		for(String i: array) {
			combo.addItem(i);
		}
	}
	
	public String[] getArray() {
		return this.opciones;
	}
}
