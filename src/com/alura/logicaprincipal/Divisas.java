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
	
	public void getDivisas(JComboBox<String> combo) {
		for(String i: divisas) {
			combo.addItem(i);
		}
	}
	
	
	public void solucionar(JTextField t, String conversionInicial, String conversionFinal, double inicio) {
		
		if("Peso Mexicano".equals(conversionInicial)) {
			if("Dólar".equals(conversionFinal)) {
				resultado = TazaConversion.DOLAR_PESO.getValor() * inicio;				
			} else if("Euros".equals(conversionFinal)) {
				resultado = TazaConversion.DOLAR_EURO.getValor() * inicio;				
			} else if("Libras Esterlinas".equals(conversionFinal)) {
				resultado = TazaConversion.DOLAR_ESTERLINA.getValor() * inicio;				
			} else if ("Yen Japonés".equals(conversionFinal)) {
				resultado = TazaConversion.DOLAR_YEN.getValor() * inicio;				
			}else if("Won sur-coreano".equals(conversionFinal)) {				
				resultado = TazaConversion.DOLAR_WONG.getValor() * inicio;
			}
		}
//		"Dólar",
//		"Euros",
//		"Libras Esterlinas",
//		"Yen Japonés",
//		"Won sur-coreano"
	}
}
