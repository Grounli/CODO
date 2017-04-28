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
	private JLabel lblNewLabel;

	public VentanaPrincipal() {
		
		super("Codo - Tu Contabilidad Doméstica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 279);
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
				btnPrevisiones = new JButton("Previsiones");
				btnPrevisiones.setActionCommand(BOTON_PREVISIONES);

		btnCuentas = new JButton("Cuentas");
		btnCuentas.setActionCommand(BOTON_CUENTAS);
		
				btnMovimientos = new JButton("Movimientos");
				btnMovimientos.setActionCommand(BOTON_MOVIMIENTOS);

		btnIngresos = new JButton("Ingresos");
		btnIngresos.setActionCommand(BOTON_INGRESOS);

		btnGastos = new JButton("Gastos");
		btnGastos.setActionCommand(BOTON_GASTOS);

		btnTransferencias = new JButton("Transferencias");
		btnTransferencias.setActionCommand(BOTON_TRANSFERENCIAS);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnCuentas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPrevisiones, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
						.addComponent(btnIngresos, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnTransferencias, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGastos, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnMovimientos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(77)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(126, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnPrevisiones)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCuentas)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMovimientos)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnIngresos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGastos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTransferencias)))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Informacion.png"));
		lblNewLabel.setBounds(0, 0, 183, 157);
		panel.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
		
		
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
