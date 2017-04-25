package com.codo.principal;

import com.codo.controlador.ControladorPrincipal;
import com.codo.modelo.ModeloCD;
import com.codo.vista.VentanaPrincipal;
import com.codo.vista.interfaces.InterfazPrincipal;

public class Principal {

	public static void main(String[] args) {
		
		//generamos el modelo
		ModeloCD modelo = new ModeloCD();
		//generamos la vista
		InterfazPrincipal vista = new VentanaPrincipal();
		//generamos el controlador
		ControladorPrincipal control = new ControladorPrincipal (vista,modelo);
		//configurar vista
		vista.asignarControlador(control);
		//iniciar vista
		vista.arranca();
		

	}

}
