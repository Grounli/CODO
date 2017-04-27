package com.codo.vista.interfaces;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;

public interface InterfazVentanaModificarCuenta extends InterfazComun {

	final String BOTON_CONFIRMAR_MODIFICAR_CUENTA = "Confirmar Modificar Cuenta";
	final String BOTON_REGRESAR_MODIFICAR_CUENTA = "Regresar Modificar Cuenta";

	void asignarControlador(ControladorCuentas control);

	void rellenarCampos(Cuentas objetoSeleccionado);

	public Cuentas actualizarCuentas(Cuentas cuenta);

	void dispose();

	
}
