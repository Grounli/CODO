package com.codo.controlador;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.codo.modelo.ModeloCD;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Monedas;
import com.codo.vista.cuentas.VentanaAnadirCuenta;
import com.codo.vista.cuentas.VentanaModificarCuenta;
import com.codo.vista.interfaces.InterfazCuentas;
import com.codo.vista.interfaces.InterfazVentanaAnadirCuenta;
import com.codo.vista.interfaces.InterfazVentanaBorrarCuenta;
import com.codo.vista.interfaces.InterfazVentanaModificarCuenta;

public class ControladorCuentas implements ActionListener {
	
	private InterfazCuentas vistaCuentas;
	private ModeloCD modelo;
	
	// VENTANAS
	private InterfazVentanaAnadirCuenta vistaAnadirCuenta;
	private InterfazVentanaModificarCuenta vistaModificarCuenta;
	
	public ControladorCuentas (InterfazCuentas vistaCuentas, ModeloCD modelo) {
		this.vistaCuentas = vistaCuentas;
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		// ---------------- ACCIONES VENTANA CUENTAS ---------------- //
		if (evento.getActionCommand().equals(InterfazCuentas.BOTON_ANADIR_CUENTA)) {
			List<Monedas> listaDeMonedas = modelo.listaDeMonedas();
			vistaAnadirCuenta = new VentanaAnadirCuenta(listaDeMonedas);
			vistaAnadirCuenta.asignarControlador(this);
			vistaAnadirCuenta.iniciar();
		}
		
		if (evento.getActionCommand().equals(InterfazCuentas.BOTON_BORRAR_CUENTA)) {

		}
		
		if (evento.getActionCommand().equals(InterfazCuentas.BOTON_MODIFICAR_CUENTA)) {
			List<Monedas> listaDeMonedas = modelo.listaDeMonedas();
			vistaModificarCuenta = new VentanaModificarCuenta(listaDeMonedas);
			vistaModificarCuenta.asignarControlador(this);
			vistaModificarCuenta.iniciar();
		}
		
		// ---------------- VENTANA AÑADIR CUENTA ---------------- //
		
		if (evento.getActionCommand().equals(InterfazVentanaAnadirCuenta.BOTON_CONFIRMAR_ANADIR_CUENTA)) {
			Cuentas cuenta = vistaAnadirCuenta.leerCamposAnadirCuenta();
			modelo.crearCuenta(cuenta);
			List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
			vistaCuentas.asignarDatosTablaCuentas(listaDeCuentas);
			JOptionPane.showMessageDialog(null,"Cuenta Añadida Exitosamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
		}
		
		if (evento.getActionCommand().equals(InterfazVentanaAnadirCuenta.BOTON_REGRESAR_ANADIR_CUENTA)) {
			vistaAnadirCuenta.dispose();
		}
		
		// ---------------- VENTANA BORRAR CUENTA ---------------- //
		
		if (evento.getActionCommand().equals(InterfazVentanaBorrarCuenta.BOTON_ACEPTAR_BORRAR_CUENTA)) {
			
		}
		
		if (evento.getActionCommand().equals(InterfazVentanaBorrarCuenta.BOTON_CANCELAR_BORRAR_CUENTA)) {
			
		}
		
		// ---------------- VENTANA MODIFICAR CUENTA ---------------- //
		if (evento.getActionCommand().equals(InterfazVentanaModificarCuenta.BOTON_CONFIRMAR_MODIFICAR_CUENTA)) {
			
		}
		
		if (evento.getActionCommand().equals(InterfazVentanaModificarCuenta.BOTON_REGRESAR_MODIFICAR_CUENTA)) {
			
		}

	}

}
