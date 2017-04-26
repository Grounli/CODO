package com.codo.vista.interfaces;

import java.util.List;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;

public interface InterfazCuentas extends InterfazComun {

	final String BOTON_ANADIR_CUENTA = "Añadir Cuenta";
	final String BOTON_BORRAR_CUENTA = "Borrar Cuenta";
	final String BOTON_MODIFICAR_CUENTA = "Modificar Cuenta";
	final String BOTON_REFRESCAR_CUENTA = "Refrescar Cuenta";

	void asignarControlador(ControladorCuentas control);

	void cargarCuentas(List<Cuentas> listaCuentas);
	
}
