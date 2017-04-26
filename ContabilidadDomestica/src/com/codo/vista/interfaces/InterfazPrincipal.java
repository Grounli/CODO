package com.codo.vista.interfaces;

import com.codo.controlador.ControladorPrincipal;

public interface InterfazPrincipal extends InterfazComun {
	
	final String BOTON_CUENTAS = "abrir ventana cuentas";
	final String BOTON_MOVIMIENTOS = "abrir ventana movimientos";
	final String BOTON_PREVISIONES = "abrir ventana previsiones";
	final String BOTON_INGRESOS = "abrir ventana ingresos";
	final String BOTON_GASTOS = "abrir ventana gastos";
	final String BOTON_TRANSFERENCIAS = "abrir ventana transferencias";
	final String BOTON_ETIQUETAS = "abrir ventana etiquetas";
	final String BOTON_SOBRE = "abrir ventana sobre";

	void asignarControlador (ControladorPrincipal control);
	
}
