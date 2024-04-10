package com.alura.logicaprincipal;

/**
 * CLASE DÓNDE SE IMPLEMENTAN LOS ATRIBUTOS Y MÉTODOS PARA LA CONVERSIÓN DE LAS TEMPERATURAS
 * @author sayul
 *
 */

public class Temperature {

	private double celsiusKelvin(double inicio) {
		return inicio + 273;
	}
	
	private double celsiusFahrenheit(double inicio) {
		return (inicio * 1.8) + 32;
	}
	
	private double celsiusRankine(double inicio) {
		return celsiusFahrenheit(inicio) + 460;
	}

	private double kelvinCelsius(double inicio) {
		return inicio - 273;
	}
	
	private double kelvinFahrenheit(double inicio) {
		return (kelvinCelsius(inicio) * 1.8) + 32;
	}
		
	private double kelvinRankine(double inicio) {
		return kelvinFahrenheit(inicio) + 460;
	}
	
	private double fahrenheitCelsius(double inicio) {
		return (inicio - 32) / 1.8;
	}
	
	private double fahrenheitKelvin(double inicio) {
		return fahrenheitCelsius(inicio) + 273;
	}
	
	private double fahrenheitRankine(double inicio) {
		return inicio + 460;
	}

	private double rankineFahrenheit(double inicio) {return inicio - 460;}

	private double rankineCelsius(double inicio) {
		return (rankineFahrenheit(inicio) - 32) / 1.8;
	}

	private double rankineKelvin(double inicio) {
		return rankineCelsius(inicio) + 273;
	}

	public double resolve(String beginning, String end, double value) {

		double result;

		if(beginning.equals("Celsius") && end.equals("Kelvin")) {

			result = celsiusKelvin(value);
			
		} else if (beginning.equals("Celsius") && end.equals("Fahrenheit")) {

			result = celsiusFahrenheit(value);
			
		} else if (beginning.equals("Celsius") && end.equals("Rankine")) {

			result = celsiusRankine(value);
			
		} else if (beginning.equals("Kelvin") && end.equals("Celsius")) {

			result = kelvinCelsius(value);
			
		} else if (beginning.equals("Kelvin") && end.equals("Fahrenheit")) {

			result = kelvinFahrenheit(value);
			
		} else if (beginning.equals("Kelvin") && end.equals("Rankine")) {

			result = kelvinRankine(value);
			
		} else if (beginning.equals("Fahrenheit") && end.equals("Celsius")) {

			result = fahrenheitCelsius(value);
			
		} else if (beginning.equals("Fahrenheit") && end.equals("Kelvin")) {

			result = fahrenheitKelvin(value);
			
		} else if (beginning.equals("Fahrenheit") && end.equals("Rankine")) {

			result = fahrenheitRankine(value);
			
		} else if (beginning.equals("Rankine") && end.equals("Celsius")) {

			result = rankineCelsius(value);
			
		} else if (beginning.equals("Rankine") && end.equals("Kelvin")) {

			result = rankineKelvin(value);
			
		} else {

			result = rankineFahrenheit(value);
		}

		return (double) Math.round(result * 100) / 100;
	}
}
