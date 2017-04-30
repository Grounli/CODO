package com.codo.vista.previsiones;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorPrevisiones;
import com.codo.vista.interfaces.previsiones.InterfazPrevisiones;
import com.codo.vista.interfaces.previsiones.InterfazVentanaAnadirPrevision;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Calendar;

public class VentanaAnadirPrevision extends JDialog implements InterfazVentanaAnadirPrevision{

	private static final long serialVersionUID = 1L;
	private static final int ANCHURA_MINIMA_VENTANA =450;
	private static final int ALTURA_MINIMA_VENTANA = 300;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JPanel panelComponentes;
	private JLabel lblaCuentaDeOrigen;
	private JLabel lblCuentaDeDestino;
	private JLabel lblEtiqueta;
	private JLabel lblValor;
	private JLabel lblFecha;
	private JLabel lblDescripcion;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JFormattedTextField formattedTextField;
	private JDateChooser dateChooser;
	private JTextField textField;

	public VentanaAnadirPrevision() {

		// CONFIGURACIÓN BASICA DE LA VENTANA
		setTitle("Previsiones - Añadir");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		setMinimumSize(new Dimension(ANCHURA_MINIMA_VENTANA, ALTURA_MINIMA_VENTANA));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panelComponentes = new JPanel();
			panelComponentes.setMinimumSize(new Dimension(0, 0));
			panelComponentes.setPreferredSize(new Dimension(0, 0));
			contentPanel.add(panelComponentes, BorderLayout.CENTER);
			panelComponentes.setLayout(null);
			
			JPanel panelIzquierdo = new JPanel();
			panelIzquierdo.setBounds(61, 11, 126, 189);
			panelIzquierdo.setOpaque(false);
			panelIzquierdo.setPreferredSize(new Dimension(100, 150));
			panelComponentes.add(panelIzquierdo);
			panelIzquierdo.setLayout(new GridLayout(7, 1, 0, 5));
			
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTipo.setHorizontalTextPosition(SwingConstants.RIGHT);
			panelIzquierdo.add(lblTipo);
			{
				lblaCuentaDeOrigen = new JLabel("Cuenta de Origen:");
				lblaCuentaDeOrigen.setHorizontalAlignment(SwingConstants.RIGHT);
				lblaCuentaDeOrigen.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblaCuentaDeOrigen);
			}
			{
				lblCuentaDeDestino = new JLabel("Cuenta de Destino:");
				lblCuentaDeDestino.setHorizontalAlignment(SwingConstants.RIGHT);
				lblCuentaDeDestino.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblCuentaDeDestino);
			}
			{
				lblEtiqueta = new JLabel("Etiqueta:");
				lblEtiqueta.setHorizontalAlignment(SwingConstants.RIGHT);
				lblEtiqueta.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblEtiqueta);
			}
			{
				lblValor = new JLabel("Valor:");
				lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
				lblValor.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblValor);
			}
			{
				lblFecha = new JLabel("Fecha:");
				lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFecha.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblFecha);
			}
			{
				lblDescripcion = new JLabel("Descripción:");
				lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
				lblDescripcion.setHorizontalTextPosition(SwingConstants.RIGHT);
				panelIzquierdo.add(lblDescripcion);
			}
			
			JPanel panelDerecho = new JPanel();
			panelDerecho.setBounds(197, 11, 100, 189);
			panelDerecho.setMinimumSize(new Dimension(0, 0));
			panelDerecho.setPreferredSize(new Dimension(100, 240));
			panelComponentes.add(panelDerecho);
			panelDerecho.setLayout(new GridLayout(7, 1, 0, 5));
			{
				comboBox = new JComboBox();
				panelDerecho.add(comboBox);
			}
			{
				comboBox_1 = new JComboBox();
				panelDerecho.add(comboBox_1);
			}
			{
				comboBox_2 = new JComboBox();
				panelDerecho.add(comboBox_2);
			}
			{
				comboBox_3 = new JComboBox();
				panelDerecho.add(comboBox_3);
			}
			{
				formattedTextField = new JFormattedTextField();
				panelDerecho.add(formattedTextField);
			}
			{
				dateChooser = new JDateChooser();
				panelDerecho.add(dateChooser);
			}
			{
				textField = new JTextField();
				panelDerecho.add(textField);
				textField.setColumns(10);
			}
		}
		
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

	@Override
	public void asignarControlador(ControladorPrevisiones control) {
		btnAceptar.addActionListener(control);
		btnCancelar.addActionListener(control);
	}
	
	@Override
	public void iniciar(InterfazPrevisiones vistaPrevision) {
		pack();
		setLocationRelativeTo((Component) vistaPrevision);
		setVisible(true);
	}
}
