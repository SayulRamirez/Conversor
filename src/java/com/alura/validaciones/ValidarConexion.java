package com.alura.validaciones;

import java.io.IOException;
import java.net.InetAddress;

public class ValidarConexion {

    public static boolean tieneConexion() {
        boolean conexion = false;

        try {
            InetAddress direccion = InetAddress.getByName("www.google.com");
            conexion = direccion.isReachable(5000);
        } catch (IOException e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }

        return conexion;
    }
}
