package com.alura.conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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

import com.alura.logicaprincipal.Divisas;
import com.alura.logicaprincipal.TazaConversion;
import com.alura.logicaprincipal.Temperatura;

import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Desktop;

public class Principal extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField textFieldCantidad;
	private JTextField textFieldResultado;
	private JComboBox<String> comboBoxInicio, comboBoxFinal;
	private JButton botonAplicar;
	private JMenuItem menuCambiar, menuSalir, menuLimpiar, menuAcerca;
	private Temperatura temperatura = new Temperatura();
	private Divisas divisas = new Divisas();
	private Menu menu = new Menu();
	private JLabel labelGitHub, labelLinkedIn, labelNombre, labelContacto;
	
	String valorInicial;
	String conversionInicial;
	String conversionFinal;
	Double resultado;
	String opcion;
	double inicio;
	/**
	 * Create the frame.
	 */
	public Principal() {
		setBounds(0, 0, 516, 410);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Conversor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/com/alura/imagenes/iconoDos.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		opcion = menu.opcionElegida;
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu menuOpciones = new JMenu("Opciones");
		menuBar.add(menuOpciones);
		
		menuCambiar = new JMenuItem("Cambiar tipo de conversión");
		menuCambiar.setIcon(new ImageIcon(Principal.class.getResource("/com/alura/imagenes/conversion.png")));
		menuOpciones.add(menuCambiar);
		menuCambiar.addActionListener(this);
		
		menuSalir = new JMenuItem("Salir");
		menuSalir.setIcon(new ImageIcon(Principal.class.getResource("/com/alura/imagenes/salir.png")));
		menuOpciones.add(menuSalir);
		menuSalir.addActionListener(this);
		
		menuLimpiar = new JMenuItem("Limpiar");
		menuLimpiar.setIcon(new ImageIcon(Principal.class.getResource("/com/alura/imagenes/limpiar.png")));
		menuBar.add(menuLimpiar);
		menuLimpiar.addActionListener(this);
		
		menuAcerca = new JMenuItem("Acerca de");
		menuAcerca.setIcon(new ImageIcon(Principal.class.getResource("/com/alura/imagenes/acerca.png")));
		menuBar.add(menuAcerca);
		menuAcerca.addActionListener(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelEquivalencia = new JLabel("Equivalencia:");
		labelEquivalencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEquivalencia.setBounds(21, 246, 97, 21);
		contentPane.add(labelEquivalencia);
		
	    botonAplicar = new JButton("Aplicar conversión");
		botonAplicar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAplicar.setBackground(new Color(255, 255, 255));
		botonAplicar.setFont(new Font("Tahoma", Font.BOLD, 16));
		botonAplicar.setBounds(115, 307, 270, 27);
		contentPane.add(botonAplicar);
		botonAplicar.addActionListener(this);
		
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
		
		cargarCombo(comboBoxFinal);
		
		JLabel labelA = new JLabel("a:");
		labelA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelA.setBounds(270, 166, 29, 21);
		contentPane.add(labelA);
		
		
		comboBoxInicio = new JComboBox<>();
		comboBoxInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxInicio.setBounds(10, 190, 220, 27);
		contentPane.add(comboBoxInicio);
		
		cargarCombo(comboBoxInicio);
		
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
		
		labelGitHub = new JLabel("<html><a href=\"https://github.com/SayulRamirez\">GitHub</a></html>");
		labelGitHub.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelGitHub.addMouseListener(this);
		
		labelLinkedIn = new JLabel("<html><a href=\"https://www.linkedin.com/in/sayul-ramirez/\">LinkIn</a></html>");
		labelLinkedIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		labelLinkedIn.addMouseListener(this);		
		
		labelNombre = new JLabel("Desarrollador: Saúl Ramírez");
		labelContacto = new JLabel("Enlaces de contacto: ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == menuCambiar) {
			Menu menu = new Menu();			
			menu.setVisible(true);
			menu.setResizable(false);
			menu.setBounds(0, 0, 307, 398);
			menu.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		
		if(e.getSource() == menuSalir) {
			System.exit(WIDTH);
		}
		
		if(e.getSource() == menuLimpiar) {
			textFieldCantidad.setText("");
			textFieldResultado.setText("");
			comboBoxInicio.setSelectedIndex(0);
			comboBoxFinal.setSelectedIndex(0);
		}
		
		if(e.getSource() == menuAcerca) {
			JLabel[] labelLinks = {
					labelNombre,
					labelContacto,
					labelGitHub,
					labelLinkedIn
			};
			
			JOptionPane.showMessageDialog(null, labelLinks);
		}
		
		
		if (e.getSource() == botonAplicar) {
			valorInicial = textFieldCantidad.getText();
			conversionInicial = comboBoxInicio.getSelectedItem().toString();
			conversionFinal = comboBoxFinal.getSelectedItem().toString();	
			
			if (Principal.isNumeric(valorInicial) || conversionInicial.equals("") || conversionFinal.equals("") || conversionInicial.equals(conversionFinal)) {
				JOptionPane.showMessageDialog(null, "El valor debe ser númerico y debes de seleccionar \n"
						+ "las dos opciones y las opciones deben ser diferentes");
			} else {
				inicio = Double.parseDouble(valorInicial);
				solucionConversion(opcion);
			}
		}
		
	}
	

	  public static boolean isNumeric(String str){
	      try{
	          double d = Double.parseDouble(str);
	      } catch(NumberFormatException nfe){
	    	  return true;  	  
	      }
	      return false;
	  }
	  
	  private void cargarCombo(JComboBox<String> combo) {
		  if(opcion.equals("Temperaturas")) {
				temperatura.anadirDatos(combo);			
			}  else if ("Divisas".equals(opcion)) {
				divisas.getDivisas(combo);
			}
	  }
	  
	  private void solucionConversion(String opcion) {
		  if("Temperaturas".equals(opcion)) {
			  temperatura.resolver(textFieldResultado, conversionInicial, conversionFinal, inicio);
			}  else if ("Divisas".equals(opcion)) {
				divisas.solucionarDivisas(textFieldResultado, conversionInicial, conversionFinal, inicio);
			}
	  }

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() > 0) {
            try {
            	if(e.getSource() == labelGitHub) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}















