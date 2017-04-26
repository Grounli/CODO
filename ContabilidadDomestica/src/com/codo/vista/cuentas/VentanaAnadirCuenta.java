package com.codo.vista.cuentas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Monedas;
import com.codo.vista.interfaces.InterfazVentanaAnadirCuenta;

public class VentanaAnadirCuenta extends JDialog implements InterfazVentanaAnadirCuenta {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	private JTextField campoSaldo;
	private JTextField campoDescripcion;
	private JTextField campoNombre;
	private JComboBox<Monedas> cajaMoneda;
	private JButton btnCancelar;
	private JButton btnAceptar;

	public VentanaAnadirCuenta(List<Monedas> listaDeMonedas) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		setPreferredSize(new Dimension(450, 300));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// LABELS
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
		
		// CAMPOS PARA AÑADIR
		
		campoNombre = new JTextField();
		campoNombre.setBounds(190, 41, 86, 20);
		contentPanel.add(campoNombre);
		campoNombre.setColumns(10);
		
		campoSaldo = new JTextField();
		campoSaldo.setBounds(190, 82, 86, 20);
		contentPanel.add(campoSaldo);
		campoSaldo.setColumns(10);
		
		cajaMoneda = new JComboBox();
		cajaMoneda.setBounds(191, 110, 158, 20);
		for (Monedas moneda : listaDeMonedas){
			cajaMoneda.addItem(moneda);
		}
		contentPanel.add(cajaMoneda);

		campoDescripcion = new JTextField();
		campoDescripcion.setBounds(190, 141, 86, 20);
		contentPanel.add(campoDescripcion);
		campoDescripcion.setColumns(10);


		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setActionCommand(BOTON_ACEPTAR_ANADIR_CUENTA);
			buttonPane.add(btnAceptar);
			getRootPane().setDefaultButton(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setActionCommand(BOTON_CANCELAR_ANADIR_CUENTA);
			buttonPane.add(btnCancelar);
		}

	}

	@Override
	public void asignarControlador(ControladorCuentas control) {
		btnAceptar.addActionListener(control);
		btnCancelar.addActionListener(control);
	}

	@Override
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public Cuentas anadirCuenta(){
		Monedas moneda = (Monedas) cajaMoneda.getSelectedItem();
		String nombre = campoNombre.getText();
		Double saldo = Double.parseDouble(campoSaldo.getText());
		String descripcion = campoDescripcion.getText();
		Cuentas cuenta = new Cuentas(moneda, nombre, saldo, descripcion);
		return cuenta;
	}

}
