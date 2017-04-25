package com.codo.vista.cuentas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorPrincipal;
import com.codo.vista.interfaces.InterfazPrincipal;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;

public class VentanaAnadirCuenta extends JDialog implements InterfazPrincipal {

	private final JPanel contentPanel = new JPanel();

	private JTextField campoSaldo;
	private JTextField textField_2;
	private JTextField campoNombre;
	
	public VentanaAnadirCuenta() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		setPreferredSize(new Dimension(450, 300));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JComboBox boxCuentas = new JComboBox();
		boxCuentas.setBounds(191, 110, 158, 20);
		contentPanel.add(boxCuentas);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(119, 44, 51, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(119, 85, 51, 14);
		contentPanel.add(lblSaldo);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setBounds(117, 113, 51, 14);
		contentPanel.add(lblMoneda);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(102, 144, 65, 14);
		contentPanel.add(lblDescripcion);
		
		campoSaldo = new JTextField();
		campoSaldo.setBounds(190, 82, 86, 20);
		contentPanel.add(campoSaldo);
		campoSaldo.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 141, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(190, 41, 86, 20);
		contentPanel.add(campoNombre);
		campoNombre.setColumns(10);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("OK");
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

	@Override
	public void asignarControlador(ControladorPrincipal control) {
		// TODO Auto-generated method stub

	}

	@Override
	public void arranca() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
