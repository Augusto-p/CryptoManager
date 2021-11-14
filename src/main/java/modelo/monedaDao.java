package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.MonedaEntidad;

public class monedaDao {
	public int agregarMoneda(MonedaEntidad mone) {
		Connection con = Conexion.getConexion();
		int resultado = -1;

		try {
			PreparedStatement ps = con.prepareStatement("insert into moneda (nik, nombre, logo) values(?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, mone.getNik());
			ps.setString(2, mone.getName());
			ps.setString(3, mone.getImg());
			
			// resultado = ps.executeUpdate();
			if (ps.executeUpdate() > 0) {
				java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
					int primkey = generatedKeys.getInt(1);
					resultado = primkey;
				}
			}

		} catch (SQLException e) {
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	public ArrayList<MonedaEntidad> obternerListaMonedas() {
		Connection con = Conexion.getConexion();
		ArrayList<MonedaEntidad> listaMonedas = new ArrayList<MonedaEntidad>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from moneda");
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				String nick = resultado.getString("nick");
				String name = resultado.getString("nombre");
				String img = resultado.getString("logo");
				MonedaEntidad MonedaDao = new MonedaEntidad(nick,name,img);
				listaMonedas.add(MonedaDao);
			}
		} catch (SQLException e) {
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaMonedas;
	}
}
	
