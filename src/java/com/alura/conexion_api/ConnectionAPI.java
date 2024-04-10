package com.alura.conexion_api;

import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConnectionAPI {

    public static double applyConversion(double value, String origin, String destination) {

        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/d88905c2ab894f27f5101d9e/pair/" + origin + "/" + destination);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.connect();

            if (con.getResponseCode() != 200) JOptionPane.showMessageDialog(null, "Ocurrio un error: " + con.getResponseCode());

            StringBuilder information = new StringBuilder();
            Scanner in = new Scanner(url.openStream());

            while (in.hasNext()) information.append(in.nextLine());

            in.close();
            con.disconnect();

            JSONObject jsonObject = new JSONObject(information.toString());
            double conversionRate = jsonObject.getDouble("conversion_rate");

            return Double.parseDouble(String.format("%.3f", value * conversionRate));

        } catch (IOException | JSONException e) {
            JOptionPane.showMessageDialog(null, "Se a perdidó la conexión a internet.");
            throw new RuntimeException(e);
        }
    }
}
