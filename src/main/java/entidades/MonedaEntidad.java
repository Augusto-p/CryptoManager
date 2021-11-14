package entidades;

public class MonedaEntidad {
	private String nik;
	private String name;
	private String img;
	private double cantidad;
	private double precio_pro;
	private double precio_uni_ulti_compra;
	
	public MonedaEntidad(String nik, String name, String img) {
		super();
		this.nik = nik;
		this.name = name;
		this.img = img;
	}

	public MonedaEntidad(String nik, String name, String img, double cantidad, double precio_pro,
			double precio_uni_ulti_compra) {
		super();
		this.nik = nik;
		this.name = name;
		this.img = img;
		this.cantidad = cantidad;
		this.precio_pro = precio_pro;
		this.precio_uni_ulti_compra = precio_uni_ulti_compra;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio_pro() {
		return precio_pro;
	}

	public void setPrecio_pro(double precio_pro) {
		this.precio_pro = precio_pro;
	}

	public double getPrecio_uni_ulti_compra() {
		return precio_uni_ulti_compra;
	}

	public void setPrecio_uni_ulti_compra(double precio_uni_ulti_compra) {
		this.precio_uni_ulti_compra = precio_uni_ulti_compra;
	}
	
	
	
	
}
