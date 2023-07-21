package com.alura.conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	private JPanel PaneMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/alura/com/imagenes/iconoDos.png")));
		setTitle("Menu de Conversiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 398);
		PaneMenu = new JPanel();
		PaneMenu.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PaneMenu);
		PaneMenu.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Elige el tipo de conversion a realizar");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(10, 35, 271, 26);
		PaneMenu.add(labelTitulo);
		
		JLabel labelDos = new JLabel("Conversiones disponibles: ");
		labelDos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDos.setHorizontalAlignment(SwingConstants.CENTER);
		labelDos.setBounds(10, 124, 170, 26);
		PaneMenu.add(labelDos);
		
		JComboBox comboBoxSeleccion = new JComboBox();
		comboBoxSeleccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxSeleccion.setBounds(10, 158, 271, 27);
		PaneMenu.add(comboBoxSeleccion);
		
		JButton botonComenzar = new JButton("Comenzar conversion");
		botonComenzar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonComenzar.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonComenzar.setBounds(10, 298, 271, 27);
		PaneMenu.add(botonComenzar);
		
		JLabel labelFondoMenu = new JLabel("");
		labelFondoMenu.setIcon(new ImageIcon(Menu.class.getResource("/alura/com/imagenes/fondoTres.png")));
		labelFondoMenu.setBounds(0, 0, 291, 348);
		PaneMenu.add(labelFondoMenu);
	}
}
