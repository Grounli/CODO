package com.codo.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame implements InterfazPrincipal {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
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
	private JPanel panelBotones;

	public VentanaPrincipal() {
		
		super("Codo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 215, 266);
		setPreferredSize(new Dimension(200,300));;

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
		contentPane.setBorder(new EmptyBorder(5, 10, 5, 5));
		setContentPane(contentPane);
						contentPane.setLayout(new BorderLayout(0, 0));
										
										panelBotones = new JPanel();
										contentPane.add(panelBotones, BorderLayout.CENTER);
										GridBagLayout gbl_panelBotones = new GridBagLayout();
										gbl_panelBotones.columnWidths = new int[] {160, 1};
										gbl_panelBotones.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 6};
										gbl_panelBotones.columnWeights = new double[]{0.0, Double.MIN_VALUE};
										gbl_panelBotones.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
										panelBotones.setLayout(gbl_panelBotones);
										
												btnCuentas = new JButton("Cuentas");
												GridBagConstraints gbc_btnCuentas = new GridBagConstraints();
												gbc_btnCuentas.fill = GridBagConstraints.HORIZONTAL;
												gbc_btnCuentas.insets = new Insets(0, 0, 5, 0);
												gbc_btnCuentas.gridx = 0;
												gbc_btnCuentas.gridy = 0;
												panelBotones.add(btnCuentas, gbc_btnCuentas);
												btnCuentas.setActionCommand(BOTON_CUENTAS);
												
														btnIngresos = new JButton("Ingresos");
														GridBagConstraints gbc_btnIngresos = new GridBagConstraints();
														gbc_btnIngresos.fill = GridBagConstraints.HORIZONTAL;
														gbc_btnIngresos.insets = new Insets(0, 0, 5, 0);
														gbc_btnIngresos.gridx = 0;
														gbc_btnIngresos.gridy = 1;
														panelBotones.add(btnIngresos, gbc_btnIngresos);
														btnIngresos.setActionCommand(BOTON_INGRESOS);
														
																btnGastos = new JButton("Gastos");
																btnGastos.addActionListener(new ActionListener() {
																	public void actionPerformed(ActionEvent e) {
																	}
																});
																GridBagConstraints gbc_btnGastos = new GridBagConstraints();
																gbc_btnGastos.fill = GridBagConstraints.HORIZONTAL;
																gbc_btnGastos.insets = new Insets(0, 0, 5, 0);
																gbc_btnGastos.gridx = 0;
																gbc_btnGastos.gridy = 2;
																panelBotones.add(btnGastos, gbc_btnGastos);
																btnGastos.setActionCommand(BOTON_GASTOS);
																
																		btnTransferencias = new JButton("Transferencias");
																		
																		GridBagConstraints gbc_btnTransferencias = new GridBagConstraints();
																		gbc_btnTransferencias.fill = GridBagConstraints.HORIZONTAL;
																		gbc_btnTransferencias.insets = new Insets(0, 0, 5, 0);
																		gbc_btnTransferencias.gridx = 0;
																		gbc_btnTransferencias.gridy = 3;
																		panelBotones.add(btnTransferencias, gbc_btnTransferencias);
																		btnTransferencias.setActionCommand(BOTON_TRANSFERENCIAS);
																		
																				btnMovimientos = new JButton("Movimientos");
																				GridBagConstraints gbc_btnMovimientos = new GridBagConstraints();
																				gbc_btnMovimientos.fill = GridBagConstraints.HORIZONTAL;
																				gbc_btnMovimientos.insets = new Insets(0, 0, 5, 0);
																				gbc_btnMovimientos.gridx = 0;
																				gbc_btnMovimientos.gridy = 4;
																				panelBotones.add(btnMovimientos, gbc_btnMovimientos);
																				btnMovimientos.setActionCommand(BOTON_MOVIMIENTOS);
																				
																						btnPrevisiones = new JButton("Previsiones");
																						GridBagConstraints gbc_btnPrevisiones = new GridBagConstraints();
																						gbc_btnPrevisiones.fill = GridBagConstraints.HORIZONTAL;
																						gbc_btnPrevisiones.gridx = 0;
																						gbc_btnPrevisiones.gridy = 5;
																						panelBotones.add(btnPrevisiones, gbc_btnPrevisiones);
																						btnPrevisiones.setActionCommand(BOTON_PREVISIONES);
		
		
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
		//setLocationRelativeTo(null);
		setLocation(200, 200);
		setVisible(true);
	}
}
