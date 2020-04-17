package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class Main {

	public static void main(String[] args) {
		Vista frame;
		
		    frame = new Vista();
			frame.setVisible(true);
			
		frame.botonNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				frame.panel.removeAll();
				frame.panel.repaint();
				
				
				DefaultComboBoxModel<String> modeloDelCombo = new DefaultComboBoxModel<String>();
				
				try {
					ConectarBD conectar = new ConectarBD();   //Hemos creado un objeto de tipo ConectarBD
					conectar.conectarBD();                    //Hemos llamado a una funcion del objeto ConectarBD a traves del objeto creado previamente
					ResultSet tablaDepartamento = conectar.ejecutarQuery("select idDepartamento, nombreDepartamento from departamentos");
					while(tablaDepartamento.next()) { //el next siempre se usa cuando haya un ResultSet
						modeloDelCombo.addElement(tablaDepartamento.getString("nombreDepartamento"));
					}
					frame.comboBoxDepartamentos = new JComboBox<String>(modeloDelCombo);
					frame.comboBoxDepartamentos.setBounds(100, 63, 159, 20);
					frame.panel.add(frame.comboBoxDepartamentos);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Se ha producido un error, bye bye");
					e.printStackTrace();
				}
				
				
				
				JLabel lblNewLabel = new JLabel("Departamentos");
				lblNewLabel.setBounds(100, 43, 81, 14);
				frame.panel.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Extension Empleado");
				lblNewLabel_1.setBounds(285, 43, 102, 14);
				frame.panel.add(lblNewLabel_1);
				
				frame.textoExtension = new JTextField();
				frame.textoExtension.setBounds(295, 63, 86, 20);
				frame.panel.add(frame.textoExtension);
				frame.textoExtension.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("Fecha Nacimiento");
				lblNewLabel_2.setBounds(100, 106, 114, 14);
				frame.panel.add(lblNewLabel_2);
				
				frame.textoFechaNacimiento = new JTextField();
				frame.textoFechaNacimiento.setBounds(100, 131, 86, 20);
				frame.panel.add(frame.textoFechaNacimiento);
				frame.textoFechaNacimiento.setColumns(10);
				
				JLabel lblNewLabel_3 = new JLabel("Fecha Ingreso");
				lblNewLabel_3.setBounds(295, 106, 82, 14);
				frame.panel.add(lblNewLabel_3);
				
				frame.textoFechaIngreso = new JTextField();
				frame.textoFechaIngreso.setBounds(295, 131, 86, 20);
				frame.panel.add(frame.textoFechaIngreso);
				frame.textoFechaIngreso.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel("Salario");
				lblNewLabel_4.setBounds(100, 173, 46, 14);
				frame.panel.add(lblNewLabel_4);
				
				frame.textoSalarioEmpleado = new JTextField();
				frame.textoSalarioEmpleado.setBounds(100, 198, 86, 20);
				frame.panel.add(frame.textoSalarioEmpleado);
				frame.textoSalarioEmpleado.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("Comisi\u00F3n");
				lblNewLabel_5.setBounds(331, 183, 46, 14);
				frame.panel.add(lblNewLabel_5);
				
				frame.textoComisionEmpleado = new JTextField();
				frame.textoComisionEmpleado.setBounds(314, 198, 86, 20);
				frame.panel.add(frame.textoComisionEmpleado);
				frame.textoComisionEmpleado.setColumns(10);
				
				JLabel lblNewLabel_6 = new JLabel("Numero de Hijos");
				lblNewLabel_6.setBounds(100, 229, 89, 14);
				frame.panel.add(lblNewLabel_6);
				
				frame.textoNumeroHijos = new JTextField();
				frame.textoNumeroHijos.setBounds(100, 253, 86, 20);
				frame.panel.add(frame.textoNumeroHijos);
				frame.textoNumeroHijos.setColumns(10);
				
				JLabel lblNewLabel_7 = new JLabel("Nombre");
				lblNewLabel_7.setBounds(341, 239, 46, 14);
				frame.panel.add(lblNewLabel_7);
				
				frame.textoNombreEmpleado = new JTextField();
				frame.textoNombreEmpleado.setBounds(324, 253, 86, 20);
				frame.panel.add(frame.textoNombreEmpleado);
				frame.textoNombreEmpleado.setColumns(10);
				
				JButton botonAceptar = new JButton("Aceptar");
				botonAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String textoExtension = frame.textoExtension.getText();
						String textoFNacimiento = frame.textoFechaNacimiento.getText();
						String textoFIngreso = frame.textoFechaIngreso.getText();
						String textoSalario = frame.textoSalarioEmpleado.getText();
						String textoComision = frame.textoComisionEmpleado.getText();
						String textohijos = frame.textoNumeroHijos.getText();
						String textoNombre = frame.textoNombreEmpleado.getText();
						int idDepartamentoSeleccionado = 0;
						if(textoExtension.equals("")||textoFNacimiento.equals("")||textoFIngreso.equals("")||textoSalario.equals("")||textoComision.equals("")||textohijos.equals("")||textoNombre.equals("")) {
							JOptionPane.showMessageDialog(null, "Rellene todos los campos");
						}
						else {
							String departamentoSeleccionado = (String)frame.comboBoxDepartamentos.getSelectedItem();
							String queryIdDepartamentos = "select idDepartamento from departamentos where nombreDepartamento ='" + departamentoSeleccionado +"'";
							System.out.println(queryIdDepartamentos);
							try {
								ConectarBD conectar = new ConectarBD();
								conectar.conectarBD();
								ResultSet resultadoQueryIdDepartamento = conectar.ejecutarQuery(queryIdDepartamentos);//Aqui tengo una lista de idDepartamentos
								while(resultadoQueryIdDepartamento.next()) {//Aqui recorro la lista de idDepartamentos comentada antes
									idDepartamentoSeleccionado = resultadoQueryIdDepartamento.getInt("idDepartamento");
								}
								System.out.println(idDepartamentoSeleccionado);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							int textoHijosConvertido;
							
							try {
								textoHijosConvertido = Integer.parseInt(textohijos);
							}catch(Exception e) {
								textoHijosConvertido=0;
								e.printStackTrace();
							}
							
							float textocomisionConvertido;
							
							try {
								textocomisionConvertido = Float.parseFloat(textoComision);
							}catch(Exception e) {
								textocomisionConvertido=0;
								e.printStackTrace();
							}
							
							float textosalarioConvertido;
							
							try {
								textosalarioConvertido = Float.parseFloat(textoSalario);
							}catch(Exception e){
								textosalarioConvertido=0;
								e.printStackTrace();
							}
							
							int textoExtensionConvertido;
							
							try {
								textoExtensionConvertido = Integer.parseInt(textoExtension);
							}catch(Exception e){
								textoExtensionConvertido=0;
								e.printStackTrace();
							}
							
							
							
							try {
								String insertarQuery = "insert into empleados values (null," + idDepartamentoSeleccionado + "," + textoExtensionConvertido + "," + "'"  + textoFNacimiento + "'" + "," +  "'" + textoFIngreso + "'" + "," + textosalarioConvertido + "," + textocomisionConvertido + "," + textoHijosConvertido + "," + "'" + textoNombre + "')";
								System.out.println(insertarQuery);
								ConectarBD conectar = new ConectarBD();
								Connection conexion = conectar.conectarBD();
								Statement preparacionInsert = conexion.createStatement();
								preparacionInsert.executeUpdate(insertarQuery);
								System.exit(0);
							}catch(Exception e) {
								e.printStackTrace();
							}
								
						}
					}
				});
				botonAceptar.setBounds(115, 297, 89, 23);
				frame.panel.add(botonAceptar);
				
				JButton botonCancelar = new JButton("Cancelar");
				botonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				botonCancelar.setBounds(345, 297, 89, 23);
				frame.panel.add(botonCancelar);
				
				frame.panel.setBounds(24, 43, 500, 450);
				frame.panel.setLayout(null);
				frame.contentPane.add(frame.panel);
				frame.panel.setVisible(true);
				
			}
			});
		
		frame.botonConsultas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.panel.removeAll();
				frame.panel.repaint();
				
				frame.eligeConsulta = new JComboBox();
				frame.eligeConsulta.addItem("Buscar por idEmpleado");
				frame.eligeConsulta.addItem("Buscar por nombreEmpleado");
				frame.eligeConsulta.setToolTipText("");
				frame.eligeConsulta.setBounds(28, 120, 170, 20);//x horizontal, y vertical, width ancho y height altura
				frame.panel.add(frame.eligeConsulta);
				
				
				frame.textoConsulta = new JTextField();
				frame.textoConsulta.setBounds(204, 120, 141, 20);
				frame.panel.add(frame.textoConsulta);
				frame.textoConsulta.setColumns(10);
				
				JButton botonAceptarConsulta = new JButton("Consulta");
				botonAceptarConsulta.setBounds(80, 226, 89, 23);
				frame.panel.add(botonAceptarConsulta);
				
				botonAceptarConsulta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//paso 1 coger los campos
						String textoConsulta = frame.textoConsulta.getText();
						String jComboBoxEligeConsulta = (String)frame.eligeConsulta.getSelectedItem();
						// paso 2 comprobacion de campos vacios
						if(textoConsulta.equals("")){
							JOptionPane.showMessageDialog(null, "Debe rellenar el campo");
						}else {
							String queryBuscarEmpleado = "";
							if(jComboBoxEligeConsulta.equals("Buscar por idEmpleado")) {
								queryBuscarEmpleado = "select * from empleados where idEmpleado = " + textoConsulta;	
							}
							if(jComboBoxEligeConsulta.equals("Buscar por nombreEmpleado")) {
								queryBuscarEmpleado = "select * from empleados where nombreEmpleado = " + "'" + textoConsulta + "'";
								
							}
							try {
								ConectarBD conectar = new ConectarBD();//creo el objeto de la clase ConectarBD
								conectar.conectarBD();//me conecto a la base de datos
								ResultSet datosGuardadosQueryBuscarIdEmpleado = conectar.ejecutarQuery(queryBuscarEmpleado);
								while(datosGuardadosQueryBuscarIdEmpleado.next()) {
									int idEmpleado = datosGuardadosQueryBuscarIdEmpleado.getInt("idEmpleado");//el nombre de la columna de la base de datos
									int idDepartamentoFK = datosGuardadosQueryBuscarIdEmpleado.getInt("idDepartamentoFK");
									int extensionEmpleado = datosGuardadosQueryBuscarIdEmpleado.getInt("extensionEmpleado");
									String fechaNacimientoEmpleado = datosGuardadosQueryBuscarIdEmpleado.getString("fechaNacimientoEmpleado");
									String fechaIngresoEmpleado = datosGuardadosQueryBuscarIdEmpleado.getString("fechaIngresoEmpleado");
									int salarioEmpleado = datosGuardadosQueryBuscarIdEmpleado.getInt("salarioEmpleado");
									int comisionEmpleado = datosGuardadosQueryBuscarIdEmpleado.getInt("comisionEmpleado");
									int hijosEmpleado = datosGuardadosQueryBuscarIdEmpleado.getInt("hijosEmpleado");
									String nombreEmpleado = datosGuardadosQueryBuscarIdEmpleado.getString("nombreEmpleado");
									JOptionPane.showMessageDialog(null, "idEmpleado:" + idEmpleado + "\n idDepartamentoFK:" + idDepartamentoFK + "\n extensionEmpleado:" + extensionEmpleado + "\n fechaNacimientoEmpleado:" + fechaNacimientoEmpleado + "\n fechaIngresoEmpleado:" + fechaIngresoEmpleado + "\n salarioEmpleado:" + salarioEmpleado + "\n comisionEmpleado;" + comisionEmpleado + "\n hijosEmpleado:" + hijosEmpleado + "\n nombreEmpleado:" + nombreEmpleado);
								}
							} catch (SQLException e) {
								
								e.printStackTrace();
							}	
							
						}
						//paso si el campo no esta vacio que funcione
					}
				});
				
				JButton botonCancelar = new JButton("Cancelar");
				botonCancelar.setToolTipText("");
				botonCancelar.setBounds(256, 226, 89, 23);
				frame.panel.add(botonCancelar);
				
				botonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				
				frame.panel.setBounds(24, 43, 500, 450);
				frame.panel.setLayout(null);
				frame.contentPane.add(frame.panel);
				frame.panel.setVisible(true);
				
				
			}
		});
		
		frame.botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.panel.removeAll();
				frame.panel.repaint();
				
				frame.jComboBoxEliminar = new JComboBox();
				cargarEmpleados(frame, frame.jComboBoxEliminar);
				frame.jComboBoxEliminar.setBounds(21, 104, 180, 20);
				frame.panel.add(frame.jComboBoxEliminar);
				
				JButton botonPermiteEliminar = new JButton("Eliminar");
				botonPermiteEliminar.setBounds(112, 214, 89, 23);
				frame.panel.add(botonPermiteEliminar);
				
				botonPermiteEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String comprobarNombreEmpleado = (String)frame.jComboBoxEliminar.getSelectedItem();
						try {
							ConectarBD conectar = new ConectarBD();
							Connection conexion = conectar.conectarBD();
							System.out.println("select idEmpleado from empleados where nombreEmpleado =" + "'" + comprobarNombreEmpleado + "'");
							ResultSet ejecutarQuery = conectar.ejecutarQuery("select idEmpleado from empleados where nombreEmpleado =" + "'" + comprobarNombreEmpleado + "'");
							while(ejecutarQuery.next()) {
								int guardarIdEmpleadoSeleccionado = ejecutarQuery.getInt("idEmpleado");
								System.out.println("delete from empleados where idEmpleado =" + guardarIdEmpleadoSeleccionado);
								Statement preparacionInsert = conexion.createStatement();
								preparacionInsert.executeUpdate("delete from empleados where idEmpleado =" + guardarIdEmpleadoSeleccionado);
								JOptionPane.showMessageDialog(null, "El empleado se borro correctamente");
								System.exit(0);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				
				JButton botonCancelar = new JButton("Cancelar");
				botonCancelar.setBounds(266, 214, 89, 23);
				frame.panel.add(botonCancelar);
				
				botonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				
				frame.panel.setBounds(24, 43, 500, 450);
				frame.panel.setLayout(null);
				frame.contentPane.add(frame.panel);
				frame.panel.setVisible(true);
			}
		});
		
		frame.botonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.panel.removeAll();
				frame.panel.repaint();
				
				frame.jComboBoxPermiteModificar = new JComboBox();
				cargarEmpleados(frame, frame.jComboBoxPermiteModificar);
				frame.jComboBoxPermiteModificar.setBounds(155, 98, 178, 20);
				frame.panel.add(frame.jComboBoxPermiteModificar);
				
				frame.textoNuevoNombre = new JTextField();
				frame.textoNuevoNombre.setBounds(279, 155, 163, 20);
				frame.panel.add(frame.textoNuevoNombre);
				frame.textoNuevoNombre.setColumns(10);
				
				JLabel lblNewLabel = new JLabel("Nuevo Nombre");
				lblNewLabel.setBounds(66, 155, 146, 14);
				frame.panel.add(lblNewLabel);
				
				frame.botonPermiteModificar = new JButton("Modificar");
				frame.botonPermiteModificar.setBounds(118, 206, 89, 23);
				frame.panel.add(frame.botonPermiteModificar);
				
				frame.botonPermiteModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String aquiGuardoNuevoNombre = frame.textoNuevoNombre.getText();
						if(aquiGuardoNuevoNombre.equals("")){
							JOptionPane.showMessageDialog(null, "Rellene el campo");
						}else {
							String aquiGuardoNombreViejo = (String)frame.jComboBoxPermiteModificar.getSelectedItem();
							try{
								ConectarBD conectar = new ConectarBD();
								Connection conexion = conectar.conectarBD();
								String querymodificar = "update empleados set nombreEmpleado = 'GRILLO, PEPITO JUNIOR' where idEmpleado = 550";
								ResultSet ejecutarQuery = conectar.ejecutarQuery("select idEmpleado from empleados where nombreEmpleado =" + "'" + aquiGuardoNombreViejo + "'");
								while(ejecutarQuery.next()) {
									int guardarIdEmpleadoSeleccionado = ejecutarQuery.getInt("idEmpleado");
									Statement preparacionInsert = conexion.createStatement();
									preparacionInsert.executeUpdate("update empleados set nombreEmpleado =" + "'" + aquiGuardoNuevoNombre + "'" + "where idEmpleado =" + guardarIdEmpleadoSeleccionado);
									JOptionPane.showMessageDialog(null, "El empleado se modifico correctamente");
									System.exit(0);
								}
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					}
				});
				
				frame.botonPermiteCancelar = new JButton("Cancelar");
				frame.botonPermiteCancelar.setBounds(289, 206, 89, 23);
				frame.panel.add(frame.botonPermiteCancelar);
				
				frame.botonPermiteCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				
				frame.panel.setBounds(24, 43, 500, 450);
				frame.panel.setLayout(null);
				frame.contentPane.add(frame.panel);
				frame.panel.setVisible(true);
			}
		});
		
		}
	public static void cargarEmpleados(Vista frame, JComboBox jComboBoxARRellenar) {
		ConectarBD conectar = new ConectarBD();
		conectar.conectarBD();
		
		try {
			ResultSet respuesta = null;
			respuesta = conectar.ejecutarQuery(" select nombreEmpleado from empleados;");
			
			while(respuesta.next()) {	
				String nombreEmpleado = respuesta.getString("nombreEmpleado");
				jComboBoxARRellenar.addItem(nombreEmpleado);
				}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error bd:"+e);
		}
	}
	

}
