package com.codo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codo.modelo.ModeloCD;
import com.codo.vista.interfaces.InterfazCuentas;
import com.codo.vista.interfaces.InterfazGastos;
import com.codo.vista.interfaces.InterfazTransferencias;

public class ControladorTransferencias implements ActionListener{

	private InterfazTransferencias vistaTransferencias;
	private ModeloCD modelo;
	
	public ControladorTransferencias (InterfazTransferencias vistaTransferencias, ModeloCD modelo) {
		this.vistaTransferencias = vistaTransferencias;
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals(InterfazTransferencias.BOTON_ANADIR_TRANSFERENCIA)){
			
			modelo.crearMovimiento(vistaTransferencias.anadirTransferencia());	
			System.out.println("Transferencia---------------");
			
		}
		
	}

}
