package banco.model;

public class CuentaBancaria {

	//ATRIBUTOS
	private String nombreTitular;
	private String apellidoTitular;
	private String numeroCuenta;
	private TipoCuenta tipoCuenta;
	private Double saldoCuenta;
	
	/**
	 * 
	 * @param nombreTitular
	 * @param apellidoTitular
	 * @param numeroCuenta
	 * @param tipoCuenta
	 * @param saldoCuenta
	 */
	public CuentaBancaria(String nombreTitular, String apellidoTitular, String numeroCuenta, TipoCuenta tipoCuenta,
			Double saldoCuenta) {
		super();
		this.nombreTitular = nombreTitular;
		this.apellidoTitular = apellidoTitular;
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoCuenta = saldoCuenta;
	}
	
	public CuentaBancaria() {
		super();
	}
	
	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getApellidoTitular() {
		return apellidoTitular;
	}

	public void setApellidoTitular(String apellidoTitular) {
		this.apellidoTitular = apellidoTitular;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Double getSaldoCuenta() {
		return saldoCuenta;
	}

	public void setSaldoCuenta(Double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [nombreTitular=" + nombreTitular + ", apellidoTitular=" + apellidoTitular
				+ ", numeroCuenta=" + numeroCuenta + ", tipoCuenta=" + tipoCuenta + ", saldoCuenta=" + saldoCuenta
				+ "]";
	}
	
	/**
	 * 
	 * @param dineroRetiro
	 * @return booleano de si el dinero solicitado existe o no
	 */
	public boolean verificarSaldo(double dineroRetiro) {
		if(dineroRetiro <= getSaldoCuenta()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
