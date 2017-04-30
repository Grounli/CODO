package com.codo.vista.ingresos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorIngresos;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.ingresos.InterfazIngresos;
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
	private JButton cancelButton;
	private List<Tipos> listaDeTipos;

	public VentanaIngresos(List<Cuentas> listaDeCuentas, List<Etiquetas> listaDeEtiquetaDeIngresos,
			List<Tipos> listaDeTipos) {
		this.listaDeTipos = listaDeTipos;

		setMaximumSize(new Dimension(400, 400));
		setMinimumSize(new Dimension(400, 400));
		setTitle("Ingresos");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBackground(Color.LIGHT_GRAY);
		this.listaDeTipos = listaDeTipos;
		setPreferredSize(new Dimension(400, 400));
		setTitle("Panel Ingresos");
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

		comboBoxCuenta = new JComboBox<Cuentas>();
		comboBoxCuenta.setBounds(199, 92, 95, 20);
		for (Cuentas cuenta : listaDeCuentas) {
			comboBoxCuenta.addItem(cuenta);
		}
		contentPanel.add(comboBoxCuenta);

		comboBoxEtiquetas = new JComboBox<Etiquetas>();
		comboBoxEtiquetas.setBounds(199, 136, 95, 20);
		for (Etiquetas etiqueta : listaDeEtiquetaDeIngresos) {
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

		JLabel lblVentanaDeGastos = new JLabel("Ventana de ingresos:");
		lblVentanaDeGastos.setForeground(Color.BLUE);
		lblVentanaDeGastos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVentanaDeGastos.setBounds(119, 33, 175, 29);
		contentPanel.add(lblVentanaDeGastos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Añadir Ingreso");
				okButton.setActionCommand(BOTON_ANADIR_INGRESO);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand(BOTON_CANCELAR_INGRESO);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void asignarControlador(ControladorIngresos control) {
		okButton.addActionListener(control);
		cancelButton.addActionListener(control);
	}

	@Override
	public Movimientos anadirIngreso() {
		Cuentas cuenta = (Cuentas) comboBoxCuenta.getSelectedItem();
		Etiquetas etiqueta = (Etiquetas) comboBoxEtiquetas.getSelectedItem();
		Double valor = Double.valueOf(textFieldValor.getText().replace(",", "."));
		Date fecha = dateChooser.getDate();
		String comentario = textFieldComentario.getText();
		Movimientos movimiento = new Movimientos(cuenta, etiqueta, listaDeTipos.get(0), valor, fecha, comentario);
		this.limpiarCampos();
		return movimiento;
	}

	@Override
	public void limpiarCampos() {
		textFieldValor.setText("");
		dateChooser.setDate(new Date());
		textFieldComentario.setText("");
		JOptionPane.showMessageDialog(null, "Ingreso realizado correctamente", "Ingreso realizado",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public boolean comprobarCampos() {

		if (textFieldValor.getText().isEmpty() && dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "El valor del ingreso y la fecha no son correctos.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (textFieldValor.getText().isEmpty()) {
			System.out.println(textFieldValor.getText());
			JOptionPane.showMessageDialog(null, "El valor del ingreso no es correcto.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "La fecha introducida no es correcta.", "Error campos",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		else
			return true;
	}

	@Override
	public void iniciar() {
		pack();
		setLocation(400, 200);
		setVisible(true);
	}
}