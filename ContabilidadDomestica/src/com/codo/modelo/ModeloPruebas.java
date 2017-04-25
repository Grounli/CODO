package com.codo.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.codo.modelo.daos.CuentasDAO;
import com.codo.modelo.daos.EtiquetasDAO;
import com.codo.modelo.daos.MonedasDAO;
import com.codo.modelo.daos.MovimientosDAO;
import com.codo.modelo.pojos.Cuentas;
import com.codo.modelo.pojos.Etiquetas;
import com.codo.modelo.pojos.Monedas;
import com.codo.modelo.pojos.Movimientos;
import com.codo.modelo.pojos.Tipos;

public class ModeloPruebas {

	private static final EntityManagerFactory EM_FACTORY = Persistence.createEntityManagerFactory("ProyectoORM");

	public static void main(String[] args) throws ParseException {

		MonedasDAO daoMoneda = new MonedasDAO(EM_FACTORY);
		CuentasDAO daoCuenta = new CuentasDAO(EM_FACTORY);
		EtiquetasDAO daoEtiquetas = new EtiquetasDAO(EM_FACTORY);
		MovimientosDAO daoMovimiento = new MovimientosDAO(EM_FACTORY);
/*
		Monedas mon = new Monedas("EUR",1);
		
		
		Tipos tipo= new Tipos("Ingreso",1);
		
		Etiquetas et = new Etiquetas(tipo,"Otros",1);
		
		Cuentas cu = new Cuentas(1, mon,"Caixa");
		
	    SimpleDateFormat df = new SimpleDateFormat();

	    Date dt= new Date();
		
		Movimientos mov= new Movimientos(cu,et,tipo,20120,dt);
		

		daoMovimiento.crear(mov);
		
		
		
		System.out.println("Movimientos------------------------------");

		List<Movimientos> lstMov = daoMovimiento.leerMovimientos();
		if (lstMov != null) {
			for (Movimientos p : lstMov) {
				System.out.println(p.getCuentasByIdCuentaOrigen().getNombre() + " " + p.getValor());
				
			}
		
		}
		
		List<Cuentas> lstCuentas = daoCuenta.leerCuentas();

		if (lstCuentas != null) {
			for (Cuentas p : lstCuentas) {
				System.out.println(p.getNombre() + " " + p.getIdCuenta());
				if (p.getIdCuenta() == 1) {
					cu = p;
				}
			}
		}
		
		
		
/*
		
		 
		
		System.out.println("Etiquetas--------------------------------");

		List<Etiquetas> lstEtiquetas = daoEtiquetas.readAll();
		if (lstEtiquetas != null) {
			for (Etiquetas p : lstEtiquetas) {
				System.out.println(p.getNombre() + " " + p.getIdEtiqueta());
				if (p.getIdEtiqueta() == 1) {
					et = p;

				}
			}
		}
		
		daoMoneda.create(monedaNueva);

		System.out.println("Monedas ---------------------------------");

		List<Monedas> lstMonedas = daoMoneda.readAll();

		if (lstMonedas != null) {
			for (Monedas p : lstMonedas) {
				System.out.println(p.getNombre() + " " + p.getIdMoneda());
				if (p.getIdMoneda() == 1) {
					mon = p;

				}
			}
		}

		System.out.println("Cuentas ---------------------------------");

		List<Cuentas> lstCuentas = daoCuenta.readAll();

		if (lstCuentas != null) {
			for (Cuentas p : lstCuentas) {
				System.out.println(p.getNombre() + " " + p.getIdCuenta());
				if (p.getIdCuenta() == 1) {
					cu = p;
				}
			}
		}
*/

		EM_FACTORY.close();

	}

}
