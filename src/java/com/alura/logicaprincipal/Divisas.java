package com.alura.logicaprincipal;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * CLASE EN LA CUAL SE IMPLEMENTA LOS MÉTODOS Y LOS ATRIBUTOS PARA LA CONVERSIÓN 
 * DE LAS DIFERENTES DIVISAS DISPONIBLES
 * @author sayul
 *
 */

public class Divisas extends Conversion implements ResolverConversion{
	
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
	

	/**
	 * EL MÉTODO RESULEVE LA CONVERSIÓN DESEADA POR EL USUARIO
	 * 
	 * @param t
	 * EL TEXTFIELD DÓNDE SERÁ PUESTO EL RESULTADO DE LA CONVERSIÓN
	 * 
	 * @param conversionInicial
	 * TIPO DE DIVISA DE ENTRADA
	 * @param conversionFinal
	 * TIPO DE DIVISA DE SALIDA
	 * @param inicio
	 * VALOR DE LA DIVISA DE ENTRADA
	 */

	@Override
	public void resolver(JTextField t, String conversionInicial, String conversionFinal, double inicio) {

		for(int i = 1; i < divisas.length; i++) {
			for(int j = 1; j < divisas.length; j++) {
				
				if(divisas[i].equals(conversionInicial) && divisas[j].equals(conversionFinal)) {
					
					resultado = Math.round((inicio / Double.parseDouble(taza[i])) * Double.parseDouble(taza[j])*100.0) / 100.0;
					
				}
			}
		}
		
		t.setText("Equivale a " + this.resultado + " " + conversionFinal); 		
	}
	
	public String[] getDivisas() {
		return this.divisas;
	}
}
