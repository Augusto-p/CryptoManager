package entidades;

public class MonedaEntidad {
	private String nik;
	private String name;
	private String img;
	private double cantidad;
	private double precio_pro_com;
	private double precio_pro_ven;
	
	public MonedaEntidad(String nik, String name, String img) {
		super();
		this.nik = nik;
		this.name = name;
		this.img = img;
	}

	
	public MonedaEntidad(String nik, String name, String img, double cantidad, double precio_pro_com,
			double precio_pro_ven) {
		super();
		this.nik = nik;
		this.name = name;
		this.img = img;
		this.cantidad = cantidad;
		this.precio_pro_com = precio_pro_com;
		this.precio_pro_ven = precio_pro_ven;
	}


	public double getPrecio_pro_com() {
		return precio_pro_com;
	}


	public void setPrecio_pro_com(double precio_pro_com) {
		this.precio_pro_com = precio_pro_com;
	}


	public double getPrecio_pro_ven() {
		return precio_pro_ven;
	}


	public void setPrecio_pro_ven(double precio_pro_ven) {
		this.precio_pro_ven = precio_pro_ven;
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


	
	
	
	
}
