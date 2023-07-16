package alura.com.conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

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
		setTitle("Menu de Conversiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 398);
		PaneMenu = new JPanel();
		PaneMenu.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PaneMenu);
		PaneMenu.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Elige el tipo de conversion a realizar");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(10, 35, 271, 26);
		PaneMenu.add(labelTitulo);
		
		JLabel labelDos = new JLabel("Conversiones disponibles: ");
		labelDos.setHorizontalAlignment(SwingConstants.CENTER);
		labelDos.setBounds(10, 124, 134, 26);
		PaneMenu.add(labelDos);
		
		JComboBox comboBoxSeleccion = new JComboBox();
		comboBoxSeleccion.setBounds(10, 158, 271, 22);
		PaneMenu.add(comboBoxSeleccion);
		
		JButton botonComenzar = new JButton("Comenzar conversion");
		botonComenzar.setBounds(10, 298, 271, 23);
		PaneMenu.add(botonComenzar);
	}
}
