package com.alura.conversor;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Objects;

import com.alura.controller.ConversionController;
import com.alura.enums.Pais;
import com.alura.logicaprincipal.*;

/**
 * VENTANA PRINCIPAL EN LA QUE SE HARÁ LA CONVERSIÓN DEPENDIENDO DE LA OPCIÓN
 * ELEGIDA POR EL USUARIO.
 * @author sayul
 *
 */
public class Principal extends JFrame {
	private Temperatura temperatura = new Temperatura();
	private Divisas divisas = new Divisas();
	private String opcionEleginda;

	/**
	 * Create the frame.
	 */
	public Principal(String opcion) {
		setBounds(0, 0, 516, 410);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Conversor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/images/iconoDos.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.opcionEleginda = opcion;

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Elecciones para la conversión final.
		JComboBox<String> comboBoxFinal = new JComboBox<>();
		comboBoxFinal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFinal.setBounds(270, 190, 220, 27);
		contentPane.add(comboBoxFinal);

		//cargarCombo(comboBoxFinal, opcionEleginda); // SE CARGAN LOS DATOS DEPENDIENDO EL TIPO DE CONVERSIÓN
		cargarCombo(comboBoxFinal);

		JLabel labelA = new JLabel("a:");
		labelA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelA.setBounds(270, 166, 29, 21);
		contentPane.add(labelA);

		// Elecciones para la conversión inicial.
		JComboBox<String> comboBoxInicio = new JComboBox<>();
		comboBoxInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxInicio.setBounds(10, 190, 220, 27);
		contentPane.add(comboBoxInicio);

		//cargarCombo(comboBoxInicio, opcionEleginda); // Se cargan los datos dependiendo el tipo de conversión.
		cargarCombo(comboBoxInicio);

		// JTextField donde se muestra el resultado.
		JTextField textFieldResultado = new JTextField();
		textFieldResultado.setEditable(false);
		textFieldResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldResultado.setBounds(115, 246, 270, 27);
		contentPane.add(textFieldResultado);
		textFieldResultado.setColumns(10);

		// JTextField donde se ingresa la cantidad a realizar la conversión.
		JTextField textFieldCantidad = new JTextField();
		textFieldCantidad.setBorder(null);
		textFieldCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldCantidad.setBounds(270, 114, 220, 27);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);

		// SE AGREGAN LAS OPCIONES DE CONVERSIÓN DISPONIBLES
		JMenu menuOpciones = new JMenu("Opciones");
		menuBar.add(menuOpciones);
		
		JMenuItem menuCambiar = new JMenuItem("Cambiar tipo de conversión");
		menuCambiar.setIcon(new ImageIcon(Objects.requireNonNull(Principal.class.getResource("/images/conversion.png"))));
		menuOpciones.add(menuCambiar);
		menuCambiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});

		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.setIcon(new ImageIcon(Objects.requireNonNull(Principal.class.getResource("/images/salir.png"))));
		menuOpciones.add(menuSalir);
		menuSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenuItem menuLimpiar = new JMenuItem("Limpiar");
		menuLimpiar.setIcon(new ImageIcon(Objects.requireNonNull(Principal.class.getResource("/images/limpiar.png"))));
		menuBar.add(menuLimpiar);
		menuLimpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldCantidad.setText("");
				textFieldResultado.setText("");
				comboBoxInicio.setSelectedIndex(0);
				comboBoxFinal.setSelectedIndex(0);
			}
		});

		// Dentro de este menú se encuentran los datos de contacto.
		JMenuItem menuAcerca = new JMenuItem("Acerca de");
		menuAcerca.setIcon(new ImageIcon(Objects.requireNonNull(Principal.class.getResource("/images/acerca.png"))));
		menuBar.add(menuAcerca);

		JLabel labelNombre = new JLabel("Desarrollador: Saúl Ramírez");
		JLabel labelContacto = new JLabel("Enlaces de contacto: ");

		// En estos JLabel se agrega el enlace para las páginas de contacto, los cuales te direccionan a la página.
		JLabel labelGitHub = new JLabel("<html><a href=\"https://github.com/SayulRamirez\">GitHub</a></html>");
		labelGitHub.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelGitHub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/SayulRamirez"));
				} catch (IOException | URISyntaxException ex){
					System.out.println("Ocurrio un error al cargar la página.");
				}
			}
		});

		JLabel labelLinkedIn = new JLabel("<html><a href=\"https://www.linkedin.com/in/sayul-ramirez/\">LinkIn</a></html>");
		labelLinkedIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelLinkedIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/sayul-ramirez"));
				} catch (IOException | URISyntaxException ex){
					System.out.println("Ocurrio un error al cargar la página.");
				}
			}
		});

		menuAcerca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel[] labelLinks = {
						labelNombre,
						labelContacto,
						labelGitHub,
						labelLinkedIn
				};
				JOptionPane.showMessageDialog(null, labelLinks);
			}
		});

		JLabel labelEquivalencia = new JLabel("Equivalencia:");
		labelEquivalencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEquivalencia.setBounds(21, 246, 97, 21);

	    JButton botonAplicar = new JButton("Aplicar conversión");
		botonAplicar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAplicar.setBackground(new Color(255, 255, 255));
		botonAplicar.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonAplicar.setBounds(115, 307, 270, 27);
		contentPane.add(botonAplicar);
		botonAplicar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String valorInicial = textFieldCantidad.getText();
				String conversionInicial = Objects.requireNonNull(comboBoxInicio.getSelectedItem()).toString();
				String conversionFinal = Objects.requireNonNull(comboBoxFinal.getSelectedItem()).toString();

				String origen = Pais.getByNombrePais(conversionInicial).toString();
				String destino = Pais.getByNombrePais(conversionFinal).toString();

				if (Principal.isString(valorInicial) || conversionInicial.equals(conversionFinal)) {
					JOptionPane.showMessageDialog(null, "El valor debe ser númerico y debes de seleccionar \n"
							+ "las dos opciones y las opciones deben ser diferentes");

					throw new RuntimeException();
				}

				double valor = Double.parseDouble(valorInicial);

				if("temperaturas".equals(opcion)) {
					temperatura.resolver(textFieldResultado, conversionInicial, conversionFinal, valor);
				/*}  else if ("divisas".equals(opcion)) {
					divisas.resolver(textFieldResultado, conversionInicial, conversionFinal, valor);
					*/

				} else if ("divisas".equals(opcion)) {
					ConversionController cc = new ConversionController();
					double resultado = cc.aplicarConversion(valor, origen, destino);
					textFieldResultado.setText(String.valueOf(resultado));
				}
			}
		});

		JLabel labelCambio = new JLabel("Cambiar de: ");
		labelCambio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCambio.setBounds(10, 166, 97, 21);
		contentPane.add(labelCambio);
		
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
		labelBanner.setIcon(new ImageIcon(Objects.requireNonNull(Principal.class.getResource("/images/fondoTres.png"))));
		labelBanner.setBounds(0, 0, 500, 353);
		contentPane.add(labelBanner);
	}

	/**
	 * EL MÉTODO INTENTA CONVERTIR EL STRING INGRESADO A DOUBLE SI NO ES UN DOUBLE REGRESA TRUE INDICANDO QUE ES UN STRING 
	 * Y SI LOGRA CONVERTIRLO A UN DATO TIPO DOUBLE REGRESA FALSE INDICANDO QUE NO ES STRING
	 * @param str
	 * ES EL ARGUMENTO QUE SE QUIERE SABER SI ES STRING O DOUBLE
	 * @return
	 * RETORNA UN BOOLEAN: TRUE SI ES STRING Y FALSE SI ES DOUBLE
	 */
	public static boolean isString(String str){
		try{
			double d = Double.parseDouble(str);
		} catch(NumberFormatException nfe){
			return true;
		}
		return false;
	}
	  
	/**
	 * CARGA LOS DATOS DE LA CONVERSION DEPENDIENDO DE LA OPCION ELEGIDA POR EL USUARIO
	 * @param combo
	 * SE INGRESA EL COMBOBOX DONDE SERÁN CARGADOS LOS DATOS
	 */
	private void cargarCombo(JComboBox<String> combo, String opcion) {
		if("temperaturas".equals(opcion)) {
			temperatura.anadirDatos(combo, temperatura.getTemperaturas());			
		}  else if ("divisas".equals(opcion)) {
			divisas.anadirDatos(combo, divisas.getDivisas());
		}
	}

	private void cargarCombo(JComboBox<String> c) {
		for (Pais p: Pais.values()) {
			c.addItem(p.getNombrePais());
		}
	}
}















