package com.codo.vista.interfaces;

import javax.swing.JTable;

import com.codo.controlador.ControladorCuentas;

public interface InterfazVentanaModificarCuenta extends InterfazComun {

	final String BOTON_CONFIRMAR_MODIFICAR_CUENTA = "Confirmar Modificar Cuenta";
	final String BOTON_REGRESAR_MODIFICAR_CUENTA = "Regresar Modificar Cuenta";

	void asignarControlador(ControladorCuentas control);

	void rellenarCampos(JTable tablaCuentas);
}
