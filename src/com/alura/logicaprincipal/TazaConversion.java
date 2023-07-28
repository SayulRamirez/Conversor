package com.alura.logicaprincipal;

public enum TazaConversion  {
	
	DOLAR_PESO(16.81), 
	DOLAR_EURO (0.91),
	DOLAR_ESTERLINA (0.78),
	DOLAR_YEN (139.04),
	DOLAR_WONG (1277.49);

	private final double value;
	
	TazaConversion(double value) {
		this.value = value;
	}
	
	public double getValor() {
		return this.value;
	}
}


