import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Registrar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	public boolean verifyFields() {
		String Usuario = textField.getText();
		String Nombre = textField_1.getText();
		String Apellido = textField_2.getText();
		String Correo = textField_3.getText();
		String Telefono = textField_4.getText();
		String Contrasena = String.valueOf(((JPasswordField) textField_5).getPassword());
		String Contrasena1 = String.valueOf(((JPasswordField) textField_6).getPassword());
		
		if( Usuario.trim().equals("") || Nombre.trim().equals("") || Apellido.trim().equals("") ||Correo.trim().equals("") || Telefono.trim().equals("") || Contrasena.trim().equals("") || Contrasena1.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Ninguno de los campos puede estar vacio");
			return false;
		}
		else if(Contrasena.equals(Contrasena1)) {
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Clave no son iguales");
			return false;
		}
	}
	
	public boolean checkUsuario(String usuario) {
		PreparedStatement st;
		ResultSet rs;
		boolean Existe = false;
		String query = "SELECT * FROM usuarios WHERE Usuario = ?";
		try {
			st = ConexionDB.getConnection().prepareStatement(query);
			st.setString(1, usuario);
			rs = st.executeQuery();
			if(rs.next()) {
				Existe = true;
				JOptionPane.showMessageDialog(null, "Este usuario existe.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Existe;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrar frame = new Registrar();
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
	public Registrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 501);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Nombre de usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(24, 24, 259, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(24, 81, 259, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(24, 148, 259, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero de telefono");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(24, 215, 259, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Correo electronico");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(24, 274, 259, 29);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contrase\u00F1a");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(24, 336, 259, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Confirmar contrase\u00F1a");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(24, 390, 259, 25);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(24, 60, 189, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(24, 117, 189, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(24, 184, 189, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(24, 251, 189, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(24, 311, 189, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JPasswordField();
		textField_5.setColumns(10);
		textField_5.setBounds(24, 361, 189, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JPasswordField();
		textField_6.setColumns(10);
		textField_6.setBounds(24, 418, 189, 20);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("Aceptar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Usuario = textField.getText();
				String Nombre = textField_1.getText();
				String Apellido = textField_2.getText();
				String Correo = textField_3.getText();
				String Telefono = textField_4.getText();
				String Contrasena = String.valueOf(((JPasswordField) textField_5).getPassword());
				
				if(verifyFields()) {
					if(!checkUsuario(Usuario)) {
						PreparedStatement ps;
						String insertarRegistroQuery = "INSERT INTO usuarios (usuario,nombre,apellido,correo_electronico,telefono,contrasena) VALUES(?,?,?,?,?,?)";
						try {ps = ConexionDB.getConnection().prepareStatement(insertarRegistroQuery);
						ps.setString(1, Usuario);
						ps.setString(2, Nombre);
						ps.setString(3, Apellido);
						
						ps.setString(4, Correo);
						ps.setString(5, Telefono);
						ps.setString(6, Contrasena);
							if(ps.executeUpdate() != 0) {
							JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
							Login login = new Login();
							login.setVisible(true);
							login.setLocationRelativeTo(null);
							dispose();
							
							}else {
								JOptionPane.showMessageDialog(null, "Error");
							}
							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						
					
					}
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(293, 148, 107, 44);
		contentPane.add(btnNewButton);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(293, 218, 107, 44);
		contentPane.add(btnAtras);
	}
}
