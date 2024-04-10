package com.alura.logicaprincipal;

import javax.swing.*;

/**
 * CLASE DÓNDE SE IMPLEMENTAN LOS ATRIBUTOS Y MÉTODOS PARA LA CONVERSIÓN DE LAS TEMPERATURAS
 * @author sayul
 *
 */

public class Temperatura  implements ResolverConversion {

	private double resultado;
	private static final String[] temperaturas = {
			"",
			"Celsius",
			"Kelvin",
			"Fahrenheit",
			"Rankine"
	};

	private void celsiusKelvin(double inicio) {
		resultado = inicio + 273;		
	}
	
	private void celsiusFahrenheit(double inicio) {
		resultado = inicio * 1.8 + 32;		
	}
	
	private void celsiusRankine(double inicio) {
		resultado = (inicio * 1.8 + 32) + 460;		
	}

	private void kelvinCelsius(double inicio) {
		resultado = inicio - 273;
	}
	
	private void kelvinFahrenheit(double inicio) {
		resultado = ((inicio - 273) * 1.8) + 32;		
	}
		
	private void kelvinRankine(double inicio) {
		resultado = (((inicio - 273) * 1.8) + 32) + 460;		
	}
	
	private void fahrenheitCelsius(double inicio) {
		resultado =  (inicio - 32) / 1.8;		
	}
	
	private void fahrenheitKelvin(double inicio) {
		resultado = ((inicio - 32) / 1.8) + 273;		
	}
	
	private void fahrenheitRankine(double inicio) {
		resultado =  inicio + 460;		
	}
	
	private void rankineCelsius(double inicio) {
		resultado = ((inicio - 460) - 32) / 1.8;		
	}
	
	private void rankineKelvin(double inicio) {
		resultado = (((inicio - 460) - 32) / 1.8) + 273;		
	}
	
	private void rankineFahrenheit(double inicio) {
		resultado = inicio - 460;		
	}
	
	private void actualizar(JTextField t, String conversionFinal) {
		t.setText("Equivale a " + this.resultado + " " + conversionFinal); 		
	}
	
	/**
	 * EL MÉTODO RESULEVE LOS TIPOS DE CONVERSIÓN DE TEMPERATURAS LLAMANDO
	 * A LOS MÉTODOS ANTERIORES DEPENDIENDO EL TIPO DE CONVERSION A REALIZAR
	 * @param t 
	 * TEXTFIELD DÓNDE SERÁ MOSTRADO EL RESULTADO
	 * @param conversionInicial
	 * CONVERSIÓN DE ENTRADA
	 * @param conversionFinal
	 * CONVERSIÓN DE SALIDA
	 * @param inicio
	 * VALOR DE LA CONVERSIÓN DE INICIO
	 */

	@Override
	public void resolver(JTextField t, String conversionInicial, String conversionFinal, double inicio) {
		if(conversionInicial.equals("Celsius") && conversionFinal.equals("Kelvin")) {
			celsiusKelvin(inicio);
			actualizar(t, conversionFinal);
			
		} else if (conversionInicial.equals("Celsius") && conversionFinal.equals("Fahrenheit")) {
			celsiusFahrenheit(inicio);
			actualizar(t, conversionFinal);
			
		} else if (conversionInicial.equals("Celsius") && conversionFinal.equals("Rankine")) {
			celsiusRankine(inicio);
			actualizar(t, conversionFinal);
			
		} else if (conversionInicial.equals("Kelvin") && conversionFinal.equals("Celsius")) {
			kelvinCelsius(inicio);
			actualizar(t, conversionFinal);
			
		} else if (conversionInicial.equals("Kelvin") && conversionFinal.equals("Fahrenheit")) {
			kelvinFahrenheit(inicio);
			actualizar(t, conversionFinal);
			
		} else if (conversionInicial.equals("Kelvin") && conversionFinal.equals("Rankine")) {
			kelvinRankine(inicio);
			actualizar(t, conversionFinal);
			
		} else if (conversionInicial.equals("Fahrenheit") && conversionFinal.equals("Celsius")) {
			fahrenheitCelsius(inicio);
			actualizar(t, conversionFinal);
			
		} else if (conversionInicial.equals("Fahrenheit") && conversionFinal.equals("Kelvin")) {
			fahrenheitKelvin(inicio);
			actualizar(t, conversionFinal);
			
		} else if (conversionInicial.equals("Fahrenheit") && conversionFinal.equals("Rankine")) {
			fahrenheitRankine(inicio);
			actualizar(t, conversionFinal);
			
		} else if (conversionInicial.equals("Rankine") && conversionFinal.equals("Celsius")) {
			rankineCelsius(inicio);
			actualizar(t, conversionFinal);
			
		} else if (conversionInicial.equals("Rankine") && conversionFinal.equals("Kelvin")) {
			rankineKelvin(inicio);
			actualizar(t, conversionFinal);
			
		} else if (conversionInicial.equals("Rankine") && conversionFinal.equals("Fahrenheit")) {
			rankineFahrenheit(inicio);
			actualizar(t, conversionFinal);
		}
	}
	
	public static String[] getTemperaturas() {
		return temperaturas;
	}
}
