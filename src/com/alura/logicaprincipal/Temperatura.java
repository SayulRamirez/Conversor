package com.alura.logicaprincipal;

import java.util.ArrayList;
import java.util.List;

public class Temperatura {

	private String[] temperaturas = {
			"",
			"Celsius",
			"Kelvin",
			"Fahrenheit",
			"Rankine"
	};
	
	public String getOpciones(int i) {
		 return temperaturas[i];
	}
	
	public int getLongitud() {
		return this.temperaturas.length;
	}
}
