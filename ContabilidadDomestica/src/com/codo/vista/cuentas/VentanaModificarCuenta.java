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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Monedas;
import com.codo.vista.interfaces.InterfazVentanaModificarCuenta;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VentanaModificarCuenta extends JDialog implements InterfazVentanaModificarCuenta {

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

	public VentanaModificarCuenta(List<Monedas> listaDeMonedas) {
		setTitle("Cuentas - Modificar");
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
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(128)
							.addComponent(lblMoneda)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cajaMoneda, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(112)
							.addComponent(lblDescripcion)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(campoDescripcion))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(129)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(8)
									.addComponent(lblSaldo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(campoSaldo))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(campoNombre)))))
					.addGap(158))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(campoNombre))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoSaldo)
						.addComponent(lblSaldo))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cajaMoneda)
						.addComponent(lblMoneda))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoDescripcion)
						.addComponent(lblDescripcion))
					.addGap(55))
		);
		contentPanel.setLayout(gl_contentPanel);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setActionCommand(BOTON_CONFIRMAR_MODIFICAR_CUENTA);
			buttonPane.add(btnConfirmar);
			getRootPane().setDefaultButton(btnConfirmar);
		}
		{
			btnRegresar = new JButton("Cancelar");
			btnRegresar.setActionCommand(BOTON_REGRESAR_MODIFICAR_CUENTA);
			buttonPane.add(btnRegresar);
		}
	}

	@Override
	public void asignarControlador(ControladorCuentas control) {
		btnConfirmar.addActionListener(control);
		btnRegresar.addActionListener(control);
	}

	@Override
	public void rellenarCampos(Cuentas cuenta) {
		this.campoNombre.setText(cuenta.getNombre());
		this.campoSaldo.setText(String.valueOf(cuenta.getSaldo()));
		this.campoDescripcion.setText(cuenta.getDescripcion());
	}

	public Cuentas actualizarCuentas(Cuentas cuenta) {
		cuenta.setNombre(campoNombre.getText());
		cuenta.setSaldo(Double.valueOf(campoSaldo.getText()));
		cuenta.setMonedas((Monedas) cajaMoneda.getSelectedItem());
		cuenta.setDescripcion(campoDescripcion.getText());
		return cuenta;
	}

	@Override
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
