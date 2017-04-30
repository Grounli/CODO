package com.codo.vista.interfaces.cuentas;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;
import com.codo.vista.interfaces.InterfazComun;

public interface InterfazVentanaModificarCuenta extends InterfazComun {

	String BOTON_CONFIRMAR_MODIFICAR_CUENTA = "Confirmar Modificar Cuenta";
	String BOTON_REGRESAR_MODIFICAR_CUENTA = "Regresar Modificar Cuenta";

	void asignarControlador(ControladorCuentas control);

	void rellenarCampos(Cuentas objetoSeleccionado);

	public Cuentas actualizarCuentas(Cuentas cuenta);

	void dispose();
}
