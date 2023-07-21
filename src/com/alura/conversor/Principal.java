package com.alura.conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.Cursor;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCantidad;
	private JTextField textFieldResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setLocationByPlatform(true);
		setTitle("Conversor");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/com/alura/imagenes/iconoDos.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 410);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu menuOpciones = new JMenu("Opciones");
		menuBar.add(menuOpciones);
		
		JMenuItem menuCambiar = new JMenuItem("Cambiar tipo de conversión");
		menuCambiar.setIcon(new ImageIcon(Principal.class.getResource("/com/alura/imagenes/conversion.png")));
		menuOpciones.add(menuCambiar);
		
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.setIcon(new ImageIcon(Principal.class.getResource("/com/alura/imagenes/salir.png")));
		menuOpciones.add(menuSalir);
		
		JMenuItem menuLimpiar = new JMenuItem("Limpiar");
		menuLimpiar.setIcon(new ImageIcon(Principal.class.getResource("/com/alura/imagenes/limpiar.png")));
		menuBar.add(menuLimpiar);
		
		JMenuItem menuAcerca = new JMenuItem("Acerca de");
		menuAcerca.setIcon(new ImageIcon(Principal.class.getResource("/com/alura/imagenes/acerca.png")));
		menuBar.add(menuAcerca);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelEquivalencia = new JLabel("Equivalencia:");
		labelEquivalencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEquivalencia.setBounds(21, 246, 97, 21);
		contentPane.add(labelEquivalencia);
		
		JButton botonAplicar = new JButton("Aplicar conversión");
		botonAplicar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAplicar.setBackground(new Color(255, 255, 255));
		botonAplicar.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonAplicar.setBounds(115, 307, 270, 27);
		contentPane.add(botonAplicar);
		
		textFieldResultado = new JTextField();
		textFieldResultado.setEditable(false);
		textFieldResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldResultado.setBounds(115, 246, 270, 27);
		contentPane.add(textFieldResultado);
		textFieldResultado.setColumns(10);
		
		JComboBox comboBoxFinal = new JComboBox();
		comboBoxFinal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFinal.setBounds(270, 190, 220, 27);
		contentPane.add(comboBoxFinal);
		
		JLabel labelA = new JLabel("a:");
		labelA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelA.setBounds(270, 166, 29, 21);
		contentPane.add(labelA);
		
		JComboBox comboBoxInicio = new JComboBox();
		comboBoxInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxInicio.setBounds(10, 190, 220, 27);
		contentPane.add(comboBoxInicio);
		
		JLabel labelCambio = new JLabel("Cambiar de: ");
		labelCambio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCambio.setBounds(10, 166, 97, 21);
		contentPane.add(labelCambio);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBorder(null);
		textFieldCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCantidad.setBounds(270, 114, 220, 27);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel labelMonto = new JLabel("Ingresa la cantidad para convertir:");
		labelMonto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMonto.setBounds(10, 114, 245, 21);
		contentPane.add(labelMonto);
		
		JLabel labelTitulo = new JLabel("ELIGE LA CONVERSIÓN A REALIZAR");
		labelTitulo.setBackground(new Color(0, 0, 0));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelTitulo.setForeground(new Color(106, 0, 0));
		labelTitulo.setBounds(30, 31, 446, 37);
		contentPane.add(labelTitulo);
		
		JLabel labelBanner = new JLabel("");
		labelBanner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelBanner.setForeground(new Color(0, 0, 0));
		labelBanner.setBackground(new Color(0, 0, 0));
		labelBanner.setBorder(null);
		labelBanner.setIcon(new ImageIcon(Principal.class.getResource("/com/alura/imagenes/fondoTres.png")));
		labelBanner.setBounds(0, 0, 500, 353);
		contentPane.add(labelBanner);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
