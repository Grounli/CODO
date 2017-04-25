package com.codo.vista.interfaces;

import com.codo.controlador.ControladorPrincipal;

public interface InterfazPrincipal extends InterfazAcciones {
	
	final String VENTANA_CUENTAS = "ventana cuentas";
	final String VENTANA_MOVIMIENTOS = "ventana movimientos";
	final String VENTANA_PREVISIONES = "ventana previsiones";
	final String VENTANA_INGRESOS = "ventana ingresos";
	final String VENTANA_GASTOS = "ventana gastos";
	final String VENTANA_TRANSFERENCIAS = "ventana transferencias";
	final String VENTANA_ETIQUETAS = "ventana etiquetas";
	final String VENTANA_SOBRE = "ventana sobre";
	
	final String ANADIR_CUENTA = "Añadir Cuenta";
	
	void asignarControlador (ControladorPrincipal control);
	void arranca ();
	
}
