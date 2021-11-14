package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
//
	public ArrayList<OperacionEnidad> obternerListaTransaciones() {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
		ArrayList<OperacionEnidad> listaOperaciones = new ArrayList<OperacionEnidad>();
		try {
			PreparedStatement ps = con.prepareStatement("select id_trans as ID,id_tipo as modo, logo, nick, nombre, cant_mon as \"Cantidad\", prec_tot as \"Precio Total\", (prec_tot/cant_mon) as \"Precio Unitario\", fecha from trans left join moneda on nick_mon = nick;");
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				int id = resultado.getInt("ID");
				String nick = resultado.getString("nick");
				String nombre = resultado.getString("nombre");
				String img = resultado.getString("logo");
				double Cantidad = resultado.getDouble("Cantidad");
				double PT = resultado.getDouble("Precio Total");
				double PU = resultado.getDouble("Precio Unitario");
				int mode = resultado.getInt("modo");
				String date = resultado.getString("fecha");
				OperacionEnidad opreacionDao = new OperacionEnidad(id, img, nick, Cantidad, PT, date, mode, PU);
				listaOperaciones.add(opreacionDao);
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
		return listaOperaciones;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
