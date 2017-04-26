package com.codo.vista.gastos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorGastos;
import com.codo.controlador.ControladorPrincipal;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Tipos;
import com.codo.vista.interfaces.InterfazGastos;

public class VentanaGastos extends JDialog implements InterfazGastos {

	private final JPanel contentPanel = new JPanel();

	public VentanaGastos(List<Cuentas> listaDeCuentas, List<Etiquetas> listaDeEtiqueta, List<Tipos> listaDeTipos) {
		setTitle("Gastos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void asignarControlador(ControladorGastos control) {
		// TODO Auto-generated method stub

	}

	@Override
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
