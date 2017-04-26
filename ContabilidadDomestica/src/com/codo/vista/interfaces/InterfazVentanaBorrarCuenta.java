package com.codo.vista.interfaces;

import com.codo.controlador.ControladorCuentas;

public interface InterfazVentanaBorrarCuenta extends InterfazComun {

	final String BOTON_ACEPTAR_BORRAR_CUENTA = "Aceptar Borrar Cuenta";
	final String BOTON_CANCELAR_BORRAR_CUENTA = "Cancelar Borrar Cuenta";
	
	void asignarControlador(ControladorCuentas control);
}
