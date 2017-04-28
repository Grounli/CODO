package com.codo.vista.interfaces;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;

public interface InterfazVentanaAnadirCuenta extends InterfazComun {

	final String BOTON_CONFIRMAR_ANADIR_CUENTA = "Confirmar Añadir Cuenta";
	final String BOTON_REGRESAR_ANADIR_CUENTA = "Regresar Añadir Cuenta";

	void asignarControlador(ControladorCuentas control);

	Cuentas leerCamposAnadirCuenta();

	void dispose();
	public void limpiarCampos();
	public boolean comprobarCampos();
	public void cerrarVentana();
}
