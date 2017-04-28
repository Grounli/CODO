package com.codo.vista.transferencias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorTransferencias;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.InterfazTransferencias;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class VentanaTransferencias extends JDialog implements InterfazTransferencias {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField textFieldValor;
	private JTextField textFieldComentario;
	private JComboBox comboBoxCuentaOrigen;
	private JComboBox comboBoxCuentaDestino;
	private JDateChooser dateChooser;
	private JComboBox comboBoxEtiquetas;
	private JButton okButton;
	private List<Tipos> listaDeTipos;
	private JButton cancelButton;

	public VentanaTransferencias(List<Cuentas> listaDeCuentas, List<Etiquetas> listaDeEtiqueta,
			List<Tipos> listaDeTipos) {
		this.listaDeTipos=listaDeTipos;
		
		setTitle(" PanelTransferencias");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 400, 400);
		setPreferredSize(new Dimension(400, 400));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cuenta origen:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setBounds(71, 69, 92, 32);
			contentPanel.add(lblNewLabel);
		}

		JLabel lblCuentaDestino = new JLabel("Cuenta destino:");
		lblCuentaDestino.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCuentaDestino.setBounds(71, 106, 92, 22);
		contentPanel.add(lblCuentaDestino);

		JLabel lblValor = new JLabel("Valor: *");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValor.setBounds(71, 178, 92, 14);
		contentPanel.add(lblValor);

		JLabel lblFecha = new JLabel("Fecha: *");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(71, 206, 92, 14);
		contentPanel.add(lblFecha);

		JLabel lblComentario = new JLabel("Comentario:");
		lblComentario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComentario.setBounds(71, 237, 92, 22);
		contentPanel.add(lblComentario);

		comboBoxCuentaOrigen = new JComboBox();
		comboBoxCuentaOrigen.setBounds(200, 76, 83, 20);
		for (Cuentas cuenta : listaDeCuentas) {
			comboBoxCuentaOrigen.addItem(cuenta);
		}
		contentPanel.add(comboBoxCuentaOrigen);

		comboBoxCuentaDestino = new JComboBox();
		comboBoxCuentaDestino.setBounds(200, 108, 83, 20);
		for (Cuentas cuenta : listaDeCuentas) {
			comboBoxCuentaDestino.addItem(cuenta);
		}
		contentPanel.add(comboBoxCuentaDestino);
		
		NumberFormat formatValor = new DecimalFormat("#0.00");
		textFieldValor = new JFormattedTextField(formatValor);
		textFieldValor.setBounds(197, 176, 86, 20);
		contentPanel.add(textFieldValor);
		textFieldValor.setColumns(10);

		dateChooser = new JDateChooser();
		dateChooser.setDate(new Date());
		dateChooser.setBounds(197, 207, 95, 20);
		contentPanel.add(dateChooser);

		textFieldComentario = new JTextField();
		textFieldComentario.setBounds(197, 239, 86, 20);
		contentPanel.add(textFieldComentario);
		textFieldComentario.setColumns(10);

		JLabel lblEtiquetas = new JLabel("Etiquetas:");
		lblEtiquetas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEtiquetas.setBounds(71, 145, 92, 14);
		contentPanel.add(lblEtiquetas);
		
		JLabel lblVentanaDeTransferencias = new JLabel("Ventana de transferencias:");
		lblVentanaDeTransferencias.setForeground(Color.BLUE);
		lblVentanaDeTransferencias.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVentanaDeTransferencias.setBounds(85, 36, 230, 29);
		contentPanel.add(lblVentanaDeTransferencias);

		comboBoxEtiquetas = new JComboBox();
		comboBoxEtiquetas.setBounds(200, 145, 83, 20);
		for (Etiquetas etiquetas : listaDeEtiqueta) {
			comboBoxEtiquetas.addItem(etiquetas);
		}
		contentPanel.add(comboBoxEtiquetas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Aceptar");
				okButton.setActionCommand(BOTON_ANADIR_TRANSFERENCIA);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand(BOTON_CANCELAR_TRANSFERENCIA);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void asignarControlador(ControladorTransferencias control) {
		okButton.addActionListener(control);
		cancelButton.addActionListener(control);
	}

	@Override
	public void iniciar() {
		pack();
		//setLocationRelativeTo(null);
		setLocation(400, 200);
		setVisible(true);
	}

	@Override
	public Movimientos anadirTransferencia() {
		Cuentas cuentaOrigen = (Cuentas) comboBoxCuentaOrigen.getSelectedItem();
		Cuentas cuentaDestino = (Cuentas) comboBoxCuentaDestino.getSelectedItem();
		Etiquetas etiqueta = (Etiquetas) comboBoxEtiquetas.getSelectedItem();
		Double valor = Double.valueOf(textFieldValor.getText().replace(",", "."));
		Date fecha = dateChooser.getDate();
		String comentario = textFieldComentario.getText();

		Movimientos movimiento = new Movimientos(cuentaOrigen,cuentaDestino, etiqueta, listaDeTipos.get(2), valor, fecha, comentario);
		this.limpiarCampos();
		return movimiento;
	}
	
	@Override
	public void limpiarCampos(){
		textFieldValor.setText("");
		dateChooser.setDate(new Date());
		textFieldComentario.setText("");
		JOptionPane.showMessageDialog(null, "Transferencia realizada correctamente", "Transferencia realizada", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public boolean comprobarCampos(){
		if(textFieldValor.getText().isEmpty()&& dateChooser.getDate()==null){
			JOptionPane.showMessageDialog(null, "El valor de la transferencia y la fecha no son correctos", "Error campos", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(textFieldValor.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "El valor del gasto no es correcto", "Error campos", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(dateChooser.getDate()==null){
			JOptionPane.showMessageDialog(null, "La fecha introducida no es correcta", "Error campos", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
		
	}
	
	@Override
	public void cerrarVentana(){
		this.dispose();
	}
	
}
