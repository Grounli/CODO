package com.codo.vista.transferencias;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorTransferencias;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.InterfazTransferencias;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class VentanaTransferencias extends JDialog implements InterfazTransferencias {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldValor;
	private JTextField textFieldComentario;
	private JComboBox comboBoxCuentaOrigen;
	private JComboBox comboBoxCuentaDestino;
	private JDateChooser dateChooser;
	private JComboBox comboBoxEtiquetas;
	private JButton okButton;
	private List<Tipos> listaDeTipos;

	public VentanaTransferencias(List<Cuentas> listaDeCuentas, List<Etiquetas> listaDeEtiqueta,
			List<Tipos> listaDeTipos) {
		this.listaDeTipos=listaDeTipos;
		
		setTitle("Transferencias");
		setBounds(100, 100, 450, 300);
		setPreferredSize(new Dimension(450, 300));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cuenta origen");
			lblNewLabel.setBounds(28, 11, 83, 32);
			contentPanel.add(lblNewLabel);
		}

		JLabel lblCuentaDestino = new JLabel("Cuenta destino");
		lblCuentaDestino.setBounds(28, 40, 83, 22);
		contentPanel.add(lblCuentaDestino);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(28, 101, 46, 14);
		contentPanel.add(lblValor);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(28, 126, 46, 14);
		contentPanel.add(lblFecha);

		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setBounds(28, 151, 83, 22);
		contentPanel.add(lblComentario);

		comboBoxCuentaOrigen = new JComboBox();
		comboBoxCuentaOrigen.setBounds(130, 17, 83, 20);
		for (Cuentas cuenta : listaDeCuentas) {
			comboBoxCuentaOrigen.addItem(cuenta);
		}
		contentPanel.add(comboBoxCuentaOrigen);

		comboBoxCuentaDestino = new JComboBox();
		comboBoxCuentaDestino.setBounds(130, 41, 83, 20);
		for (Cuentas cuenta : listaDeCuentas) {
			comboBoxCuentaDestino.addItem(cuenta);
		}
		contentPanel.add(comboBoxCuentaDestino);

		textFieldValor = new JTextField();
		textFieldValor.setBounds(127, 98, 86, 20);
		contentPanel.add(textFieldValor);
		textFieldValor.setColumns(10);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(127, 126, 95, 20);
		contentPanel.add(dateChooser);

		textFieldComentario = new JTextField();
		textFieldComentario.setBounds(127, 152, 86, 20);
		contentPanel.add(textFieldComentario);
		textFieldComentario.setColumns(10);

		JLabel lblEtiquetas = new JLabel("Etiquetas");
		lblEtiquetas.setBounds(28, 73, 46, 14);
		contentPanel.add(lblEtiquetas);

		comboBoxEtiquetas = new JComboBox();
		comboBoxEtiquetas.setBounds(130, 72, 83, 20);
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
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void asignarControlador(ControladorTransferencias control) {
		okButton.addActionListener(control);
	}

	@Override
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public Movimientos anadirTransferencia() {
		Cuentas cuentaOrigen = (Cuentas) comboBoxCuentaOrigen.getSelectedItem();
		Cuentas cuentaDestino = (Cuentas) comboBoxCuentaDestino.getSelectedItem();
		Etiquetas etiqueta = (Etiquetas) comboBoxEtiquetas.getSelectedItem();
		Double valor = Double.valueOf(textFieldValor.getText());
		Date fecha = dateChooser.getDate();
		String comentario = textFieldComentario.getText();

		Movimientos movimiento = new Movimientos(cuentaOrigen,cuentaDestino, etiqueta, listaDeTipos.get(2), valor, fecha, comentario);

		return movimiento;
	}
}
