package com.codo.vista.previsiones;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorPrevisiones;
import com.codo.modelo.pojos.Previsiones;
import com.codo.vista.componentes.ModeloTablaMovimientos;
import com.codo.vista.interfaces.InterfazPrevisiones;

public class VentanaPrevisiones extends JDialog implements InterfazPrevisiones {


	private static final long serialVersionUID = 1L;
	
	private static final int POSICION_HORIZONTAL = 100;
	private static final int POSICION_VERTICAL = 100;
	private static final int ANCHURA_MAXIMA = 500;
	private static final int ALTURA_MAXIMA = 400;
	private static final int ANCHURA_MINIMA_PANEL_COMPONENTES = 500;
	private static final int ALTURA_MINIMA_PANEL_COMPONENTES = 35;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaMovimientos;
	private JScrollPane panelDesplazamiento;
	private ModeloTablaMovimientos mtp;
	private JButton btnAnadir;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnEjecutar;
	private JButton btnSalir;

	public VentanaPrevisiones(List<Previsiones> listaDePrevisiones) {
		setTitle("Previsiones");
		setBounds(POSICION_HORIZONTAL, POSICION_VERTICAL, ANCHURA_MAXIMA, ALTURA_MAXIMA);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelComponentes = new JPanel();
			panelComponentes.setBounds(0, 0, ANCHURA_MINIMA_PANEL_COMPONENTES, ALTURA_MINIMA_PANEL_COMPONENTES);
			panelComponentes.setPreferredSize(new Dimension (ANCHURA_MINIMA_PANEL_COMPONENTES,ALTURA_MINIMA_PANEL_COMPONENTES));
			panelComponentes.setMinimumSize(new Dimension (ANCHURA_MINIMA_PANEL_COMPONENTES,ALTURA_MINIMA_PANEL_COMPONENTES));
			contentPanel.add(panelComponentes, BorderLayout.SOUTH);
			panelComponentes.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			{
				btnAnadir = new JButton("Añadir");
				panelComponentes.add(btnAnadir);
			}
			{
				btnBorrar = new JButton("Borrar");
				panelComponentes.add(btnBorrar);
			}
			{
				btnModificar = new JButton("Modificar");
				panelComponentes.add(btnModificar);
			}
			{
				btnEjecutar = new JButton("Ejecutar");
				panelComponentes.add(btnEjecutar);
			}
		}
		{
			
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
			contentPanel.add(panelDesplazamiento, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
	}

	@Override
	public void asignarControlador(ControladorPrevisiones control) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciar() {
		pack();
		//setLocationRelativeTo(null);
		setLocation(400, 200);
		setVisible(true);		
	}

}
