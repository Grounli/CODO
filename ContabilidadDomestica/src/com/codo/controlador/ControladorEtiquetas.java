package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codo.modelo.ModeloCD;
import com.codo.vista.interfaces.etiquetas.InterfazEtiquetas;

public class ControladorEtiquetas implements ActionListener {

	private InterfazEtiquetas vistaEtiquetas;
	private ModeloCD modelo;

	public ControladorEtiquetas(InterfazEtiquetas vistaEtiquetas, ModeloCD modelo) {
		this.vistaEtiquetas = vistaEtiquetas;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
