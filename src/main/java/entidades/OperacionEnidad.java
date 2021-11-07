package entidades;

public class OperacionEnidad {
	private int id;
	private String nik;
	private double cantidad;
	private double price;
	
	public OperacionEnidad(int id, String nik, double cantidad, double price) {
		this.id = id;
		this.nik = nik;
		this.cantidad = cantidad;
		this.price = price;
	}
	public OperacionEnidad(String nik, double cantidad, double price) {
		super();
		this.nik = nik;
		this.cantidad = cantidad;
		this.price = price;
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
