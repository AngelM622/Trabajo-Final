import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.*;

public class Login extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Source Sans Pro Semibold", Font.ITALIC, 20));
		lblNewLabel.setBounds(93, 31, 100, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(64, 57, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Source Sans Pro Semibold", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(79, 88, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JPasswordField ();
		textField_1.setBounds(64, 113, 136, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement st;
				ResultSet rs;
				
				String username = textField.getText();
				String password = String.valueOf(((JPasswordField) textField_1).getPassword());
				
				String query = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";
				try {
					st = ConexionDB.getConnection().prepareStatement(query);
					
					st.setString(1, username);
					st.setString(2, password);
					rs = st.executeQuery();
					
					if(rs.next()) {
						Gestiones ventana = new Gestiones();
						ventana.setVisible(true);
						ventana.setLocationRelativeTo(null);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null,"Usuario o Contrasena incorrecta");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(61, 155, 139, 20);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Registrar R = new Registrar();
			        R.setVisible(true);   
			        R.setLocationRelativeTo(null);
			        dispose();
			}
		});
		
		btnNewButton_1.setBounds(61, 186, 139, 20);
		contentPane.add(btnNewButton_1);
	}

}
