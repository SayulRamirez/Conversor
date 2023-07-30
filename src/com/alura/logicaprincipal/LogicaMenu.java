package com.alura.logicaprincipal;

import javax.swing.JComboBox;

public class LogicaMenu {

	private String[] opciones = {"", "Divisas", "Temperaturas"};
	
	public void anadirDatos(JComboBox<String> combo) {
		for(String i: opciones) {
			combo.addItem(i);
		}
	  }
}
