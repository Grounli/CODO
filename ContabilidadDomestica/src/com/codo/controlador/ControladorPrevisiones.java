package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codo.modelo.ModeloCD;
import com.codo.vista.interfaces.previsiones.InterfazPrevisiones;
import com.codo.vista.interfaces.previsiones.InterfazVentanaAnadirPrevision;
import com.codo.vista.interfaces.previsiones.InterfazVentanaModificarPrevision;
import com.codo.vista.interfaces.previsiones.InterfazVentanaVerPrevision;
import com.codo.vista.previsiones.VentanaAnadirPrevision;

public class ControladorPrevisiones implements ActionListener {

	private InterfazPrevisiones vistaPrevisiones;
	private ModeloCD modelo;

	// VENTANAS ADICIONALES PREVISIONES
	private InterfazVentanaAnadirPrevision vistaAnadirPrevision;
	private InterfazVentanaModificarPrevision vistaModificarPrevision;
	private InterfazVentanaVerPrevision vistaVerPrevision;

	public ControladorPrevisiones(InterfazPrevisiones vistaPrevisiones, ModeloCD modelo) {
		this.vistaPrevisiones = vistaPrevisiones;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		// --------------- ACCIONES VENTANA PREVISIONES --------------- //

		if (evento.getActionCommand().equals(InterfazPrevisiones.BOTON_ANADIR_VENTANA_PREVISIONES)) {
			vistaAnadirPrevision = new VentanaAnadirPrevision();
			vistaAnadirPrevision.asignarControlador(this);
			vistaAnadirPrevision.iniciar(vistaPrevisiones);
		}

		if (evento.getActionCommand().equals(InterfazPrevisiones.BOTON_BORRAR_VENTANA_PREVISIONES)) {

		}

		if (evento.getActionCommand().equals(InterfazPrevisiones.BOTON_MODIFICAR_VENTANA_PREVISIONES)) {

		}
		if (evento.getActionCommand().equals(InterfazPrevisiones.BOTON_VER_PREVISION_VENTANA_PREVISIONES)) {

		}

		if (evento.getActionCommand().equals(InterfazPrevisiones.BOTON_SALIR_VENTANA_PREVISIONES)) {
			vistaPrevisiones.dispose();
		}
	}
}
