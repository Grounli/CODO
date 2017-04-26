package com.codo.vista.interfaces;

import com.codo.controlador.ControladorCuentas;

public interface InterfazVentanaAnadirCuenta extends InterfazComun {

	final String BOTON_ACEPTAR_ANADIR_CUENTA = "Aceptar Añadir Cuenta";
	final String BOTON_CANCELAR_ANADIR_CUENTA = "Cancelar Añadir Cuenta";
	

	

	
	void asignarControlador(ControladorCuentas control);
}
