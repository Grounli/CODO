package com.codo.vista.transferencias;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorTransferencias;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.InterfazTransferencias;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class VentanaTransferencias extends JDialog implements InterfazTransferencias {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	public VentanaTransferencias(List<Cuentas> listaDeCuentas, List<Etiquetas> listaDeEtiqueta, List<Tipos> listaDeTipos) {
		setTitle("Transferencias");
		setBounds(100, 100, 450, 359);
		setPreferredSize(new Dimension(500,500));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cuenta origen");
			lblNewLabel.setBounds(75, 37, 95, 32);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblCuentaDestino = new JLabel("Cuenta destino");
		lblCuentaDestino.setBounds(75, 80, 95, 22);
		contentPanel.add(lblCuentaDestino);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(75, 149, 46, 14);
		contentPanel.add(lblValor);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(75, 178, 46, 14);
		contentPanel.add(lblFecha);
		
		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setBounds(75, 210, 83, 22);
		contentPanel.add(lblComentario);
		
		JComboBox cuentaOrigen = new JComboBox();
		cuentaOrigen.setBounds(200, 44, 83, 20);
		for (Cuentas cuenta : listaDeCuentas) {
			cuentaOrigen.addItem(cuenta);
		}
		contentPanel.add(cuentaOrigen);
		
		JComboBox cuentaDestino = new JComboBox();
		cuentaDestino.setBounds(200, 82, 83, 20);
		for (Cuentas cuenta : listaDeCuentas) {
			cuentaDestino.addItem(cuenta);
		}
		contentPanel.add(cuentaDestino);
		
		textField = new JTextField();
		textField.setBounds(200, 146, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(200, 178, 95, 20);
		contentPanel.add(dateChooser);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 211, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEtiquetas = new JLabel("Etiquetas");
		lblEtiquetas.setBounds(75, 113, 46, 14);
		contentPanel.add(lblEtiquetas);
		
		JComboBox comboBoxEtiquetas = new JComboBox();
		comboBoxEtiquetas.setBounds(200, 113, 83, 20);
		for (Etiquetas etiquetas : listaDeEtiqueta) {
			comboBoxEtiquetas.addItem(etiquetas);
		}
		contentPanel.add(comboBoxEtiquetas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void asignarControlador(ControladorTransferencias control) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);		
	}
}
