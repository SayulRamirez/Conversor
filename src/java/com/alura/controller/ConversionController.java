package com.alura.controller;

import com.alura.conexion_api.ConexionAPI;

public class ConversionController {

    public double aplicarConversion(double valor, String origen, String destino) {

        return ConexionAPI.aplicarConversion(valor, origen, destino);
    }
}
