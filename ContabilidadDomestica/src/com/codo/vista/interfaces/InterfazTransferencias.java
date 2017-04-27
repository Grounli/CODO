package com.codo.vista.interfaces;

import com.codo.controlador.ControladorTransferencias;
import com.codo.modelo.pojos.Movimientos;

public interface InterfazTransferencias extends InterfazComun{
	
	final String BOTON_CANCELAR_TRANSFERENCIA="Borrar transferencia";
	final String BOTON_ANADIR_TRANSFERENCIA= "Añadir transferencia";
	void asignarControlador(ControladorTransferencias control);
	public Movimientos anadirTransferencia();
	public void limpiarCampos();
	public boolean comprobarCampos();
	public void cerrarVentana();
}
