package com.codo.vista.cuentas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;
import com.codo.vista.componentes.ModeloTablaCuentas;
import com.codo.vista.interfaces.InterfazCuentas;

public class VentanaCuentas extends JDialog implements InterfazCuentas {

	private static final long serialVersionUID = 1L;
	private static final int POSICION_HORIZONTAL = 100;
	private static final int POSICION_VERTICAL = 100;
	private static final int ANCHURA_MAXIMA = 450;
	private static final int ALTURA_MAXIMA = 300;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaCuentas;
	private JScrollPane panelDesplazamiento;
	private JButton btnAnadir;
	private JButton btnBorrar;
	private JButton btnModificar;
	private ModeloTablaCuentas mtc;

	public VentanaCuentas() {
		setTitle("Cuentas");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(POSICION_HORIZONTAL, POSICION_VERTICAL, ANCHURA_MAXIMA, ALTURA_MAXIMA);
		setPreferredSize(new Dimension(ANCHURA_MAXIMA, ALTURA_MAXIMA));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		// CONSTRUCCION DE TABLA
		tablaCuentas = new JTable();
		tablaCuentas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaCuentas.setFillsViewportHeight(false);
		tablaCuentas.setRowHeight(30);
		Font f = new Font("Time New Roman", Font.PLAIN, 14);
		tablaCuentas.setFont(f);

		panelDesplazamiento = new JScrollPane(tablaCuentas);
		panelDesplazamiento.setSize(414, 202);
		panelDesplazamiento.setLocation(10, 10);
		panelDesplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelDesplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPanel.add(panelDesplazamiento);

		// BOTONES

		btnAnadir = new JButton("Añadir");
		btnAnadir.setSize(89, 23);
		btnAnadir.setLocation(77, 223);
		btnAnadir.setActionCommand(BOTON_ANADIR_CUENTA);
		contentPanel.add(btnAnadir);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setSize(89, 23);
		btnBorrar.setLocation(176, 223);
		btnBorrar.setActionCommand(BOTON_BORRAR_CUENTA);
		contentPanel.add(btnBorrar);

		btnModificar = new JButton("Modificar");
		btnModificar.setSize(89, 23);
		btnModificar.setLocation(275, 223);
		btnModificar.setActionCommand(BOTON_MODIFICAR_CUENTA);
		contentPanel.add(btnModificar);
	}

	@Override
	public void asignarControlador(ControladorCuentas control) {
		btnAnadir.addActionListener(control);
		btnBorrar.addActionListener(control);
		btnModificar.addActionListener(control);
	}

	@Override
	public void asignarDatosTablaCuentas(List<Cuentas> listaDeCuentas) {
		mtc = new ModeloTablaCuentas();
		mtc.asignarListaDeCuentas(listaDeCuentas);
		tablaCuentas.setModel(mtc);
	}

	@Override
	public Cuentas obtenerTablaCuentas() {

		return mtc.obtenerObjeto(tablaCuentas.getSelectedRow());

	}
	
	
	@Override
	public void iniciar() {
		pack();
		//setLocationRelativeTo(null);
		setLocation(400, 200);
		setVisible(true);
	}
}