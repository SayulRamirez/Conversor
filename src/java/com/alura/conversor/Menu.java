package com.alura.conversor;

import javax.swing.*;

import com.alura.enums.Opciones;
import com.alura.validaciones.Valid;

import java.awt.*;
import java.util.Objects;

/**
 * EN ESTA CLASE SE IMPLEMENTA EL MÉTODO MAIN PARA EL ARRANQUE DE LA APLICACIÓN EN LA QUE SE MOSTRARA
 * EL MENU DE LOS TIPOS DE CONVERSION DISPONIBLE PARA REALIZAR.
 *
 * @author sayul
 */
public class Menu extends JFrame {

    /**
     * Create the frame.
     */
    public Menu() {
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/images/iconoDos.png")));
        setTitle("Menu de Conversiones");
        setBounds(0, 0, 307, 398);
        setLocationRelativeTo(null);
        setLayout(null);

        addLabel("Elige el tipo de conversion a realizar", Font.BOLD, 35, 271, 26);

        addLabel("Conversiones disponibles:", Font.PLAIN, 124, 170, 27);

        JComboBox<String> comboSelection = new JComboBox<>();
        comboSelection.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboSelection.setBounds(10, 158, 271, 27);
        addOptions(comboSelection);
        add(comboSelection);

        JButton btnStart = new JButton("Comenzar conversion");
        btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnStart.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnStart.setBounds(10, 298, 271, 27);
        add(btnStart);
		btnStart.addActionListener(e -> {
            String selection = Objects.requireNonNull(comboSelection.getSelectedItem()).toString();

            Principal principal = new Principal(selection, Valid.connection());
            principal.setVisible(true);
            dispose();
        });

        JLabel lblBottom = new JLabel();
        lblBottom.setIcon(new ImageIcon(Objects.requireNonNull(Menu.class.getResource("/images/fondoTres.png"))));
        lblBottom.setBounds(0, 0, 291, 348);
        add(lblBottom);
    }

    private void addOptions(JComboBox<String> comboBox) {
        for (Opciones options : Opciones.values()) comboBox.addItem(options.toString().toLowerCase());
    }

    private void addLabel(String content, int style, int y, int width, int height) {

        JLabel labelTitulo = new JLabel(content);
        labelTitulo.setFont(new Font("Tahoma", style, 14));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(10, y, width, height);
        this.add(labelTitulo);
    }
}
