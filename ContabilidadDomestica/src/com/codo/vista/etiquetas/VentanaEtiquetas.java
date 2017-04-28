package com.codo.vista.etiquetas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorEtiquetas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.vista.interfaces.InterfazEtiquetas;

public class VentanaEtiquetas extends JDialog implements InterfazEtiquetas {

	private final JPanel contentPanel = new JPanel();

	public VentanaEtiquetas(List<Etiquetas> listaDeEtiquetas) {
		setTitle("Etiquetas");
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
	public void asignarControlador(ControladorEtiquetas control) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciar() {
		pack();
		//setLocationRelativeTo(null);
		setLocation(400, 200);
		setVisible(true);
		
	}

}
