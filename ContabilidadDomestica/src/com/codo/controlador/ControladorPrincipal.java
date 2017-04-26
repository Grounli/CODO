package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.codo.modelo.ModeloCD;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Monedas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Previsiones;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.VentanaSobre;
import com.codo.vista.cuentas.VentanaCuentas;
import com.codo.vista.etiquetas.VentanaEtiquetas;
import com.codo.vista.gastos.VentanaGastos;
import com.codo.vista.ingresos.VentanaIngresos;
import com.codo.vista.interfaces.InterfazCuentas;
import com.codo.vista.interfaces.InterfazEtiquetas;
import com.codo.vista.interfaces.InterfazGastos;
import com.codo.vista.interfaces.InterfazIngresos;
import com.codo.vista.interfaces.InterfazMovimientos;
import com.codo.vista.interfaces.InterfazPrevisiones;
import com.codo.vista.interfaces.InterfazPrincipal;
import com.codo.vista.interfaces.InterfazTransferencias;
import com.codo.vista.movimientos.VentanaMovimientos;
import com.codo.vista.previsiones.VentanaPrevisiones;
import com.codo.vista.transferencias.VentanaTransferencias;

public class ControladorPrincipal implements ActionListener {

	private InterfazPrincipal vista;
	private ModeloCD modelo;
	
	//CONTROLADORES
	
	ControladorCuentas controladorCuentas;
	ControladorEtiquetas controladorEtiquetas;
	ControladorGastos controladorGastos;
	ControladorIngresos controladorIngresos;
	ControladorMovimientos controladorMovimientos;
	ControladorPrevisiones controladorPrevisiones;
	ControladorTransferencias controladorTransferencias;
	
	//VISTAS
	
	InterfazCuentas vistaCuentas;
	InterfazEtiquetas vistaEtiquetas;
	InterfazGastos vistaGastos;
	InterfazIngresos vistaIngresos;
	InterfazMovimientos vistaMovimientos;
	InterfazPrevisiones vistaPrevisiones;
	InterfazTransferencias vistaTransferencias;
	
	//LISTAS
	
	
	
	public ControladorPrincipal(InterfazPrincipal vista, ModeloCD modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		//PEDIR LAS LISTAS
		List<Cuentas> listaDeCuentas = modelo.listaDeCuentas();
		List<Etiquetas> listaDeEtiquetas = modelo.listaDeEtiquetas();
		List<Monedas> listaDeMonedas = modelo.listaDeMonedas();
		List<Movimientos> listaDeMovimientos = modelo.listaDeMovimientos();
		List<Previsiones> listaDePrevisiones = modelo.listaDePrevisiones();
		List<Tipos> listaDeTipos = modelo.listaDeTipos();
		
		// INICIALIZAR VISTAS
		
		vistaCuentas = new VentanaCuentas(listaDeCuentas);
		vistaEtiquetas = new VentanaEtiquetas(listaDeEtiquetas);
		vistaGastos = new VentanaGastos(listaDeCuentas,listaDeEtiquetas,listaDeTipos);
		vistaIngresos = new VentanaIngresos(listaDeCuentas,listaDeEtiquetas,listaDeTipos);
		vistaMovimientos = new VentanaMovimientos(listaDeCuentas,listaDeEtiquetas,listaDeTipos);
		vistaPrevisiones = new VentanaPrevisiones(listaDePrevisiones);
		vistaTransferencias = new VentanaTransferencias(listaDeCuentas,listaDeEtiquetas, listaDeTipos);
		
		// INICIALIZAR CONTROLADORES
		
		controladorCuentas = new ControladorCuentas(vistaCuentas, modelo);
		controladorEtiquetas = new ControladorEtiquetas(vistaEtiquetas, modelo);
		controladorGastos = new ControladorGastos(vistaGastos, modelo);
		controladorIngresos = new ControladorIngresos(vistaIngresos, modelo);
		controladorMovimientos = new ControladorMovimientos(vistaMovimientos, modelo);
		controladorPrevisiones = new ControladorPrevisiones(vistaPrevisiones, modelo);
		controladorTransferencias = new ControladorTransferencias(vistaTransferencias, modelo);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		// ACCIONES DE LA BARRA DE MENU DE VENTANA PRINCIPAL
		
		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_SOBRE)) {
			VentanaSobre ventanaSobre = new VentanaSobre();
			ventanaSobre.iniciar();
		}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_ETIQUETAS)) {
			vistaEtiquetas.asignarControlador(controladorEtiquetas);
			vistaEtiquetas.iniciar();
		}
		
		// ------------------ BOTONES DE VENTANA PRINCIPAL ------------------ //
		
		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_CUENTAS)) {

			//LLAMAR A LA VENTANA CUENTAS
			vistaCuentas.asignarControlador(controladorCuentas);
			vistaCuentas.iniciar();	
		}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_MOVIMIENTOS)) {
			vistaMovimientos.asignarControlador(controladorMovimientos);
			vistaMovimientos.iniciar();
		}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_PREVISIONES)) {
			vistaPrevisiones.asignarControlador(controladorPrevisiones);
			vistaPrevisiones.iniciar();
			}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_INGRESOS)) {
			vistaIngresos.asignarControlador(controladorIngresos);
			vistaIngresos.iniciar();
		}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_GASTOS)) {
			vistaGastos.asignarControlador(controladorGastos);
			vistaGastos.iniciar();
		}

		if (evento.getActionCommand().equals(InterfazPrincipal.BOTON_TRANSFERENCIAS)) {
			vistaTransferencias.asignarControlador(controladorTransferencias);
			vistaTransferencias.iniciar();
		}
	}

}