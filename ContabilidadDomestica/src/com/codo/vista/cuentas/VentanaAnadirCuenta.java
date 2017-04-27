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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Monedas;
import com.codo.vista.interfaces.InterfazVentanaAnadirCuenta;

public class VentanaAnadirCuenta extends JDialog implements InterfazVentanaAnadirCuenta {

	private static final long serialVersionUID = 1L;
	private static final int POSICION_HORIZONTAL = 100;
	private static final int POSICION_VERTICAL = 100;
	private static final int ANCHURA_MAXIMA = 450;
	private static final int ALTURA_MAXIMA = 300;
	private final JPanel contentPanel = new JPanel();
	private JTextField campoNombre;
	private JTextField campoSaldo;
	private JTextField campoDescripcion;
	private JComboBox<Monedas> cajaMoneda;
	private JButton btnConfirmar;
	private JButton btnRegresar;

	public VentanaAnadirCuenta(List<Monedas> listaDeMonedas) {
		setTitle("Cuentas - Añadir");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(POSICION_HORIZONTAL, POSICION_VERTICAL, ANCHURA_MAXIMA, ALTURA_MAXIMA);
		setPreferredSize(new Dimension(ANCHURA_MAXIMA, ALTURA_MAXIMA));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		// LABELS

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(128, 58, 47, 14);
		contentPanel.add(lblNombre);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaldo.setBounds(138, 89, 36, 14);
		contentPanel.add(lblSaldo);

		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoneda.setBounds(120, 120, 55, 14);
		contentPanel.add(lblMoneda);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcion.setBounds(110, 151, 65, 14);
		contentPanel.add(lblDescripcion);

		// CAMPOS PARA AÑADIR

		campoNombre = new JTextField();
		campoNombre.setBounds(185, 55, 86, 20);
		contentPanel.add(campoNombre);
		campoNombre.setColumns(10);

		campoSaldo = new JTextField();
		campoSaldo.setBounds(185, 86, 86, 20);
		contentPanel.add(campoSaldo);
		campoSaldo.setColumns(10);

		cajaMoneda = new JComboBox();
		cajaMoneda.setBounds(185, 117, 158, 20);
		for (Monedas moneda : listaDeMonedas) {
			cajaMoneda.addItem(moneda);
		}
		contentPanel.add(cajaMoneda);

		campoDescripcion = new JTextField();
		campoDescripcion.setBounds(185, 148, 86, 20);
		contentPanel.add(campoDescripcion);
		campoDescripcion.setColumns(10);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setActionCommand(BOTON_CONFIRMAR_ANADIR_CUENTA);
			buttonPane.add(btnConfirmar);
			getRootPane().setDefaultButton(btnConfirmar);
		}
		{
			btnRegresar = new JButton("Regresar");
			btnRegresar.setActionCommand(BOTON_REGRESAR_ANADIR_CUENTA);
			buttonPane.add(btnRegresar);
		}
	}

	@Override
	public void asignarControlador(ControladorCuentas control) {
		btnConfirmar.addActionListener(control);
		btnRegresar.addActionListener(control);
	}

	@Override
	public Cuentas leerCamposAnadirCuenta() {
		Monedas moneda = (Monedas) cajaMoneda.getSelectedItem();
		String nombre = campoNombre.getText();
		Double saldo = Double.parseDouble(campoSaldo.getText());
		String descripcion = campoDescripcion.getText();
		Cuentas cuenta = new Cuentas(moneda, nombre, saldo, descripcion);
		return cuenta;
	}

	@Override
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
