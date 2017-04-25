package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.codo.modelo.ModeloCD;
import com.codo.modelo.pojos.Movimientos;
import com.codo.vista.cuentas.VentanaCuentas;
import com.codo.vista.interfaces.InterfazPrincipal;

public class ControladorPrincipal implements ActionListener {

	private InterfazPrincipal vista;
	private ModeloCD modelo;

	public ControladorPrincipal(InterfazPrincipal vista, ModeloCD modelo) {
		this.vista = vista;
		this.modelo = modelo;
		//INICIALIZAR INTERFACES
		
		//INICIALIZAR CONTROLADORES
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		controlMenu(evento);
		controlCuentas(evento);
		controlMovimientos(evento);
		controlPrevisiones(evento);
		controlIngresos(evento);
		controlGastos(evento);
		controlTransferencias(evento);
		controlEtiquetas(evento);
	}

	public void controlMenu(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazPrincipal.VENTANA_SOBRE)) {
			System.out.println("hola, soy el boton sobre");
		}
	}

	public void controlCuentas(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazPrincipal.VENTANA_CUENTAS)) {
			System.out.println("hola, soy el boton cuentas");
			List<Movimientos> movimientos = modelo.leerMovimientos();
			
			VentanaCuentas ventanaCuentas = new VentanaCuentas(movimientos);
			ventanaCuentas.asignarControlador(this);
			ventanaCuentas.arranca();
		}
		
		if (evento.getActionCommand().equals(InterfazPrincipal.ANADIR_CUENTA)){
			System.out.println("soy el boton añadir cuentas de la ventana cuentas");			
		}
	}

	public void controlMovimientos(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazPrincipal.VENTANA_MOVIMIENTOS)) {
			System.out.println("hola, soy el boton movimientos");
		}

	}

	public void controlPrevisiones(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazPrincipal.VENTANA_PREVISIONES)) {
			System.out.println("hola, soy el boton previsiones");
		}
	}

	public void controlIngresos(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazPrincipal.VENTANA_INGRESOS)) {
			System.out.println("hola, soy el boton ingresos");
		}
	}

	public void controlGastos(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazPrincipal.VENTANA_GASTOS)) {
			System.out.println("hola, soy el boton gastos");
		}
	}

	public void controlTransferencias(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazPrincipal.VENTANA_TRANSFERENCIAS)) {
			System.out.println("hola, soy el boton transferencias");
		}
	}

	public void controlEtiquetas(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazPrincipal.VENTANA_ETIQUETAS)) {
			System.out.println("hola, soy el boton etiquetas");
		}
	}

}
