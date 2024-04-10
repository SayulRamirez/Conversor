package com.alura.logicaprincipal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CoinTest {

    private Coin coin;

    @BeforeEach
    void setUp() {
        coin = new Coin();
    }

    @Test
    void resolverDollarMexican() {

        double result = coin.resolver("Dólar", "Peso Mexicano", 1);

        assertEquals(16.81, result);

        result = coin.resolver("Dólar", "Dólar", 1);

        assertEquals(1.0, result);
    }

    @Test
    void resolverDollarEuro() {

        double result = coin.resolver("Dólar", "Euros", 1);

        assertEquals(0.91, result);
    }

    @Test
    void resolverDollarLibra() {

        double result = coin.resolver("Dólar", "Libras Esterlinas", 1);

        assertEquals(0.78, result);
    }

    @Test
    void resolverDollarYen() {

        double result = coin.resolver("Dólar", "Yen Japonés", 1);

        assertEquals(139.04, result);
    }

    @Test
    void resolverDollarWon() {

        double result = coin.resolver("Dólar", "Won sur-coreano", 1);

        assertEquals(1277.49, result);
    }


    @Test
    void testNegativeValue() {
        double result = coin.resolver("Dólar", "Euros", -50);
        assertEquals(-45.5, result, 0.01);
    }
}
