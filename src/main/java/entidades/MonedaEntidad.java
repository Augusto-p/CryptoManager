package entidades;

public class MonedaEntidad {
	private String nik;
	private String name;
	private byte[] img;
	public MonedaEntidad(String nik, String name, byte[] img) {
		this.nik = nik;
		this.name = name;
		this.img = img;
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
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	
	
}
