package banco.test;

import javax.swing.JOptionPane;

import banco.model.Banco;
import banco.model.TipoCuenta;

public class Test {

	//Pruebas de las funciones del taller
	public static void main(String args[]) {
		Banco banco = new Banco("Banco uq", "Armenia");
		
		
		//Crear cuentas
		try {
			System.out.println("Cuenta Creada");
			banco.crearCuenta("Jose", "Amaya", "123", TipoCuenta.CORRIENTE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		try {
			System.out.println("Cuenta Creada");
			banco.crearCuenta("Pablo", "Hurtado", "124", TipoCuenta.AHORROS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		//Consignar dinero en cuentas
		try {
			String consignar = banco.consignarDinero("123", 400000.0);
			JOptionPane.showMessageDialog(null, consignar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		try {
			String consignar = banco.consignarDinero("124", 20000.0);
			JOptionPane.showMessageDialog(null, consignar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		//Consultar saldo en las cuentas
		try {
			String saldo = banco.consultarSaldoCuenta("123");
			JOptionPane.showMessageDialog(null, saldo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		try {
			String saldo = banco.consultarSaldoCuenta("124");
			JOptionPane.showMessageDialog(null, saldo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		//Retirar dinero de las cuentas
		try {
			String retirar = banco.retirarDinero("123", 4000.0);
			JOptionPane.showMessageDialog(null, retirar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		try {
			String retirar = banco.retirarDinero("124", 2000.0);
			JOptionPane.showMessageDialog(null, retirar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		//Transferir dinero de una cuenta a otra
		try {
			String transferir = banco.transferirDinero("124", "123", 2000);
			JOptionPane.showMessageDialog(null, transferir);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		//Función booleana de mayor
		try {
			boolean esCuentaMayor = banco.darCuentaMayor("124", "123");
			JOptionPane.showMessageDialog(null, esCuentaMayor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}
	
}
