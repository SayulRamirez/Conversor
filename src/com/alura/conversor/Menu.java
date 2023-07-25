package com.alura.conversor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.alura.logicaprincipal.LogicaMenu;

import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {

	private JPanel PaneMenu;
	private JButton botonComenzar;
	private JComboBox<String> comboBoxSeleccion;
	private LogicaMenu logica = new LogicaMenu();
	public static String opcionElegida = "";

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/com/alura/imagenes/iconoDos.png")));
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
		
		comboBoxSeleccion = new JComboBox<>();
		comboBoxSeleccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxSeleccion.setBounds(10, 158, 271, 27);
		PaneMenu.add(comboBoxSeleccion);
		
		logica.anadirDatos(comboBoxSeleccion);
		
		botonComenzar = new JButton("Comenzar conversion");
		botonComenzar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonComenzar.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonComenzar.setBounds(10, 298, 271, 27);
		PaneMenu.add(botonComenzar);
		botonComenzar.addActionListener(this);
		
		JLabel labelFondoMenu = new JLabel("");
		labelFondoMenu.setIcon(new ImageIcon(Menu.class.getResource("/com/alura/imagenes/fondoTres.png")));
		labelFondoMenu.setBounds(0, 0, 291, 348);
		PaneMenu.add(labelFondoMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == botonComenzar) {
			opcionElegida = comboBoxSeleccion.getSelectedItem().toString().trim();
			
			if(opcionElegida.equals("")) {
				JOptionPane.showMessageDialog(null, "Debes seleccionar una opcion");
			} else {
				Principal principal = new Principal();
				principal.setLocationByPlatform(true);
				principal.setVisible(true);
				principal.setResizable(false);
				principal.setBounds(100, 100, 516, 410);
				this.setVisible(false);
			}
		}
		
	}
	
	public String getOpcionElegida() {
		return opcionElegida;
	}
}
