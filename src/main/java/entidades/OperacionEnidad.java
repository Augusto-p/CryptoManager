package entidades;

public class OperacionEnidad {
	private int id;
	private String nik;
	private double cantidad;
	private double price;
	private String Fecha;
	private int mode;
	public OperacionEnidad(String nik, double cantidad, double price, int mode) {
		super();
		this.nik = nik;
		this.cantidad = cantidad;
		this.price = price;
		this.mode = mode;
	}
	
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
