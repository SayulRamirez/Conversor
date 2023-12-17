package com.alura.inicio;

import com.alura.conversor.Menu;

import java.awt.*;

public class ConversorMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Menu frame = new Menu();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
