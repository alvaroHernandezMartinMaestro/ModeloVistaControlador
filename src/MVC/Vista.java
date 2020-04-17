package MVC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Vista extends JFrame {

	public JPanel contentPane;

	
	public JMenuItem botonNuevo;
	public JMenuItem botonConsultas;
	public JMenuItem botonEliminar;
	public JMenuItem botonModificar;
	public JPanel panel;
	public JTextField textoExtension;
	public JTextField textoFechaNacimiento;
	public JTextField textoFechaIngreso;
	public JTextField textoSalarioEmpleado;
	public JTextField textoComisionEmpleado;
	public JTextField textoNumeroHijos;
	public JTextField textoNombreEmpleado;
	public JComboBox comboBoxDepartamentos;
	public JComboBox eligeConsulta;
	public JTextField textoConsulta;
	public JComboBox jComboBoxEliminar;
	public JComboBox jComboBoxPermiteModificar;
	public JButton botonPermiteEliminar;
	public JButton botonPermiteModificar;
	public JButton botonPermiteCancelar;
	public JTextField textoNuevoNombre;
	
	
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 11, 511, 21);
		contentPane.add(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("Empleados");
		menuBar_1.add(mnNewMenu);
		
		botonNuevo = new JMenuItem("Nuevo");
		mnNewMenu.add(botonNuevo);
		
		botonConsultas = new JMenuItem("Consultas");
		mnNewMenu.add(botonConsultas);
		
		botonEliminar = new JMenuItem("Eliminar");
		mnNewMenu.add(botonEliminar);
		
		botonModificar = new JMenuItem("Modificar");
		mnNewMenu.add(botonModificar);
		
		panel = new JPanel();
		panel.setVisible(false);
		
	}
	
}
