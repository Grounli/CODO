package com.codo.vista.interfaces;

import com.codo.controlador.ControladorCuentas;

public interface InterfazVentanaModificarCuenta extends InterfazComun {

	final String BOTON_ACEPTAR_MODIFICAR_CUENTA = "Aceptar Modificar Cuenta";
	final String BOTON_CANCELAR_MODIFICAR_CUENTA = "Cancelar Modificar Cuenta";
	
	void asignarControlador(ControladorCuentas control);
}
