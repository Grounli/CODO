package com.codo.vista.interfaces.cuentas;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;
import com.codo.vista.interfaces.InterfazComun;

public interface InterfazVentanaAnadirCuenta extends InterfazComun {

	String BOTON_CONFIRMAR_ANADIR_CUENTA = "Confirmar Añadir Cuenta";
	String BOTON_REGRESAR_ANADIR_CUENTA = "Regresar Añadir Cuenta";

	void asignarControlador(ControladorCuentas control);

	Cuentas leerCamposAnadirCuenta();

	void dispose();

	void limpiarCampos();

	boolean comprobarCampos();

	void cerrarVentana();
}
