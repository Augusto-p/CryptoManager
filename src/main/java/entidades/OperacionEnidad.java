package entidades;

public class OperacionEnidad {
	private int id;
	private String img;
	private String nik;
	private double cantidad;
	private double price;
	private String fecha;
	private int mode;
	private double precio_uni;
	
	public OperacionEnidad(String nik, double cantidad, double price, int mode) {
		super();
		this.nik = nik;
		this.cantidad = cantidad;
		this.price = price;
		this.mode = mode;
	}

	public OperacionEnidad(int id, String img, String nik, double cantidad, double price, String fecha, int mode,
			double precio_uni) {
		super();
		this.id = id;
		this.img = img;
		this.nik = nik;
		this.cantidad = cantidad;
		this.price = price;
		this.fecha = fecha;
		this.mode = mode;
		this.precio_uni = precio_uni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public double getPrecio_uni() {
		return precio_uni;
	}

	public void setPrecio_uni(double precio_uni) {
		this.precio_uni = precio_uni;
	}
	
	
	
	

}
