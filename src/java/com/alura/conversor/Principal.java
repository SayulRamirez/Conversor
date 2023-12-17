package com.alura.conversor;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import com.alura.logicaprincipal.*;

/**
 * VENTANA PRINCIPAL EN LA QUE SE HARÁ LA CONVERSIÓN DEPENDIENDO DE LA OPCIÓN
 * ELEGIDA POR EL USUARIO.
 * @author sayul
 *
 */
public class Principal extends JFrame implements MouseListener {
	private JTextField textFieldCantidad, textFieldResultado;
	private JComboBox<String> comboBoxInicio, comboBoxFinal;
	private JButton botonAplicar;
	private JMenuItem menuCambiar, menuSalir, menuLimpiar, menuAcerca;
	private Temperatura temperatura = new Temperatura();
	private Divisas divisas = new Divisas();
	private Menu menu = new Menu();
	private JLabel labelGitHub, labelLinkedIn, labelNombre, labelContacto;
	private String valorInicial, conversionInicial, conversionFinal, opcion;
	private double inicio;

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

		String opcionEleginda = opcion;

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu menuOpciones = new JMenu("Opciones");
		menuBar.add(menuOpciones); // SE AGREGAN LAS OPCIONES DE CONVERSIÓN DISPONIBLES
		
		JMenuItem menuCambiar = new JMenuItem("Cambiar tipo de conversión");
		menuCambiar.setIcon(new ImageIcon(Principal.class.getResource("/images/conversion.png")));
		menuOpciones.add(menuCambiar);
		menuCambiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		//menuCambiar.addActionListener(this);
		
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.setIcon(new ImageIcon(Principal.class.getResource("/images/salir.png")));
		menuOpciones.add(menuSalir);
		menuSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//menuSalir.addActionListener(this);
		
		JMenuItem menuLimpiar = new JMenuItem("Limpiar");
		menuLimpiar.setIcon(new ImageIcon(Principal.class.getResource("/images/limpiar.png")));
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
		//menuLimpiar.addActionListener(this);
		
		JMenuItem menuAcerca = new JMenuItem("Acerca de");
		menuAcerca.setIcon(new ImageIcon(Principal.class.getResource("/images/acerca.png")));
		menuBar.add(menuAcerca);
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
		//menuAcerca.addActionListener(this);
		
		JLabel labelEquivalencia = new JLabel("Equivalencia:");
		labelEquivalencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEquivalencia.setBounds(21, 246, 97, 21);
		//contentPane.add(labelEquivalencia);
		
	    JButton botonAplicar = new JButton("Aplicar conversión");
		botonAplicar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAplicar.setBackground(new Color(255, 255, 255));
		botonAplicar.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonAplicar.setBounds(115, 307, 270, 27);
		contentPane.add(botonAplicar);
		botonAplicar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				valorInicial = textFieldCantidad.getText();
				conversionInicial = comboBoxInicio.getSelectedItem().toString();
				conversionFinal = comboBoxFinal.getSelectedItem().toString();

				if (Principal.isString(valorInicial) || conversionInicial.equals("") || conversionFinal.equals("") || conversionInicial.equals(conversionFinal)) {

					JOptionPane.showMessageDialog(null, "El valor debe ser númerico y debes de seleccionar \n"
							+ "las dos opciones y las opciones deben ser diferentes");

				} else {

					inicio = Double.parseDouble(valorInicial);
					solucionConversion(opcion);
				}
			}
		});
		//botonAplicar.addActionListener(this);
		
		textFieldResultado = new JTextField();
		textFieldResultado.setEditable(false);
		textFieldResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldResultado.setBounds(115, 246, 270, 27);
		contentPane.add(textFieldResultado);
		textFieldResultado.setColumns(10);
		
		comboBoxFinal = new JComboBox<>();
		comboBoxFinal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxFinal.setBounds(270, 190, 220, 27);
		contentPane.add(comboBoxFinal);
		
		cargarCombo(comboBoxFinal, opcionEleginda); // SE CARGAN LOS DATOS DEPENDIENDO EL TIPO DE CONVERSIÓN
		
		JLabel labelA = new JLabel("a:");
		labelA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelA.setBounds(270, 166, 29, 21);
		contentPane.add(labelA);
		
		
		comboBoxInicio = new JComboBox<>();
		comboBoxInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxInicio.setBounds(10, 190, 220, 27);
		contentPane.add(comboBoxInicio);
		
		cargarCombo(comboBoxInicio, opcionEleginda); // SE CARGAN LOS DATOS DEPENDIENDO EL TIPO DE CONVERSIÓN
		
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
		labelBanner.setIcon(new ImageIcon(Principal.class.getResource("/images/fondoTres.png")));
		labelBanner.setBounds(0, 0, 500, 353);
		contentPane.add(labelBanner);
		
		/**
		 * EN ESTOS LABELS SE AGREGA EL ENLACE PARA LAS PÁGINAS DE CONTACTO
		 * LOS CUALES TE DIRECCIONAN A CADA PÁGINA
		 */
		JLabel labelGitHub = new JLabel("<html><a href=\"https://github.com/SayulRamirez\">GitHub</a></html>");
		labelGitHub.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//labelGitHub.addMouseListener(this);
		
		JLabel labelLinkedIn = new JLabel("<html><a href=\"https://www.linkedin.com/in/sayul-ramirez/\">LinkIn</a></html>");
		labelLinkedIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//labelLinkedIn.addMouseListener(this);
		
		JLabel labelNombre = new JLabel("Desarrollador: Saúl Ramírez");
		labelContacto = new JLabel("Enlaces de contacto: ");
	}

	/*
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// SI SE SELECCIONA EL MENU CAMBIAR SE CIERRA LA VENTANA Y SE HABRE LA DEL MENU PARA ELEGIR OTRA
		if(e.getSource() == menuCambiar) {
			Menu menu = new Menu();			
			menu.setVisible(true);
			menu.setResizable(false);
			menu.setBounds(0, 0, 307, 398);
			menu.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		
		// CIERRA EL PROGRAMA PRESIONANDO EL MENU SALIR
		if(e.getSource() == menuSalir) {
			System.exit(WIDTH);
		}
		
		// RESTABLECE LOS TFIELDS Y LOS COMOBOBOX
		if(e.getSource() == menuLimpiar) {
			textFieldCantidad.setText("");
			textFieldResultado.setText("");
			comboBoxInicio.setSelectedIndex(0);
			comboBoxFinal.setSelectedIndex(0);
		}
		
		// LANZA UN JOPTIONPANE CON LOS DATOS DE CONTACTO 
		if(e.getSource() == menuAcerca) {
			JLabel[] labelLinks = {
					labelNombre,
					labelContacto,
					labelGitHub,
					labelLinkedIn
			};
			
			JOptionPane.showMessageDialog(null, labelLinks);
		}
		
		
		**
		 * HACE LA CONVERSION DE LAS UNIDADES, PRIMERO RECUPERANDO LOS VALORES DE TEXTFIELD Y DE LOS COMBOBOX,
		 * POSTERIOR CORROBORA QUE SE HAYAN INGRESADO LOS DATOS CORRECTAMENTE SI HAY ALGUNO ERRONEO LANZA UN MENSAJE DE ERROR
		 * Y SI NO PROCEDE A LA CONVERSIÓN

		if (e.getSource() == botonAplicar) {
			
			valorInicial = textFieldCantidad.getText();
			conversionInicial = comboBoxInicio.getSelectedItem().toString();
			conversionFinal = comboBoxFinal.getSelectedItem().toString();	
			
			if (Principal.isString(valorInicial) || conversionInicial.equals("") || conversionFinal.equals("") || conversionInicial.equals(conversionFinal)) {
			
				JOptionPane.showMessageDialog(null, "El valor debe ser númerico y debes de seleccionar \n"
						+ "las dos opciones y las opciones deben ser diferentes");
				
			} else {
				
				inicio = Double.parseDouble(valorInicial);
				solucionConversion(opcion);
			}
		}
		/
	}*/

	

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
	
	/**
	 * EL MÉTODO MANDA A LLAMAR A LOS MÉTODOS DE RESOLUCION DE LA CONVERSION DEPENDIENDO LA OPCION QUE ELIGIO 
	 * EL USUARIO
	 * @param opcion
	 * SE INGRESA LA OPCION ELEGIDA POR EL USUARIO
	 */
	private void solucionConversion(String opcion) {
		if("Temperaturas".equals(opcion)) {
			temperatura.resolver(textFieldResultado, conversionInicial, conversionFinal, inicio);
		}  else if ("Divisas".equals(opcion)) {
			divisas.resolver(textFieldResultado, conversionInicial, conversionFinal, inicio);
		}
	}

	/**
	 * MÉTODO PARA CARGAR LAS URL DE LOS ENLACES DE CONTACTO
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() > 0) { // AL DAR CLICK SE HABER LA PAGINA QUE CONTINE, SI SE DAN TRES CLICK HABRE LA PÁGINA TRES VECES
            try {
            	if(e.getSource() == labelGitHub) {
            		// HABRE EL NAVEGADOR DEL SISTEMA CON LA URL ASIGNADA
            		Desktop.getDesktop().browse(new URI("https://github.com/SayulRamirez"));
            	}
            	
            	if(e.getSource() == labelLinkedIn) {
            		Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/sayul-ramirez"));            		
            	}
            	
            } catch (IOException | URISyntaxException ex) { 
                ex.printStackTrace();
            }
        }	
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}















