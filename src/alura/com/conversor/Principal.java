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

public class Principal extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 513, 357);
		
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
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setBounds(0, 0, 497, 290);
		contentPane.add(labelFondo);
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
