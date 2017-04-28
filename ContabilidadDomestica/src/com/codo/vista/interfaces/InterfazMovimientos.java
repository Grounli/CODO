package com.codo.vista.interfaces;

import java.util.List;

import com.codo.controlador.ControladorMovimientos;
import com.codo.modelo.pojos.Movimientos;

public interface InterfazMovimientos extends InterfazComun {
	
	final String BOTON_CONSULTAR_MOVIMIENTOS = "Consultar Movimientos";
	final String BOTON_REVERTIR_MOVIMIENTO = "Revertir Movimiento";

	void asignarControlador(ControladorMovimientos control);

	void asignarDatosTablaMovimientos(List<Movimientos> listaDeMovimientos);

	Movimientos obtenerMovimientoSeleccionado();

}
