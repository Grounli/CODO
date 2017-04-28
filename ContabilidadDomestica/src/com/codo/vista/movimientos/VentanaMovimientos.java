package com.codo.vista.movimientos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.codo.controlador.ControladorMovimientos;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.componentes.ModeloTablaMovimientos;
import com.codo.vista.interfaces.InterfazMovimientos;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class VentanaMovimientos extends JDialog implements InterfazMovimientos {

	private static final long serialVersionUID = 1L;
	private static final int POSICION_HORIZONTAL = 100;
	private static final int POSICION_VERTICAL = 100;
	private static final int ANCHURA_MAXIMA = 500;
	private static final int ALTURA_MAXIMA = 400;
	private final JPanel contentPane = new JPanel();
	private JTable tablaMovimientos;
	private JScrollPane panelDesplazamiento;
	private ModeloTablaMovimientos mtm;
	private JLabel lblFiltros;
	private JLabel lblCuentas;
	private JLabel lblTipos;
	private JLabel lblEtiquetas;
	private JLabel lblFechaDesde;
	private JLabel lblFechaHasta;
	private JComboBox<Cuentas> cajaCuentas;
	private JComboBox<Tipos> cajaTipos;
	private JComboBox<Etiquetas> cajaEtiquetas;
	private JDateChooser fechaDesde;
	private JDateChooser fechaHasta;
	private JButton btnConsultar;
	private JButton btnRevertir;

	public VentanaMovimientos(List<Cuentas> listaDeCuentas, List<Etiquetas> listaDeEtiquetas,
			List<Tipos> listaDeTipos) {
		setResizable(false);
		setTitle("Movimientos");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(POSICION_HORIZONTAL, POSICION_VERTICAL, ANCHURA_MAXIMA, ALTURA_MAXIMA);
		setPreferredSize(new Dimension(ANCHURA_MAXIMA, ALTURA_MAXIMA));
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);

		// CONSTRUCCION DE TABLA
		tablaMovimientos = new JTable();
		tablaMovimientos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaMovimientos.setFillsViewportHeight(false);
		tablaMovimientos.setRowHeight(30);
		Font f = new Font("Time New Roman", Font.PLAIN, 12);
		tablaMovimientos.setFont(f);

		panelDesplazamiento = new JScrollPane(tablaMovimientos);
		panelDesplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelDesplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// LABELS
		lblFiltros = new JLabel("Filtros:");
		lblCuentas = new JLabel("Cuentas:");
		lblTipos = new JLabel("Tipos:");
		lblEtiquetas = new JLabel("Etiquetas:");
		lblFechaDesde = new JLabel("Fecha Desde:");
		lblFechaHasta = new JLabel("Fecha Hasta:");

		// COMBOBOXS
		cajaCuentas = new JComboBox();
		for (Cuentas cuenta : listaDeCuentas) {
			cajaCuentas.addItem(cuenta);
		}

		cajaTipos = new JComboBox();
		for (Tipos tipo : listaDeTipos) {
			cajaTipos.addItem(tipo);
		}

		cajaEtiquetas = new JComboBox();
		for (Etiquetas etiqueta : listaDeEtiquetas) {
			cajaEtiquetas.addItem(etiqueta);
		}

		// CALENDARIOS
		fechaDesde = new JDateChooser();

		fechaHasta = new JDateChooser();

		// BOTONES
		btnConsultar = new JButton("Consultar");
		btnConsultar.setActionCommand(BOTON_CONSULTAR_MOVIMIENTOS);

		btnRevertir = new JButton("Revertir");
		btnRevertir.setActionCommand(BOTON_REVERTIR_MOVIMIENTO);
		// CONFIGURACION GRUPLAYOUT (AUTOGENERADO)
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(
														panelDesplazamiento, GroupLayout.DEFAULT_SIZE, 414,
														Short.MAX_VALUE)
												.addGroup(gl_contentPane
														.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblTipos)
																.addComponent(lblEtiquetas).addComponent(lblCuentas)
																.addComponent(lblFiltros))
														.addGap(4)
														.addGroup(gl_contentPane
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(cajaEtiquetas, 0,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(cajaTipos, Alignment.TRAILING, 0,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(cajaCuentas, Alignment.TRAILING,
																		GroupLayout.PREFERRED_SIZE, 120,
																		GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED, 59,
																Short.MAX_VALUE)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblFechaDesde)
																.addComponent(lblFechaHasta))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(fechaHasta, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(fechaDesde, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(17))))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(119).addComponent(btnConsultar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnRevertir)))
								.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(panelDesplazamiento, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblFiltros).addGap(11)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCuentas).addComponent(cajaCuentas, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTipos).addComponent(cajaTipos, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblEtiquetas).addComponent(cajaEtiquetas,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFechaDesde).addComponent(fechaDesde,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFechaHasta).addComponent(fechaHasta,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))))
				.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE).addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(btnConsultar).addComponent(btnRevertir))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

	}

	@Override
	public void asignarControlador(ControladorMovimientos control) {
		btnConsultar.addActionListener(control);
		btnRevertir.addActionListener(control);
	}

	@Override
	public Movimientos obtenerMovimientoSeleccionado() {
		return mtm.obtenerObjeto(tablaMovimientos.getSelectedRow());
	}

	@Override
	public void asignarDatosTablaMovimientos(List<Movimientos> listaDeMovimientos) {
		mtm = new ModeloTablaMovimientos();
		mtm.asignarListaDeCuentas(listaDeMovimientos);
		tablaMovimientos.setModel(mtm);
	}

	@Override
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public String obtenerFiltro() {

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		String fechaInicio = formatoFecha.format(fechaDesde.getDate());
		String fechaFin = formatoFecha.format(fechaHasta.getDate());
		String sentenciaSQL = "SELECT s FROM Movimientos s where  ";
		sentenciaSQL = sentenciaSQL + "(idCuentaOrigen=" + ((Cuentas) cajaCuentas.getSelectedItem()).getIdCuenta()
				+ " OR idCuentaDestino=" + ((Cuentas) cajaCuentas.getSelectedItem()).getIdCuenta()+ ")";
		sentenciaSQL = sentenciaSQL + " AND idTipo=" + ((Tipos) cajaTipos.getSelectedItem()).getIdTipo();
		sentenciaSQL = sentenciaSQL + " AND idEtiqueta=" + ((Etiquetas) cajaEtiquetas.getSelectedItem()).getIdEtiqueta();
		sentenciaSQL = sentenciaSQL + " AND fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin+"'";

		return sentenciaSQL;
	}
 


}
