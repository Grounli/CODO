package com.codo.vista.gastos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorGastos;
import com.codo.controlador.ControladorPrincipal;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.InterfazGastos;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class VentanaGastos extends JDialog implements InterfazGastos {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField textFieldValor;
	private JTextField textFieldComentario;
	private JComboBox comboBoxCuenta;
	private JComboBox comboBoxEtiquetas;
	private JDateChooser dateChooser;
	private JButton okButton;
	private JButton cancelButton;
	private List<Tipos> listaDeTipos;
	
	
	public VentanaGastos(List<Cuentas> listaDeCuentas, List<Etiquetas> listaDeEtiqueta, List<Tipos> listaDeTipos) {
		setBackground(Color.LIGHT_GRAY);
		
		this.listaDeTipos=listaDeTipos;
		
		setPreferredSize(new Dimension(400, 400));
		setTitle("Panel Gastos");
		setBounds(100, 100, 400, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

	
		
		NumberFormat formatValor = new DecimalFormat("#0.00");   
		textFieldValor = new JFormattedTextField(formatValor);
		textFieldValor.setBounds(199, 182, 86, 20);
		contentPanel.add(textFieldValor);
		textFieldValor.setColumns(10);

		textFieldComentario = new JTextField();
		textFieldComentario.setBounds(199, 268, 86, 20);
		contentPanel.add(textFieldComentario);
		textFieldComentario.setColumns(10);

		comboBoxCuenta = new JComboBox();
		comboBoxCuenta.setBounds(199, 92, 95, 20);
		for (Cuentas cuenta : listaDeCuentas) {
			comboBoxCuenta.addItem(cuenta);
		}
		contentPanel.add(comboBoxCuenta);

		comboBoxEtiquetas = new JComboBox();
		comboBoxEtiquetas.setBounds(199, 136, 95, 20);
		for (Etiquetas etiqueta : listaDeEtiqueta) {
			comboBoxEtiquetas.addItem(etiqueta);
		}
		contentPanel.add(comboBoxEtiquetas);

		JLabel lblCuenta = new JLabel("Cuenta:");
		lblCuenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCuenta.setBounds(72, 95, 46, 14);
		contentPanel.add(lblCuenta);

		JLabel lblNewLabel = new JLabel("Etiquetas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(72, 139, 78, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblValor = new JLabel("Valor: *");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValor.setBounds(72, 188, 46, 14);
		contentPanel.add(lblValor);

		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComentario.setBounds(72, 271, 78, 14);
		contentPanel.add(lblComentario);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(199, 227, 95, 20);
		dateChooser.setDate(new Date());
		contentPanel.add(dateChooser);
		

		JLabel lblFecha = new JLabel("Fecha: *");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(72, 227, 56, 14);
		contentPanel.add(lblFecha);
		
		JLabel lblVentanaDeGastos = new JLabel("Ventana de gastos:");
		lblVentanaDeGastos.setForeground(Color.BLUE);
		lblVentanaDeGastos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVentanaDeGastos.setBounds(119, 33, 175, 29);
		contentPanel.add(lblVentanaDeGastos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Añadir Gasto");
				okButton.setActionCommand(BOTON_ANADIR_GASTO);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand(BOTON_CANCELAR_GASTO);
				buttonPane.add(cancelButton);
			}
		}
	}

	public Movimientos anadirGasto() {
		Cuentas cuenta = (Cuentas) comboBoxCuenta.getSelectedItem();
		Etiquetas etiqueta = (Etiquetas) comboBoxEtiquetas.getSelectedItem();
		Double valor = Double.valueOf(textFieldValor.getText().replace(",", "."));
		Date fecha = dateChooser.getDate();
		String comentario = textFieldComentario.getText();

		Movimientos movimiento = new Movimientos(cuenta, etiqueta, listaDeTipos.get(1), valor, fecha, comentario);
		this.limpiarCampos();
		return movimiento;
	}
	
	
	public void limpiarCampos(){
		
		textFieldValor.setText("");
		dateChooser.setDate(new Date());
		textFieldComentario.setText("");
		JOptionPane.showMessageDialog(null,"Gasto realizado correctamente","Gasto realizado",JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public boolean comprobarCampos(){
		
		
		if(textFieldValor.getText().isEmpty()&&dateChooser.getDate()==null){
			JOptionPane.showMessageDialog(null,"El valor del gasto y la fecha no son correctos.","Error campos",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (textFieldValor.getText().isEmpty()){ 
			System.out.println(textFieldValor.getText());
			JOptionPane.showMessageDialog(null,"El valor del gasto no es correcto.","Error campos",JOptionPane.ERROR_MESSAGE);
			return false;
			}
		if(dateChooser.getDate()==null)
		{
			JOptionPane.showMessageDialog(null,"La fecha introducida no es correcta.","Error campos",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		
		
		else return true;
	}
	
	
	public void cerrarVentana(){
		this.dispose();
	}
	
	@Override
	public void asignarControlador(ControladorGastos control) {

		okButton.addActionListener(control);
		cancelButton.addActionListener(control);
	}

	@Override
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
