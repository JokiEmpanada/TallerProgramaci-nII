package banco.model;

import java.util.ArrayList;
import java.util.List;


public class Banco {
	
	//ATRIBUTOS
	private String nombre;
	private String direccion;
	private List<CuentaBancaria> listaCuentasBancarias;
	
	public Banco(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaCuentasBancarias = new ArrayList<CuentaBancaria>();
	}
	
	public Banco() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<CuentaBancaria> getListaCuentasBancarias() {
		return listaCuentasBancarias;
	}
	public void setListaCuentasBancarias(List<CuentaBancaria> listaCuentasBancarias) {
		this.listaCuentasBancarias = listaCuentasBancarias;
	}

	@Override
	public String toString() {
		return "Banco [nombre=" + nombre + ", direccion=" + direccion + ", listaCuentasBancarias="
				+ listaCuentasBancarias + "]";
	}
	
	/**
	 * 
	 * @param numeroCuenta
	 * @return booleano dependiendo de si la cuneta existe o no
	 */
	public boolean verificarCuenta(String numeroCuenta) {
		boolean verificado = false;		
		for (CuentaBancaria cuentaAux : listaCuentasBancarias) {
			if(cuentaAux.getNumeroCuenta().equals(numeroCuenta)){
				verificado = true;
				return verificado;
			}
		}
		return verificado;
	}
	
	/**
	 * Crea una cuenta bancaria con todos los datos correspondientes
	 * @param nombreTitular
	 * @param apellidoTitular
	 * @param numeroCuenta
	 * @param tipoCuenta
	 * @return mensaje
	 */
	public String crearCuenta(String nombreTitular, String apellidoTitular, String numeroCuenta, TipoCuenta tipoCuenta) 
			throws Exception {
		
		String mensaje = "La cuenta ha sido creada";
		boolean cuentaEncontrada = verificarCuenta(numeroCuenta);
		if(cuentaEncontrada == true) {
			throw new Exception("La cuenta ya exite!");
		} else {
			CuentaBancaria cuentaBancaria = new CuentaBancaria(nombreTitular, apellidoTitular, numeroCuenta, tipoCuenta, 0.0);
			listaCuentasBancarias.add(cuentaBancaria);
			System.out.println(listaCuentasBancarias.toString());
		}
		return mensaje;
	}
	
	/**
	 * 
	 * @param numeroCuenta
	 * @return La cuenta bancaria 
	 */
	public CuentaBancaria obtenerCuentaBancaria(String numeroCuenta) {
		
		CuentaBancaria cuentaBancariaEncontrada = null;
		for(CuentaBancaria cuentaBancaria : listaCuentasBancarias) {
			if(cuentaBancaria.getNumeroCuenta().equals(numeroCuenta)) {
				cuentaBancariaEncontrada = cuentaBancaria;
			}
		}
		return cuentaBancariaEncontrada;
	}
	
	/**
	 * Elimina una cuenta bancaría
	 * @param numeroCuenta
	 * @throws Exception
	 */
	public void eliminarCuenta(String numeroCuenta) throws Exception {
		CuentaBancaria cuentaBancariaEncontrada = obtenerCuentaBancaria(numeroCuenta);
		if(cuentaBancariaEncontrada == null) {
			throw new Exception("La cuenta bancaria no existe");
		}
		listaCuentasBancarias.remove(cuentaBancariaEncontrada);
	} 
	
	/**
	 * Actualiza los datos de una cuenta bancaría en concreto
	 * @param nombreTitulat
	 * @param apellidoTitular
	 * @param numeroCuenta
	 * @param tipoCuenta
	 * @return mensaje
	 * @throws Exception
	 */
	public String actualizarCuentaBancaria(String nombreTitulat, String apellidoTitular, String numeroCuenta, 
			TipoCuenta tipoCuenta) throws Exception {
		
		CuentaBancaria cuentaBancariaEncontrada = obtenerCuentaBancaria(numeroCuenta);
		if(cuentaBancariaEncontrada == null) {
			throw new Exception("La cuenta bancaria no existe");
		}
		
		cuentaBancariaEncontrada.setNombreTitular(nombreTitulat);
		cuentaBancariaEncontrada.setApellidoTitular(apellidoTitular);
		cuentaBancariaEncontrada.setTipoCuenta(tipoCuenta);
		
		return "Los datos han sido actualizados";
	}
	
	/**
	 * 
	 * @param numeroCuenta
	 * @return Un mensaje de la cantidad de dinero dado un número de cuenta
	 * @throws Exception
	 */
	public String consultarSaldoCuenta(String numeroCuenta) throws Exception {
		String saldo = "El saldo de la cuenta bancaria es: ";
		
		CuentaBancaria cuentaBancariaEncontrada = obtenerCuentaBancaria(numeroCuenta);
		if(cuentaBancariaEncontrada == null) {
			throw new Exception("La cuenta bancaria no existe");
		}
		
		return saldo + cuentaBancariaEncontrada.getSaldoCuenta() + "\n del titular: " + 
		cuentaBancariaEncontrada.getNombreTitular();
	}
	
	/**
	 * Consigna dinero a una cuenta
	 * @param numeroCuenta
	 * @param dineroConsignado
	 * @return mensaje
	 * @throws Exception
	 */
	public String consignarDinero(String numeroCuenta, double dineroConsignado) throws Exception {
		String mensaje = "El dinero ha sido consignado";
		double total = 0.0;
		
		CuentaBancaria cuentaBancariaEncontrada = obtenerCuentaBancaria(numeroCuenta);
		if(cuentaBancariaEncontrada == null) {
			throw new Exception("La cuenta bancaria no existe");
		}
		
		total = cuentaBancariaEncontrada.getSaldoCuenta() + dineroConsignado;
		cuentaBancariaEncontrada.setSaldoCuenta(total);
		System.out.println(listaCuentasBancarias.toString());
		
		return mensaje + " a la cuensta de: " + cuentaBancariaEncontrada.getNombreTitular();
	}
	
	/**
	 * Retira dinero de una cuenta
	 * @param numeroCuenta
	 * @param dineroRetiro
	 * @return
	 * @throws Exception
	 */
	public String retirarDinero(String numeroCuenta, double dineroRetiro) throws Exception {
		String mensaje = "El dinero ha sido retirado: ";
		double aux = 0.0;
		
		CuentaBancaria cuentaBancariaEncontrada = obtenerCuentaBancaria(numeroCuenta);
		if(cuentaBancariaEncontrada == null) {
			throw new Exception("La cuenta bancaria no existe");
		}
		
		if(cuentaBancariaEncontrada.verificarSaldo(dineroRetiro)) {
			aux = cuentaBancariaEncontrada.getSaldoCuenta() - dineroRetiro;
			cuentaBancariaEncontrada.setSaldoCuenta(aux);
			System.out.println(listaCuentasBancarias.toString());
		} else {
			throw new Exception("El dinero ingresado no esta en la cuenta!");
		}
		
		return mensaje + "de la cuenta de: " + cuentaBancariaEncontrada.getNombreTitular();
	}
	
	/**
	 * 
	 * @param cuentaBancaria
	 * @param numeroCuentaActual
	 * @return si la cunetaActual es > o = retorna true, de lo contrario false
	 * @throws Exception
	 */
	public boolean darCuentaMayor(String cuentaActual, String cuentaComparar) throws Exception {
		
		CuentaBancaria actual = obtenerCuentaBancaria(cuentaActual);
		CuentaBancaria comparar = obtenerCuentaBancaria(cuentaComparar);
		
		if(actual == null) {
			throw new Exception("La cuenta bancaria no existe");
		}
		
		if(comparar == null) {
			throw new Exception("La cuenta bancaria no existe");
		}
		
		double saldoActual = actual.getSaldoCuenta();
		double saldoComprar = comparar.getSaldoCuenta();
		
		if(saldoActual >= saldoComprar) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Transfiere dinero de una cuenta destino a una cuenta transferencia
	 * @param numeroCuentaDestino
	 * @param numeroCuentaTransferencia
	 * @return mensaje
	 * @throws Exception
	 */
	public String transferirDinero(String numeroCuentaDestino, String numeroCuentaTransferencia, double cantidadDinero) 
			throws Exception {
		String mensaje = "El dinero ha sido transferido correctamente";
		
		CuentaBancaria cuentaDestino = obtenerCuentaBancaria(numeroCuentaDestino);
		CuentaBancaria cuentaTransferencia = obtenerCuentaBancaria(numeroCuentaTransferencia);
		if(cuentaDestino == null) {
			throw new Exception("La cuenta bancaria no existe");
		}
		
		if(cuentaTransferencia == null) {
			throw new Exception("La cuenta bancaria no existe");
		}
		
		try {
			retirarDinero(numeroCuentaTransferencia, cantidadDinero);
			
			consignarDinero(numeroCuentaDestino, cantidadDinero);
			System.out.println(listaCuentasBancarias.toString());
			return mensaje + " de la cuneta de: " + cuentaTransferencia.getNombreTitular() + 
			"\n a la cuenta de: " + cuentaDestino.getNombreTitular();
		} catch(Exception e) {
			mensaje = "El dinero no pudo ser transferido correctamente";
			return mensaje;
		}
		
	}
 	
}
