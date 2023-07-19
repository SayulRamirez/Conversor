package alura.com.conversor;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 412);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu menuOpciones = new JMenu("Opciones");
		menuBar.add(menuOpciones);
		
		JMenuItem menuCambiar = new JMenuItem("Cambiar tipo de conversión");
		menuCambiar.setIcon(new ImageIcon(Principal.class.getResource("/alura/com/imagenes/conversion.png")));
		menuOpciones.add(menuCambiar);
		
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.setIcon(new ImageIcon(Principal.class.getResource("/alura/com/imagenes/salir.png")));
		menuOpciones.add(menuSalir);
		
		JMenuItem menuLimpiar = new JMenuItem("Limpiar");
		menuLimpiar.setIcon(new ImageIcon(Principal.class.getResource("/alura/com/imagenes/limpiar.png")));
		menuBar.add(menuLimpiar);
		
		JMenuItem menuAcerca = new JMenuItem("Acerca de");
		menuAcerca.setIcon(new ImageIcon(Principal.class.getResource("/alura/com/imagenes/acerca.png")));
		menuBar.add(menuAcerca);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Aplicar conversión");
		btnNewButton.setBounds(88, 307, 298, 27);
		contentPane.add(btnNewButton);
		
		textFieldResultado = new JTextField();
		textFieldResultado.setBounds(104, 243, 219, 27);
		contentPane.add(textFieldResultado);
		textFieldResultado.setColumns(10);
		
		JComboBox comboBoxFinal = new JComboBox();
		comboBoxFinal.setBounds(251, 190, 182, 27);
		contentPane.add(comboBoxFinal);
		
		JLabel labelA = new JLabel("a:");
		labelA.setBounds(243, 168, 56, 17);
		contentPane.add(labelA);
		
		JComboBox comboBoxInicio = new JComboBox();
		comboBoxInicio.setBounds(21, 188, 182, 27);
		contentPane.add(comboBoxInicio);
		
		JLabel labelCambio = new JLabel("Cambiar de: ");
		labelCambio.setBounds(24, 165, 84, 20);
		contentPane.add(labelCambio);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(251, 114, 189, 43);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel labelMonto = new JLabel("Ingresa la cantidad para convertir:");
		labelMonto.setBounds(49, 114, 182, 21);
		contentPane.add(labelMonto);
		
		JLabel labelTitulo = new JLabel("ELIGE LA CONVERSIÓN A REALIZAR");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelTitulo.setForeground(new Color(0, 0, 0));
		labelTitulo.setBounds(30, 31, 446, 37);
		contentPane.add(labelTitulo);
		
		JLabel labelFondoBanner = new JLabel("");
		labelFondoBanner.setIcon(new ImageIcon(Principal.class.getResource("/alura/com/imagenes/flechas.jpg")));
		labelFondoBanner.setBounds(10, 11, 477, 78);
		contentPane.add(labelFondoBanner);
		
		JLabel labelBanner = new JLabel("");
		labelBanner.setIcon(new ImageIcon(Principal.class.getResource("/alura/com/imagenes/fondo.png")));
		labelBanner.setBounds(0, 0, 497, 345);
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
