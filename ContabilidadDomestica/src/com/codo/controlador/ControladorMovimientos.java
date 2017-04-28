package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.codo.modelo.ModeloCD;
import com.codo.modelo.pojos.Movimientos;
import com.codo.vista.interfaces.InterfazMovimientos;

public class ControladorMovimientos implements ActionListener {

	private InterfazMovimientos vistaMovimientos;
	private ModeloCD modelo;

	public ControladorMovimientos(InterfazMovimientos vistaMovimientos, ModeloCD modelo) {
		this.vistaMovimientos = vistaMovimientos;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazMovimientos.BOTON_CONSULTAR_MOVIMIENTOS)) {
			
			System.out.println(vistaMovimientos.obtenerFiltro());
			
			List<Movimientos> prueba=modelo.listaDeMovimientosFiltros(vistaMovimientos.obtenerFiltro());
			
			for (Movimientos movimientos : prueba) {
				System.out.println(movimientos+"   -----------------");
			}
			
			vistaMovimientos.asignarDatosTablaMovimientos(modelo.listaDeMovimientosFiltros(vistaMovimientos.obtenerFiltro()));
			
		}

		if (evento.getActionCommand().equals(InterfazMovimientos.BOTON_REVERTIR_MOVIMIENTO)) {
			if (vistaMovimientos.obtenerMovimientoSeleccionado() == null) {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar un Movimiento", "Aviso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				int confirmado = JOptionPane.showConfirmDialog(null,
						"¿Está Completamente Seguro? Si Revierte el Movimiento NO Podrá Deshacer la Operación",
						"Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);
				if (confirmado == JOptionPane.YES_OPTION) {
					modelo.borrarMovimiento(vistaMovimientos.obtenerMovimientoSeleccionado());
					vistaMovimientos.asignarDatosTablaMovimientos(modelo.listaDeMovimientos());
					JOptionPane.showMessageDialog(null, "Movimiento Revertido Exitosamente", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
}
