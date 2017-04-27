package com.codo.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.codo.vista.interfaces.InterfazComun;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class VentanaSobre extends JDialog implements InterfazComun{

	private final JPanel contentPanel = new JPanel();

	public VentanaSobre() {
		setPreferredSize(new Dimension(540, 505));
		setResizable(false);
		setTitle("Sobre");
		setBounds(100, 100, 535, 452);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("Informacion.png"));
			lblNewLabel.setBounds(0, 0, 532, 465);
			contentPanel.add(lblNewLabel);
		}

	}

	@Override
	public void iniciar() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
