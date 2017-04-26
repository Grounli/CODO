package com.codo.vista.interfaces;

import com.codo.controlador.ControladorCuentas;

public interface InterfazCuentas extends InterfazComun {

	final String BOTON_ANADIR_CUENTA = "Añadir Cuenta";
	final String BOTON_BORRAR_CUENTA = "Borrar Cuenta";
	final String BOTON_MODIFICAR_CUENTA = "Modificar Cuenta";
	final String BOTON_REFRESCAR_CUENTA = "Refrescar Cuenta";

	void asignarControlador(ControladorCuentas control);

	
}
