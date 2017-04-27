package com.codo.vista.interfaces;

import com.codo.controlador.ControladorGastos;
import com.codo.controlador.ControladorIngresos;
import com.codo.modelo.pojos.Movimientos;

public interface InterfazIngresos extends InterfazComun {
	final String BOTON_ANADIR_INGRESO = "Añadir Ingreso";
	final String BOTON_CANCELAR_INGRESO = "Cancelar";
	
	
	void asignarControlador(ControladorIngresos control);
	
	public Movimientos anadirIngreso(); 
	public void limpiarCampos();
	public boolean comprobarCampos();
	public void cerrarVentana();
}
