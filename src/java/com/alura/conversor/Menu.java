package com.alura.conversor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.alura.enums.Opciones;

import java.awt.*;
import java.awt.event.*;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 307, 398);
        setLocationRelativeTo(null);

		JPanel paneMenu = new JPanel();
        paneMenu.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(paneMenu);
        paneMenu.setLayout(null);

        JLabel labelTitulo = new JLabel("Elige el tipo de conversion a realizar");
        labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(10, 35, 271, 26);
        paneMenu.add(labelTitulo);

        JLabel labelDos = new JLabel("Conversiones disponibles: ");
        labelDos.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelDos.setHorizontalAlignment(SwingConstants.CENTER);
        labelDos.setBounds(10, 124, 170, 26);
        paneMenu.add(labelDos);

        JComboBox<String> comboBoxSeleccion = new JComboBox<>();
        comboBoxSeleccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBoxSeleccion.setBounds(10, 158, 271, 27);
        paneMenu.add(comboBoxSeleccion);
        opciones(comboBoxSeleccion);

        JButton botonComenzar = new JButton("Comenzar conversion");
        botonComenzar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botonComenzar.setFont(new Font("Tahoma", Font.BOLD, 16));
        botonComenzar.setBounds(10, 298, 271, 27);
        paneMenu.add(botonComenzar);
		botonComenzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                String seleccion = Objects.requireNonNull(comboBoxSeleccion.getSelectedItem()).toString();

                Principal ventanaPrincipal = new Principal(seleccion);
                ventanaPrincipal.setVisible(true);
                dispose();
            }
		});

        JLabel labelFondoMenu = new JLabel("");
        labelFondoMenu.setIcon(new ImageIcon(Objects.requireNonNull(Menu.class.getResource("/images/fondoTres.png"))));
        labelFondoMenu.setBounds(0, 0, 291, 348);
        paneMenu.add(labelFondoMenu);
    }

    private void opciones(JComboBox<String> c) {
        for (Opciones o : Opciones.values()) {
            c.addItem(o.toString().toLowerCase());
        }
    }
}
