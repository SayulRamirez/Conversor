package com.alura.conexion_api;

import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConexionAPI {
    public static double aplicarConversion(double valor, String origen, String destino) {

        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/d88905c2ab894f27f5101d9e/pair/" + origen + "/" + destino);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.connect();

            int respuesta = con.getResponseCode();

            if (respuesta != 200) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error: " + respuesta);
            }

            StringBuilder informacion = new StringBuilder();
            Scanner in = new Scanner(url.openStream());

            while (in.hasNext()) {
                informacion.append(in.nextLine());
            }

            in.close();
            con.disconnect();
            System.out.println(informacion);

            JSONObject jsonObject = new JSONObject(informacion.toString());
            double tazaConversion = jsonObject.getDouble("conversion_rate");

            return Double.parseDouble(String.format("%.3f", valor * tazaConversion));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
