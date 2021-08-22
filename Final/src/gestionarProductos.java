import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gestionarProductos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionarProductos frame = new gestionarProductos();
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
	public gestionarProductos() {
		setForeground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 520);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTablaDeProcutos = new JLabel("Tabla de productos");
		lblTablaDeProcutos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTablaDeProcutos.setBounds(229, 32, 225, 33);
		contentPane.add(lblTablaDeProcutos);
		
		final JTable tabla = new JTable();
        
		String[] Columnas = {"Id","Nombre","Marca","Categoria","Precio","Cantidad"};
		
		
		final DefaultTableModel Modelo = new DefaultTableModel();
		Modelo.setColumnIdentifiers(Columnas);
		tabla.setModel(Modelo);
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int cor = tabla.getSelectedRow();
				textField_5.setText(tabla.getValueAt(cor, 0).toString());
				textField.setText(tabla.getValueAt(cor, 1).toString());
				textField_1.setText(tabla.getValueAt(cor, 2).toString());
				textField_2.setText(tabla.getValueAt(cor, 3).toString());
				textField_3.setText(tabla.getValueAt(cor, 4).toString());
				textField_4.setText(tabla.getValueAt(cor, 5).toString());
				
			}
		});
		 try {
			String Id,Nombre, Marca, Categoria, Precio, Cantidad;
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final","root","angel123");	
			java.sql.Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery("select * from Productos");


			while(rs.next()) {
				Id = rs.getString("Id");
				Nombre = rs.getString("Nombre");
				Marca = rs.getString("Marca");
				Categoria = rs.getString("Categoria");
				Precio = rs.getString("Precio");
				Cantidad = rs.getString("Cantidad");


				Modelo.addRow(new Object[] {Id,Nombre, Marca, Categoria, Precio, Cantidad});
				

			}	
			JScrollPane scrollPane = new JScrollPane(tabla);

			scrollPane.setBounds(10, 68, 658, 159);
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
		btnNewButton_3.setBounds(540, 349, 128, 39);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConexionDB con = new ConexionDB();
				Connection Conectar = con.getConnection();
					try {
						PreparedStatement pasar = Conectar.prepareStatement("Update productos set Nombre='"+textField.getText()+"',Marca='"+textField_1.getText()+"',Categoria='"+textField_2.getText()
		                +"',Precio='"+textField_3.getText()+"',Cantidad='"+textField_4.getText()+"'where Id='"+textField_5.getText()+"'");
						pasar.executeUpdate();
						
						 try {
								String Id, Nombre, Marca, Categoria, Precio, Cantidad;
								Class.forName("com.mysql.cj.jdbc.Driver");
								java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final","root","angel123");	
								java.sql.Statement st = conexion.createStatement();
						        ResultSet rs = st.executeQuery("select * from Productos");
						        
								String[] Columnas = {"Id","Nombre","Marca","Categoria","Precio","Cantidad"};
								
								
								DefaultTableModel Modelo = new DefaultTableModel();
								Modelo.setColumnIdentifiers(Columnas);
								tabla.setModel(Modelo);


								while(rs.next()) {
									Id = rs.getString("Id");
									Nombre = rs.getString("Nombre");
									Marca = rs.getString("Marca");
									Categoria = rs.getString("Categoria");
									Precio = rs.getString("Precio");
									Cantidad = rs.getString("Cantidad");


									Modelo.addRow(new Object[] {Id,Nombre, Marca, Categoria, Precio, Cantidad});

									

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
		btnNewButton.setBounds(540, 299, 128, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Fila = tabla.getSelectedRow();
				String Valor = tabla.getValueAt(Fila, 0).toString();
				String insertarRegistroQuery = "DELETE FROM Productos WHERE Id='"+Valor+"'";

				
				try {
					PreparedStatement ps = ConexionDB.getConnection().prepareStatement(insertarRegistroQuery);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro borrado");
				}catch(Exception e1) {
					
				}
				
				 try {
						String Id, Nombre, Marca, Categoria, Precio, Cantidad;
						Class.forName("com.mysql.cj.jdbc.Driver");
						java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final","root","angel123");	
						java.sql.Statement st = conexion.createStatement();
				        ResultSet rs = st.executeQuery("select * from Productos");
				        
						String[] Columnas = {"Id","Nombre","Marca","Categoria","Precio","Cantidad"};
						
						
						DefaultTableModel Modelo = new DefaultTableModel();
						Modelo.setColumnIdentifiers(Columnas);
						tabla.setModel(Modelo);


						while(rs.next()) {
							Id = rs.getString("Id");
							Nombre = rs.getString("Nombre");
							Marca = rs.getString("Marca");
							Categoria = rs.getString("Categoria");
							Precio = rs.getString("Precio");
							Cantidad = rs.getString("Cantidad");


							Modelo.addRow(new Object[] {Id,Nombre, Marca, Categoria, Precio, Cantidad});
							

						}	
						
						} catch(Exception e1) {
				        System.err.println("Error:"+e1);
						}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(402, 349, 128, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Nuevo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 nuevoProducto nP = new nuevoProducto();
			        nP.setVisible(true);   
			        nP.setLocationRelativeTo(null);
			        dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(402, 299, 128, 39);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(39, 359, 128, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(39, 419, 128, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(193, 299, 128, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(193, 359, 128, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(193, 419, 128, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(39, 324, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(39, 394, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(193, 270, 104, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(193, 324, 76, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(193, 394, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(39, 271, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(39, 299, 128, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
