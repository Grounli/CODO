package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.codo.modelo.ModeloCD;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Monedas;
import com.codo.vista.cuentas.VentanaAnadirCuenta;
import com.codo.vista.interfaces.InterfazCuentas;
import com.codo.vista.interfaces.InterfazVentanaAnadirCuenta;
import com.codo.vista.interfaces.InterfazVentanaBorrarCuenta;
import com.codo.vista.interfaces.InterfazVentanaModificarCuenta;

public class ControladorCuentas implements ActionListener {
	
	private InterfazCuentas vistaCuentas;
	private ModeloCD modelo;
	
	// VENTANAS
	VentanaAnadirCuenta ventanaAnadirCuenta;
	
	public ControladorCuentas (InterfazCuentas vistaCuentas, ModeloCD modelo) {
		this.vistaCuentas = vistaCuentas;
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		// ---------------- ACCIONES VENTANA CUENTAS ---------------- //
		if (evento.getActionCommand().equals(InterfazCuentas.BOTON_ANADIR_CUENTA)) {
			List<Monedas> listaDeMonedas = modelo.listaDeMonedas();
			ventanaAnadirCuenta = new VentanaAnadirCuenta(listaDeMonedas);
			ventanaAnadirCuenta.asignarControlador(this);
			ventanaAnadirCuenta.iniciar();
		}
		
		if (evento.getActionCommand().equals(InterfazCuentas.BOTON_BORRAR_CUENTA)) {
			
		}
		
		if (evento.getActionCommand().equals(InterfazCuentas.BOTON_MODIFICAR_CUENTA)) {

		}
		
		if (evento.getActionCommand().equals(InterfazCuentas.BOTON_REFRESCAR_CUENTA)) {
			
		}
		
		// ---------------- VENTANA AÑADIR CUENTA ---------------- //
		if (evento.getActionCommand().equals(InterfazVentanaAnadirCuenta.BOTON_ACEPTAR_ANADIR_CUENTA)) {
			Cuentas cuenta = ventanaAnadirCuenta.anadirCuenta();
			modelo.crearCuenta(cuenta);
		}
		
		if (evento.getActionCommand().equals(InterfazVentanaAnadirCuenta.BOTON_CANCELAR_ANADIR_CUENTA)) {
			ventanaAnadirCuenta.dispose();
		}
		
		// ---------------- VENTANA BORRAR CUENTA ---------------- //
		if (evento.getActionCommand().equals(InterfazVentanaBorrarCuenta.BOTON_ACEPTAR_BORRAR_CUENTA)) {
			
		}
		
		if (evento.getActionCommand().equals(InterfazVentanaBorrarCuenta.BOTON_CANCELAR_BORRAR_CUENTA)) {
			
		}
		
		// ---------------- VENTANA MODIFICAR CUENTA ---------------- //
		if (evento.getActionCommand().equals(InterfazVentanaModificarCuenta.BOTON_ACEPTAR_MODIFICAR_CUENTA)) {
			
		}
		
		if (evento.getActionCommand().equals(InterfazVentanaModificarCuenta.BOTON_CANCELAR_MODIFICAR_CUENTA)) {
			
		}

	}

}
