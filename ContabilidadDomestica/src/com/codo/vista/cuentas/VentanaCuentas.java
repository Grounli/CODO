package com.codo.vista.cuentas;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.codo.controlador.ControladorCuentas;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.vista.interfaces.InterfazCuentas;

public class VentanaCuentas extends JDialog implements InterfazCuentas {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaCuentas;
	private JButton btnAnadir;
	private List<Cuentas> listaCuentas;

	public VentanaCuentas(List<Cuentas> listaDeCuentas) {
		setTitle("Cuentas");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		//DESIGNAMOS LAS COLUMNAS
				String[] columnas = { "ID", "Nombre", "Saldo", "Moneda", "Descripción"};
				
				//DESIGNAMOS EL TAMAÑO DEL ARRAY BASADO EN LA CANTIDAD DE CUENTAS QUE HAYAN EN LA LSITA
				Object[][] datos = new Object[listaDeCuentas.size()][];
				
				int i = 0;
				for (Cuentas cuenta : listaDeCuentas) {
					
					datos[i] = new Object[] {cuenta.getIdCuenta(),cuenta.getNombre(),cuenta.getSaldo(), cuenta.getMonedas().getNombre(),cuenta.getDescripcion()};
					i = i + 1;
				}
				tablaCuentas = new JTable(datos, columnas);
		
		//TABLA CUENTAS
		
		JScrollPane scrollPane = new JScrollPane(tablaCuentas);

		btnAnadir = new JButton("Añadir");
		btnAnadir.setActionCommand(BOTON_ANADIR_CUENTA);

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
	public void asignarControlador(ControladorCuentas control) {
		btnAnadir.addActionListener(control);
		
	}

	@Override
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void cargarCuentas (List<Cuentas> listaCuentas){
		this.listaCuentas=listaCuentas;
	}
	
	
}