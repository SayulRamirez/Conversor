package com.alura.controller;

import com.alura.conexion_api.ConnectionAPI;

public class ConversionController {

    public double applyConversion(double value, String beginning, String destination) {

        return ConnectionAPI.applyConversion(value, beginning, destination);
    }
}
