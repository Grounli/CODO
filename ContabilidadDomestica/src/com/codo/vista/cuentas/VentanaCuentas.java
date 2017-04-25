package com.codo.vista.cuentas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorPrincipal;
import com.codo.modelo.pojos.Movimientos;
import com.codo.vista.interfaces.InterfazPrincipal;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dialog.ModalityType;

public class VentanaCuentas extends JDialog implements InterfazPrincipal {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaCuentas;
	private JButton btnAnadir;

	public VentanaCuentas(List<Movimientos> movimientos) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		Object[][] datos = new Object[movimientos.size()][];
		String[] columnas = { "ID", "Cuenta Origen", "Cuenta Destino", "Tipo", "Etiqueta", "valor", "Fecha",
				"Descripcion" };
		int i = 0;
		for (Movimientos m : movimientos) {
			System.out.println(m.getCuentasByIdCuentaDestino());
			datos[i] = new Object[] { m.getIdMovimiento(), 
					m.getCuentasByIdCuentaOrigen().getNombre(),
					m.getCuentasByIdCuentaDestino(), 
					m.getTipos().getNombre(), 
					m.getEtiquetas().getNombre(),
					m.getValor(),
					m.getFecha(),
					m.getDescripcion() };
			i = i + 1;
		}

		tablaCuentas = new JTable(datos, columnas);

		setBounds(100, 100, 526, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(tablaCuentas);

		btnAnadir = new JButton("Añadir");
		btnAnadir.setActionCommand(ANADIR_CUENTA);

		JButton btnBorrar = new JButton("Borrar");

		JButton btnModificar = new JButton("Modificar");

		JButton btnRefrescar = new JButton("Refrescar");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAnadir)
								.addComponent(btnBorrar)
								.addComponent(btnModificar)))
						.addComponent(btnRefrescar))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnAnadir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBorrar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnModificar))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRefrescar)))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}

	@Override
	public void asignarControlador(ControladorPrincipal control) {
		btnAnadir.addActionListener(control);
		
	}

	@Override
	public void arranca() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
