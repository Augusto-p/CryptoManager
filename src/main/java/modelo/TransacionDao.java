package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.*;
import entidades.OperacionEnidad;

public class TransacionDao {

	public int agregarCliente(OperacionEnidad ope) {
		Connection con = Conexion.getConexion();
		int resultado = -1;

		try {
			PreparedStatement ps = con.prepareStatement("insert into trans (id_tipo, fecha, nick_mon, cant_mon, prec_tot) values (?,?, ?, ?, ?);",
					
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, ope.getMode());
			ps.setString(2, FuncionesVarias.getDateTime());
			ps.setString(3, ope.getNik());
			ps.setDouble(4, ope.getCantidad());
			ps.setDouble(5, ope.getPrice());
			
			
			
			if (ps.executeUpdate() > 0) {
				java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
					int primkey = generatedKeys.getInt(1);
					resultado = primkey;
				}
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
}
