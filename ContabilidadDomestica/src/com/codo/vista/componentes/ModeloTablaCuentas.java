package com.codo.vista.componentes;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.codo.modelo.pojos.Cuentas;

public class ModeloTablaCuentas extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	private List<Cuentas> listaDeCuentas = null;
	private String[] columnas = { "ID", "Nombre", "Saldo", "Moneda", "Descripción" };

	public ModeloTablaCuentas() {
        this.setColumnIdentifiers(columnas);
    }

	public void setDataSource(List<Cuentas> listaDeCuentas) {
		this.listaDeCuentas = listaDeCuentas;
	}

	public String[] getColumnNames() {
		return columnas;
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		if (listaDeCuentas != null) {
			return listaDeCuentas.size();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int indiceDeFila, int indiceDeColumna) {
		if (indiceDeFila <= getRowCount()) {
			Cuentas cuenta = listaDeCuentas.get(indiceDeFila);

			if (cuenta != null) {
				switch (indiceDeColumna) {
				case 0:
					return cuenta.getIdCuenta();
				case 1:
					return cuenta.getNombre();
				case 2:
					return cuenta.getSaldo();
				case 3:
					return cuenta.getMonedas();
				case 4:
					return cuenta.getDescripcion();
				}
			}
		}
		return null;
	}

}
