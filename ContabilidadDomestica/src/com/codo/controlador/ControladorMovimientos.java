package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codo.modelo.ModeloCD;
import com.codo.vista.interfaces.InterfazCuentas;
import com.codo.vista.interfaces.InterfazMovimientos;

public class ControladorMovimientos implements ActionListener {

	private InterfazMovimientos vistaMovimientos;
	private ModeloCD modelo;
	
	public ControladorMovimientos (InterfazMovimientos vistaMovimientos, ModeloCD modelo) {
		this.vistaMovimientos = vistaMovimientos;
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
