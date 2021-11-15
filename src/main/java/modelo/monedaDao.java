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
			PreparedStatement ps = con.prepareStatement("select m.nick,m.nombre, m.logo,sum(t.cant_mon * case when tp.nombre =\"compra\" then 1 else -1 end ) as \"Cantidad\",avg(t.prec_tot * case when tp.nombre =\"compra\" then 1 else 0 end /t.cant_mon * case when tp.nombre =\"compra\" then 1 else 0 end ) as \"PPC\" ,avg(t.prec_tot * case when tp.nombre =\"compra\" then 0 else 1 end /t.cant_mon * case when tp.nombre =\"compra\" then 0 else 1 end ) as \"PPV\" from trans as t left join moneda as m on t.nick_mon = m.nick left join tp_trans as tp on t.id_tipo = tp.id_tipo group by nick_mon;");
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				String nick = resultado.getString("nick");
				String name = resultado.getString("nombre");
				String img = resultado.getString("logo");
				double Cantidad = resultado.getDouble("Cantidad");
				double PPC = resultado.getDouble("PPV");
				double PPV = resultado.getDouble("PPV");
				MonedaEntidad MonedaDao = new MonedaEntidad(nick, name, img, Cantidad, PPC, PPV);
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
	
