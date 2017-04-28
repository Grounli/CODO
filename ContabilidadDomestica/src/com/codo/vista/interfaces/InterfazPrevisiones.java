package com.codo.vista.interfaces;

import com.codo.controlador.ControladorPrevisiones;

public interface InterfazPrevisiones extends InterfazComun {
	
	final String BOTON_ANADIR_VENTANA_PREVISIONES = "Boton Añadir Ventana Previsiones";
	final String BOTON_BORRAR_VENTANA_PREVISIONES = "Boton Añadir Ventana Previsiones";
	final String BOTON_MODIFICAR_VENTANA_PREVISIONES = "Boton Añadir Ventana Previsiones";
	final String BOTON_EJECUTAR_VENTANA_PREVISIONES = "Boton Añadir Ventana Previsiones";
	final String BOTON__VENTANA_PREVISIONES = "Boton Añadir Ventana Previsiones";
	

	void asignarControlador(ControladorPrevisiones control);

}
