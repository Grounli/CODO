package com.codo.vista.interfaces;

import java.util.List;

import com.codo.controlador.ControladorGastos;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Tipos;

public interface InterfazGastos extends InterfazComun {
	
	final String BOTON_ANADIR_GASTO = "Añadir Gasto";

	void asignarControlador(ControladorGastos control);
	
	public Movimientos anadirGasto(); 
	public void limpiarCampos();
	public boolean comprobarCampos();

}
