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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		// LABELS

		JLabel lblNombre = new JLabel("Nombre:");

		JLabel lblSaldo = new JLabel("Saldo:");

		JLabel lblMoneda = new JLabel("Moneda:");

		JLabel lblDescripcion = new JLabel("Descripción:");

		// CAMPOS PARA AÑADIR

		campoNombre = new JTextField();
		campoNombre.setColumns(10);

		campoSaldo = new JTextField();
		campoSaldo.setColumns(10);

		cajaMoneda = new JComboBox();
		for (Monedas moneda : listaDeMonedas) {
			cajaMoneda.addItem(moneda);
		}

		campoDescripcion = new JTextField();
		campoDescripcion.setColumns(10);
		
		// LAYOUT
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(135)
					.addComponent(lblNombre)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(146)
					.addComponent(lblSaldo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoSaldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(134)
					.addComponent(lblMoneda)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cajaMoneda, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(118)
					.addComponent(lblDescripcion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoSaldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSaldo))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cajaMoneda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoneda))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescripcion)))
		);
		contentPanel.setLayout(gl_contentPanel);

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
