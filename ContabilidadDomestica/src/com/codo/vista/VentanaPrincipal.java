package com.codo.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorPrincipal;
import com.codo.vista.interfaces.InterfazPrincipal;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaPrincipal extends JFrame implements InterfazPrincipal {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JButton btnCuentas;
	private JButton btnMovimientos;
	private JButton btnPrevisiones;
	private JButton btnIngresos;
	private JButton btnGastos;
	private JButton btnTransferencias;

	private JMenuBar barraMenu;
	private JMenu menuArchivo;
	private JMenuItem menuSobre;
	private JMenu menuAnadir;
	private JMenuItem menuEtiquetas;

	public VentanaPrincipal() {
		super("Codo - Tu Contabilidad Doméstica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);

		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);

		menuArchivo = new JMenu("Archivo");
		barraMenu.add(menuArchivo);

		menuSobre = new JMenuItem("Sobre");
		menuSobre.setActionCommand(BOTON_SOBRE);
		menuArchivo.add(menuSobre);

		menuAnadir = new JMenu("Añadir");
		barraMenu.add(menuAnadir);

		menuEtiquetas = new JMenuItem("Etiquetas");
		menuEtiquetas.setActionCommand(BOTON_ETIQUETAS);
		menuAnadir.add(menuEtiquetas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		btnCuentas = new JButton("Cuentas");
		btnCuentas.setActionCommand(BOTON_CUENTAS);
		GridBagConstraints gbc_btnCuentas = new GridBagConstraints();
		gbc_btnCuentas.insets = new Insets(0, 0, 5, 5);
		gbc_btnCuentas.gridx = 1;
		gbc_btnCuentas.gridy = 2;
		contentPane.add(btnCuentas, gbc_btnCuentas);

		btnMovimientos = new JButton("Movimientos");
		btnMovimientos.setActionCommand(BOTON_MOVIMIENTOS);
		GridBagConstraints gbc_btnMovimientos = new GridBagConstraints();
		gbc_btnMovimientos.insets = new Insets(0, 0, 5, 5);
		gbc_btnMovimientos.gridx = 4;
		gbc_btnMovimientos.gridy = 2;
		contentPane.add(btnMovimientos, gbc_btnMovimientos);

		btnPrevisiones = new JButton("Previsiones");
		btnPrevisiones.setActionCommand(BOTON_PREVISIONES);
		GridBagConstraints gbc_btnPrevisiones = new GridBagConstraints();
		gbc_btnPrevisiones.insets = new Insets(0, 0, 5, 0);
		gbc_btnPrevisiones.gridx = 7;
		gbc_btnPrevisiones.gridy = 2;
		contentPane.add(btnPrevisiones, gbc_btnPrevisiones);

		btnIngresos = new JButton("Ingresos");
		btnIngresos.setActionCommand(BOTON_INGRESOS);
		GridBagConstraints gbc_btnIngresos = new GridBagConstraints();
		gbc_btnIngresos.insets = new Insets(0, 0, 0, 5);
		gbc_btnIngresos.gridx = 1;
		gbc_btnIngresos.gridy = 5;
		contentPane.add(btnIngresos, gbc_btnIngresos);

		btnGastos = new JButton("Gastos");
		btnGastos.setActionCommand(BOTON_GASTOS);
		GridBagConstraints gbc_btnGastos = new GridBagConstraints();
		gbc_btnGastos.insets = new Insets(0, 0, 0, 5);
		gbc_btnGastos.gridx = 4;
		gbc_btnGastos.gridy = 5;
		contentPane.add(btnGastos, gbc_btnGastos);

		btnTransferencias = new JButton("Transferencias");
		btnTransferencias.setActionCommand(BOTON_TRANSFERENCIAS);
		GridBagConstraints gbc_btnTransferencias = new GridBagConstraints();
		gbc_btnTransferencias.gridx = 7;
		gbc_btnTransferencias.gridy = 5;
		contentPane.add(btnTransferencias, gbc_btnTransferencias);
	}

	@Override
	public void asignarControlador(ControladorPrincipal control) {
		btnCuentas.addActionListener(control);
		btnMovimientos.addActionListener(control);
		btnPrevisiones.addActionListener(control);
		btnIngresos.addActionListener(control);
		btnGastos.addActionListener(control);
		btnTransferencias.addActionListener(control);
		menuEtiquetas.addActionListener(control);
		menuSobre.addActionListener(control);
	}

	@Override
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
