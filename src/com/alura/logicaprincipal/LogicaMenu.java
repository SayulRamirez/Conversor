package com.alura.logicaprincipal;

import javax.swing.JComboBox;

public class LogicaMenu {

	private String[] opciones = {"", "Divisas", "Tempreraturas"};
	
	public void anadirDatos(JComboBox<String> combo) {
		  for(int i = 0; i < opciones.length; i++) {
				combo.addItem(opciones[i]);			
			}
	  }
}
