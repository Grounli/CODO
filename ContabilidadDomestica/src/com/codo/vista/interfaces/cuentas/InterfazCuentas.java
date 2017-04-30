package com.codo.vista.interfaces.cuentas;

import java.util.List;

import javax.swing.JTable;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;
import com.codo.vista.interfaces.InterfazComun;

public interface InterfazCuentas extends InterfazComun {

	String BOTON_ANADIR_CUENTA = "Añadir Cuenta";
	String BOTON_BORRAR_CUENTA = "Borrar Cuenta";
	String BOTON_MODIFICAR_CUENTA = "Modificar Cuenta";

	void asignarControlador(ControladorCuentas control);

	void asignarDatosTablaCuentas(List<Cuentas> listaDeCuentas);

	Cuentas obtenerCuentaSeleccionada();
}