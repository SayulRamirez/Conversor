package com.alura.logicaprincipal;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * CLASE EN LA CUAL SE IMPLEMENTA LOS MÉTODOS Y LOS ATRIBUTOS PARA LA CONVERSIÓN 
 * DE LAS DIFERENTES DIVISAS DISPONIBLES
 * @author sayul
 *
 */

public class Coin {

	private final Map<String, Double> coins;

	public Coin() {
		coins = new LinkedHashMap<>();
		startCoins();
	}

	private void startCoins() {
		coins.put("Peso Mexicano", 16.81);
		coins.put("Dólar", 1.0);
		coins.put("Euros", 0.91);
		coins.put("Libras Esterlinas", 0.78);
		coins.put("Yen Japonés", 139.04);
		coins.put("Won sur-coreano", 1277.49);
	}

	public double resolver(String beginning, String end, double value) {

		Double coinBeginning = coins.get(beginning);
		Double coinEnd = coins.get(end);

		return Math.round(value / coinBeginning * coinEnd * 100.0) / 100.0;
	}
}
