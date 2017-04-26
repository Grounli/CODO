package com.codo.vista.interfaces;

import com.codo.controlador.ControladorIngresos;
import com.codo.modelo.pojos.Movimientos;

public interface InterfazIngresos extends InterfazComun {
	final String BOTON_ANADIR_INGRESO = "Añadir Ingreso";
	void asignarControlador(ControladorIngresos control);
	
	public Movimientos anadirIngreso(); 

}
