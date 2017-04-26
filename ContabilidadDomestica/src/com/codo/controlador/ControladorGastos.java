package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codo.modelo.ModeloCD;
import com.codo.vista.interfaces.InterfazCuentas;
import com.codo.vista.interfaces.InterfazGastos;

public class ControladorGastos implements ActionListener {

	private InterfazGastos vistaGastos;
	private ModeloCD modelo;
	
	public ControladorGastos (InterfazGastos vistaGastos, ModeloCD modelo) {
		this.vistaGastos = vistaGastos;
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
