package com.codo.vista.cuentas;

import java.awt.BorderLayout;
import java.awt.Font;
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
import com.codo.vista.componentes.ModeloTablaCuentas;
import com.codo.vista.interfaces.InterfazCuentas;

public class VentanaCuentas extends JDialog implements InterfazCuentas {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablaCuentas;
	private JButton btnAnadir;

	public VentanaCuentas() {
		setTitle("Cuentas");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		// CONSTRUCCION DE TABLA
		tablaCuentas = new JTable();
		tablaCuentas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaCuentas.setFillsViewportHeight(false);
		tablaCuentas.setRowHeight(30);
		Font f = new Font("Arial", Font.PLAIN, 20);
		tablaCuentas.setFont(f);

		JScrollPane panelDesplazamiento = new JScrollPane(tablaCuentas);
		panelDesplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelDesplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		// BOTONES 
		
		btnAnadir = new JButton("Añadir");
		btnAnadir.setActionCommand(BOTON_ANADIR_CUENTA);

		JButton btnBorrar = new JButton("Borrar");

		JButton btnModificar = new JButton("Modificar");

		JButton btnRefrescar = new JButton("Refrescar");
		
		// LAYOUT
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(panelDesplazamiento, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
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
							.addComponent(panelDesplazamiento, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
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
	
    public void asignarDatosTablaCuentas(List<Cuentas> listaDeCuentas) {
        ModeloTablaCuentas mtc = new ModeloTablaCuentas();
        mtc.setDataSource(listaDeCuentas);
        tablaCuentas.setModel(mtc);
    }
	
}