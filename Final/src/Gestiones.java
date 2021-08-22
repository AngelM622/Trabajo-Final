import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Gestiones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestiones frame = new Gestiones();
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
	public Gestiones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\SOLER\\Downloads\\pngwing.com (1).png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 gestionUsuarios gU = new gestionUsuarios();
			        gU.setVisible(true);   
			        gU.setLocationRelativeTo(null);
			        dispose();
			}
		});
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\SOLER\\Downloads\\pngwing.com (1).png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(66, 95, 130, 105);
		contentPane.add(btnNewButton);
		
		JButton btnPulseParaGestionar = new JButton("");
		btnPulseParaGestionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 gestionarProductos gP = new gestionarProductos();
			        gP.setVisible(true);   
			        gP.setLocationRelativeTo(null);
			        dispose();
			}
		});
		btnPulseParaGestionar.setIcon(new ImageIcon("C:\\Users\\SOLER\\Downloads\\pngwing.com (2) (1).png"));
		btnPulseParaGestionar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPulseParaGestionar.setBounds(322, 95, 130, 105);
		contentPane.add(btnPulseParaGestionar);
		
		JLabel lblNewLabel = new JLabel("Pulse para gestionar usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 45, 261, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblPulseParaGestionar = new JLabel("Pulse para gestionar productos");
		lblPulseParaGestionar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPulseParaGestionar.setBounds(270, 45, 240, 39);
		contentPane.add(lblPulseParaGestionar);
		
		JButton btnNewButton_1 = new JButton("Cerrar sesion");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Login L = new Login();
			        L.setVisible(true);   
			        L.setLocationRelativeTo(null);
			        dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(188, 209, 145, 41);
		contentPane.add(btnNewButton_1);
	}

}
