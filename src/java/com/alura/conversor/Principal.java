package com.alura.conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Objects;

import com.alura.controller.ConversionController;
import com.alura.enums.Country;
import com.alura.logicaprincipal.*;
import com.alura.validaciones.Valid;

/**
 * VENTANA PRINCIPAL EN LA QUE SE HARÁ LA CONVERSIÓN DEPENDIENDO DE LA OPCIÓN
 * ELEGIDA POR EL USUARIO.
 * @author sayul
 *
 */
public class Principal extends JFrame {

	public Principal(String option, boolean connection) {
		setBounds(0, 0, 516, 410);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Conversor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/images/iconoDos.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (!connection) JOptionPane.showMessageDialog(null, "Conversión sin conexión a internet.");

		JLabel lblTitle = new JLabel("ELIGE LA CONVERSIÓN A REALIZAR");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblTitle.setForeground(new Color(106, 0, 0));
		lblTitle.setBounds(30, 31, 446, 37);
		add(lblTitle);

		addLabel("Ingresar la cantidad para convertir", 10, 114, 245);

		JTextField txtInput = new JTextField();
		txtInput.setBorder(null);
		txtInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtInput.setBounds(270, 114, 220, 27);
		add(txtInput);
		txtInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();

				if (!Character.isDigit(keyChar)) e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		addLabel("Cambiar de:", 10, 166, 97);

		JComboBox<String> comboStart = new JComboBox<>();
		comboStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboStart.setBounds(10, 190, 220, 27);
		add(comboStart);

		addLabel("a:", 270, 166, 29);

		JComboBox<String> comboFinal = new JComboBox<>();
		comboFinal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboFinal.setBounds(270, 190, 220, 27);
		add(comboFinal);

		if("temperaturas".equals(option)) {
			loadOptionsTemperature(comboStart,comboFinal);
		} else {
			loadComboCoins(comboStart, comboFinal, connection);
		}

		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);

		JMenu menuOptions = new JMenu("Opciones");
		menuBar.add(menuOptions);
		
		JMenuItem menuChange = new JMenuItem("Cambiar tipo de conversión");
		menuChange.setIcon(new ImageIcon(Objects.requireNonNull(Principal.class.getResource("/images/conversion.png"))));
		menuOptions.add(menuChange);
		menuChange.addActionListener(e-> {
            Menu menu = new Menu();
            menu.setVisible(true);
            dispose();
		});

		JMenuItem menuExit = new JMenuItem("Salir");
		menuExit.setIcon(new ImageIcon(Objects.requireNonNull(Principal.class.getResource("/images/salir.png"))));
		menuOptions.add(menuExit);
		menuExit.addActionListener(e -> System.exit(0));

		JMenuItem menuClear = new JMenuItem("Limpiar");
		menuClear.setIcon(new ImageIcon(Objects.requireNonNull(Principal.class.getResource("/images/limpiar.png"))));
		menuBar.add(menuClear);

		JMenuItem menuAbout = new JMenuItem("Acerca de");
		menuAbout.setIcon(new ImageIcon(Objects.requireNonNull(Principal.class.getResource("/images/acerca.png"))));
		menuBar.add(menuAbout);

		JLabel lblName = new JLabel("Desarrollador: Saúl Ramírez");
		JLabel lblContact = new JLabel("Enlaces de contacto: ");

		JLabel lblGitHub = addLabelLink("<html><a href=\"https://github.com/SayulRamirez\">GitHub</a></html>", "https://github.com/SayulRamirez");

		JLabel lblLinkedIn = addLabelLink("<html><a href=\"https://www.linkedin.com/in/sayul-ramirez/\">LinkIn</a></html>", "https://www.linkedin.com/in/sayul-ramirez");

		menuAbout.addActionListener(e -> {
            JLabel[] labelLinks = {
                    lblName,
                    lblContact,
                    lblGitHub,
                    lblLinkedIn
            };
            JOptionPane.showMessageDialog(null, labelLinks);
        });

		addLabel("Equivalencia:", 51, 246, 97);

		JTextField txtResult = new JTextField();
		txtResult.setEditable(false);
		txtResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtResult.setBounds(155, 246, 270, 27);
		add(txtResult);

		menuClear.addActionListener(e -> {
			txtInput.setText("");
			txtResult.setText("");
			comboStart.setSelectedIndex(0);
			comboFinal.setSelectedIndex(0);
		});

	    JButton btnConvert = new JButton("Aplicar conversión");
		btnConvert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConvert.setBackground(new Color(255, 255, 255));
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConvert.setBounds(115, 307, 270, 27);
		add(btnConvert);

		btnConvert.addActionListener(e -> {
            String valueInput = txtInput.getText();
            String beginning = Objects.requireNonNull(comboStart.getSelectedItem()).toString();
            String end = Objects.requireNonNull(comboFinal.getSelectedItem()).toString();

            if (Valid.isString(valueInput) || beginning.equals(end)) {
                JOptionPane.showMessageDialog(null, "El valor debe ser númerico y debes de seleccionar las dos opciones y las opciones deben ser diferentes");
                throw new RuntimeException();
            }

            double value = Double.parseDouble(valueInput);

            if("temperaturas".equals(option)) {
				Temperature temperature = new Temperature();
				double result = temperature.resolve(beginning, end, value);

				txtResult.setText("Equivale a " + result + " " + end);

            } else {

				if (connection) {
					String origin = Country.getByNombrePais(beginning).toString();
					String destination = Country.getByNombrePais(end).toString();

					ConversionController api = new ConversionController();

					double result = api.applyConversion(value, origin, destination);

					txtResult.setText(String.valueOf(result));

				} else {

					Coin coin = new Coin();
                	double result = coin.resolver(beginning, end, value);

					txtResult.setText("Equivale a " + result + " " + end);
				}
            }
        });

		JLabel lblBanner = new JLabel();
		lblBanner.setIcon(new ImageIcon(Objects.requireNonNull(Principal.class.getResource("/images/fondoTres.png"))));
		lblBanner.setBounds(0, 0, 500, 353);
		add(lblBanner);
	}

	private static JLabel addLabelLink(String text, String url) {
		JLabel label = new JLabel(text);
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(url));
				} catch (IOException | URISyntaxException ex) {
					System.out.println("Ocurrio un error al cargar la página.");
				}
			}
		});
		return label;
	}

	private void loadComboCoins(JComboBox<String> comboStart, JComboBox<String> comboEnd, boolean connection) {
		
		if (connection) {
			for (Country country: Country.values()) {
				comboStart.addItem(country.getNombrePais());
				comboEnd.addItem(country.getNombrePais());
			}
			return;
		}

		String[] coins = {
				"",
				"Peso Mexicano",
				"Dólar",
				"Euros",
				"Libras Esterlinas",
				"Yen Japonés",
				"Won sur-coreano"
		};
		
		for (String coin: coins) {
			comboStart.addItem(coin);
			comboEnd.addItem(coin);
		}
	}

	private void loadOptionsTemperature(JComboBox<String> comboStart, JComboBox<String> comboEnd) {

		String[] temperatures = {
				"",
				"Celsius",
				"Kelvin",
				"Fahrenheit",
				"Rankine"
		};

		for (String temperature: temperatures) {
			comboStart.addItem(temperature);
			comboEnd.addItem(temperature);
		}
	}

	private void addLabel(String content, int x, int y, int width) {
		JLabel label = new JLabel(content);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(x, y, width, 21);
		this.add(label);
	}
}