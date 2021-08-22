import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class nuevoProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nuevoProducto frame = new nuevoProducto();
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
	public nuevoProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 370);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(21, 35, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(21, 92, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(21, 148, 86, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(21, 204, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(21, 260, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(21, 60, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(21, 117, 126, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(21, 173, 126, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(21, 229, 126, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(21, 285, 126, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("") || textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ninguno de los campos puede estar vacio");
				}else {
					PreparedStatement ps;
					String insertarRegistroQuery = "INSERT INTO productos (nombre,marca,categoria,precio,cantidad) VALUES(?,?,?,?,?)";
					try {
						ps = ConexionDB.getConnection().prepareStatement(insertarRegistroQuery);
						ps.setString(1, textField.getText());
						ps.setString(2, textField_1.getText());
						ps.setString(3, textField_2.getText());
						ps.setString(4, textField_3.getText());
						ps.setString(5, textField_4.getText());
						
						if(ps.executeUpdate() != 0) {
							JOptionPane.showMessageDialog(null, "Producto guardado");
							
							 gestionarProductos gP = new gestionarProductos();
						        gP.setVisible(true);   
						        gP.setLocationRelativeTo(null);
						        
							dispose();
							
						}else {
							JOptionPane.showMessageDialog(null, "Hubo un error. Verifica tu informacion.");
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
					
			}	
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(208, 132, 105, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 gestionarProductos gP = new gestionarProductos();
			        gP.setVisible(true);   
			        gP.setLocationRelativeTo(null);
			        dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(208, 202, 105, 46);
		contentPane.add(btnNewButton_1);
	}
}
