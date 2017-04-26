package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codo.modelo.ModeloCD;
import com.codo.vista.interfaces.InterfazCuentas;
import com.codo.vista.interfaces.InterfazPrevisiones;

public class ControladorPrevisiones implements ActionListener {

	private InterfazPrevisiones vistaPrevisiones;
	private ModeloCD modelo;
	
	public ControladorPrevisiones (InterfazPrevisiones vistaPrevisiones, ModeloCD modelo) {
		this.vistaPrevisiones = vistaPrevisiones;
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
