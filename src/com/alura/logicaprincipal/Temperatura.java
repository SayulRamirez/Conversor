package com.alura.logicaprincipal;

import javax.swing.*;

public class Temperatura {

	private double resultado;
	private String[] temperaturas = {
			"",
			"Celsius",
			"Kelvin",
			"Fahrenheit",
			"Rankine"
	};
	
	public void anadirDatos(JComboBox<String> combo) {
		for(int i = 0; i < temperaturas.length; i++) {
			combo.addItem(temperaturas[i]);			
			}
	}
	
	public void celsiusKelvin(double inicio) {
		resultado = inicio + 273;		
	}
	
	public void celsiusFahrenheit(double inicio) {
		resultado = inicio * 1.8 + 32;		
	}
	
	public void celsiusRankine(double inicio) {
		resultado = (inicio * 1.8 + 32) + 460;		
	}

	public void kelvinCelsius(double inicio) {
		resultado = inicio - 273;
	}
	
	public void kelvinFahrenheit(double inicio) {
		resultado = ((inicio - 273) * 1.8) + 32;		
	}
		
	public void kelvinRankine(double inicio) {
		resultado = (((inicio - 273) * 1.8) + 32) + 460;		
	}
	
	public void fahrenheitCelsius(double inicio) {
		resultado =  (inicio - 32) / 1.8;		
	}
	
	public void fahrenheitKelvin(double inicio) {
		resultado = ((inicio - 32) / 1.8) + 273;		
	}
	
	public void fahrenheitRankine(double inicio) {
		resultado =  inicio + 460;		
	}
	
	public void rankineCelsius(double inicio) {
		resultado = ((inicio - 460) - 32) / 1.8;		
	}
	
	public void rankineKelvin(double inicio) {
		resultado = (((inicio - 460) - 32) / 1.8) + 273;		
	}
	
	public void rankineFahrenheit(double inicio) {
		resultado = inicio - 460;		
	}
	
	public void actualizar(JTextField t, String conversionFinal) {
		t.setText("Equivale a " + this.resultado + " " + conversionFinal); 		
	}
	
	public void resolverTemperatura(JTextField t,String conversionInicial, String conversionFinal, double inicio) {
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
	
	
	
	
	
	
	
	
	

}
