package com.alura.logicaprincipal;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Divisas {
	
	private double resultado;
	
	private String[] divisas = {
			"",
			"Peso Mexicano",
			"Dólar",
			"Euros",
			"Libras Esterlinas",
			"Yen Japonés",
			"Won sur-coreano"
	};

	private static final String DOLAR_PESO = "16.81";
	private static final String DOLAR_DOLAR = "1";
	private static final String DOLAR_EURO = "0.91";
	private static final String DOLAR_ESTERLINA = "0.78";
	private static final String DOLAR_YEN = "139.04";
	private static final String DOLAR_WONG = "1277.49";
	
	private String[] taza = {
			"",
			DOLAR_PESO,
			DOLAR_DOLAR,
			DOLAR_EURO,
			DOLAR_ESTERLINA,
			DOLAR_YEN,
			DOLAR_WONG
	};
	
	public void getDivisas(JComboBox<String> combo) {
		for(String i: divisas) {
			combo.addItem(i);
		}
	}
	
	
	public void solucionarDivisas(JTextField t, String conversionInicial, String conversionFinal, double inicio) {
		
		for(int i = 1; i < divisas.length; i++) {
			for(int j = 1; j < divisas.length; j++) {
				
				if(divisas[i].equals(conversionInicial) && divisas[j].equals(conversionFinal)) {
					resultado = (inicio / Double.parseDouble(taza[i])) * Double.parseDouble(taza[j]);					
				}
			}
		}
		
		t.setText("Equivale a " + this.resultado + " " + conversionFinal); 
	}
}