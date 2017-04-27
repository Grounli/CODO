package com.codo.vista.ingresos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorIngresos;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.InterfazIngresos;
import com.toedter.calendar.JDateChooser;

public class VentanaIngresos extends JDialog implements InterfazIngresos {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldValor;
	private JTextField textFieldComentario;
	private JComboBox<Cuentas> comboBoxCuenta;
	private JComboBox<Etiquetas> comboBoxEtiquetas;
	private JDateChooser dateChooser;
	private JButton okButton;
	private List<Tipos> listaDeTipos;

	public VentanaIngresos(List<Cuentas> listaDeCuentas, List<Etiquetas> listaDeEtiqueta, List<Tipos> listaDeTipos) {
		this.listaDeTipos = listaDeTipos;

		setTitle("Ingresos");
		setPreferredSize(new Dimension(500, 500));
		setBounds(100, 100, 450, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textFieldValor = new JTextField();
		textFieldValor.setBounds(170, 117, 86, 20);
		contentPanel.add(textFieldValor);
		textFieldValor.setColumns(10);

		textFieldComentario = new JTextField();
		textFieldComentario.setBounds(170, 193, 86, 20);
		contentPanel.add(textFieldComentario);
		textFieldComentario.setColumns(10);

		comboBoxCuenta = new JComboBox();
		comboBoxCuenta.setBounds(170, 36, 95, 20);
		for (Cuentas cuenta : listaDeCuentas) {
			comboBoxCuenta.addItem(cuenta);
		}
		contentPanel.add(comboBoxCuenta);

		comboBoxEtiquetas = new JComboBox();
		comboBoxEtiquetas.setBounds(170, 77, 95, 20);
		for (Etiquetas etiqueta : listaDeEtiqueta) {
			comboBoxEtiquetas.addItem(etiqueta);
		}
		contentPanel.add(comboBoxEtiquetas);

		JLabel lblCuenta = new JLabel("Cuenta");
		lblCuenta.setBounds(75, 39, 46, 14);
		contentPanel.add(lblCuenta);

		JLabel lblNewLabel = new JLabel("Etiquetas");
		lblNewLabel.setBounds(75, 80, 46, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(75, 120, 46, 14);
		contentPanel.add(lblValor);

		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setBounds(75, 196, 78, 14);
		contentPanel.add(lblComentario);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(170, 158, 95, 20);
		contentPanel.add(dateChooser);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(75, 158, 46, 14);
		contentPanel.add(lblFecha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Aceptar");
				okButton.setActionCommand(BOTON_ANADIR_INGRESO);
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
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void asignarControlador(ControladorIngresos control) {
		okButton.addActionListener(control);
	}

	@Override
	public Movimientos anadirIngreso() {
		Cuentas cuenta = (Cuentas) comboBoxCuenta.getSelectedItem();
		Etiquetas etiqueta = (Etiquetas) comboBoxEtiquetas.getSelectedItem();
		Double valor = Double.valueOf(textFieldValor.getText());
		Date fecha = dateChooser.getDate();
		String comentario = textFieldComentario.getText();
		Movimientos movimiento = new Movimientos(cuenta, etiqueta, listaDeTipos.get(0), valor, fecha, comentario);

		return movimiento;
	}
}