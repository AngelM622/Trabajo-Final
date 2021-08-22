import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class gestionUsuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionUsuarios frame = new gestionUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public gestionUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 444);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		

		final JTable tabla = new JTable();
		
		DefaultTableModel Modelo = new DefaultTableModel();


		
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cor = tabla.getSelectedRow();
				textField.setText(tabla.getValueAt(cor, 0).toString());
				textField_1.setText(tabla.getValueAt(cor, 1).toString());
				textField_2.setText(tabla.getValueAt(cor, 2).toString());
				textField_3.setText(tabla.getValueAt(cor, 3).toString());
				textField_4.setText(tabla.getValueAt(cor, 4).toString());
				textField_5.setText(tabla.getValueAt(cor, 5).toString());
			}
		});
			try {
				String Id,Usuario,Nombre, Apellido, Telefono, Correo;
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final","root","angel123");	
				java.sql.Statement st = conexion.createStatement();
		        ResultSet rs = st.executeQuery("select * from Usuarios");
		        
				String[] Columnas = {"Id","Usuario","Nombre","Apellido","Telefono","Correo_electronico"};
				
				Modelo.setColumnIdentifiers(Columnas);
				tabla.setModel(Modelo);
				

				while(rs.next()) {
					Id = rs.getString("Id");
					Usuario = rs.getString("Usuario");
					Nombre = rs.getString("Nombre");
					Apellido= rs.getString("Apellido");
					Telefono = rs.getString("Telefono");
					Correo = rs.getString("Correo_electronico");
					Modelo.addRow(new Object[] {Id, Usuario, Nombre, Apellido, Telefono, Correo});
					
	
				}	
				JScrollPane scrollPane = new JScrollPane(tabla);
				scrollPane.setBounds(10, 55, 658, 159);
				getContentPane().add(scrollPane);
				
				} catch(Exception e) {
		        System.err.println("Error:"+e);
				}
		
		
		
		JButton btnNewButton_3 = new JButton("Atras");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Gestiones G = new Gestiones();
			        G.setVisible(true);   
			        G.setLocationRelativeTo(null);
			        dispose();
			}
			
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(373, 323, 128, 39);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Tabla de estudiantes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(222, 11, 225, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConexionDB con = new ConexionDB();
				java.sql.Connection Conectar = con.getConnection();
					try {
						PreparedStatement pasar = Conectar.prepareStatement("Update Usuarios set Usuario='"+textField_1.getText()+"',Nombre='"+textField_2.getText()+"',Apellido='"+textField_3.getText()
		                +"',Telefono='"+textField_4.getText()+"',Correo_electronico='"+textField_5.getText()+"'where Id='"+textField.getText()+"'");
						pasar.executeUpdate();
						
						 try {
								String Id,Usuario, Nombre, Apellido, Telefono, Correo;
								Class.forName("com.mysql.cj.jdbc.Driver");
								java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final","root","angel123");	
								java.sql.Statement st = conexion.createStatement();
						        ResultSet rs = st.executeQuery("select * from Usuarios");
						        
								String[] Columnas = {"Id","Usuario","Nombre","Apellido","Telefono","Correo"};
								
								
								DefaultTableModel Modelo = new DefaultTableModel();
								Modelo.setColumnIdentifiers(Columnas);
								tabla.setModel(Modelo);


								while(rs.next()) {
									Id = rs.getString("Id");
									Usuario = rs.getString("Usuario");
									Nombre = rs.getString("Nombre");
									Apellido = rs.getString("Apellido");
									Telefono = rs.getString("Telefono");
									Correo = rs.getString("Correo_electronico");


									Modelo.addRow(new Object[] {Id,Usuario, Nombre, Apellido, Telefono, Correo});

									

								}	
								
								} catch(Exception e1) {
						        System.err.println("Error:"+e1);
								}
							JOptionPane.showMessageDialog(null, "Registro actualizado");
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(373, 256, 128, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(21, 281, 71, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(21, 309, 127, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(178, 231, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(178, 256, 128, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(180, 281, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(179, 304, 127, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Correo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(179, 335, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(179, 361, 127, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Id");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(21, 235, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(21, 256, 127, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(21, 336, 127, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(21, 361, 127, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int Fila = tabla.getSelectedRow();
				String Valor = tabla.getValueAt(Fila, 0).toString();
				String insertarRegistroQuery = "DELETE FROM Usuarios WHERE Id='"+Valor+"'";

				
				try {
					PreparedStatement ps = ConexionDB.getConnection().prepareStatement(insertarRegistroQuery);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro borrado");
				}catch(Exception e1) {
					
				}
				
				try {
					String Id,Usuario,Nombre, Apellido, Telefono, Correo;
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final","root","angel123");	
					java.sql.Statement st = conexion.createStatement();
			        ResultSet rs = st.executeQuery("select * from Usuarios");
			        
					String[] Columnas = {"Id,Usuario","Nombre","Apellido","Telefono","Correo_electronico"};
					DefaultTableModel Modelo = new DefaultTableModel();
					Modelo.setColumnIdentifiers(Columnas);
					tabla.setModel(Modelo);

					while(rs.next()) {
						Id = rs.getString("Id");
						Usuario = rs.getString("Usuario");
						Nombre = rs.getString("Nombre");
						Apellido= rs.getString("Apellido");
						Telefono = rs.getString("Telefono");
						Correo = rs.getString("Correo_electronico");
						Modelo.addRow(new Object[] {Id,Usuario, Nombre, Apellido, Telefono, Correo});
						
					}
					}catch(Exception e1) {
				        System.err.println("Error:"+e1);
					}
	
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(531, 256, 128, 39);
		contentPane.add(btnNewButton_1);
		

	}
}



