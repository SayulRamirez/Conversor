package com.alura.logicaprincipal;

public class LogicaMenu {

	private String[] opciones = {"", "Divisas", "Tempreraturas"};
	
	public String getOpciones(int i) {
		 return opciones[i];
	}
	
	public int getLongitud() {
		return this.opciones.length;
	}
}
