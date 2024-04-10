package com.alura.logicaprincipal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    private Temperature temperature;

    @BeforeEach
    void setUp() {
        temperature = new Temperature();
    }

    @Test
    void resolve_celsius_kelvin() {
        double result = temperature.resolve("Celsius", "Kelvin", 2);

        assertEquals(275.15 , result, 0.5);
    }

    @Test
    void resolve_celsius_fahrenheit() {
        double result = temperature.resolve("Celsius", "Fahrenheit", 2);

        assertEquals(35.6, result, 0.5);
    }

    @Test
    void resolve_celsius_rankine() {
        double result = temperature.resolve("Celsius", "Rankine", 2);

        assertEquals(495.27 , result, 0.5);
    }

    @Test
    void resolve_kelvin_celsius() {
        double result = temperature.resolve("Kelvin", "Celsius", 2);

        assertEquals(-271.15, result, 0.5);
    }

    @Test
    void resolve_kelvin_fahrenheit() {
        double result = temperature.resolve("Kelvin", "Fahrenheit", 2);

        assertEquals(-456.07, result, 0.5);
    }

    @Test
    void resolve_kelvin_rankine() {
        double result = temperature.resolve("Kelvin", "Rankine", 2);

        assertEquals(3.6 , result, 0.7);
    }

    @Test
    void resolve_fahrenheit_celsius() {
        double result = temperature.resolve("Fahrenheit", "Celsius", 2);

        assertEquals(-16.67 , result, 0.5);
    }

    @Test
    void resolve_fahrenheit_kelvin() {
        double result = temperature.resolve("Fahrenheit", "Kelvin", 2);

        assertEquals(256.48, result, 0.5);
    }

    @Test
    void resolve_fahrenheit_rankine() {
        double result = temperature.resolve("Fahrenheit", "Rankine", 2);

        assertEquals(461.67, result, 0.5);
    }

    @Test
    void resolve_rankine_celsius() {
        double result = temperature.resolve("Rankine", "Celsius", 2);

        assertEquals(-272.04, result, 0.5);
    }

    @Test
    void resolve_rankine_kelvin() {
        double result = temperature.resolve("Rankine", "Kelvin", 2);

        assertEquals(1.11 , result, 0.5);
    }

    @Test
    void resolve_rankine_fahrenheit() {
        double result = temperature.resolve("Rankine", "Fahrenheit", 2);

        assertEquals(-458.05, result, 0.5);
    }
}