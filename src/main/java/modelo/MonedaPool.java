package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import entidades.MonedaEntidad;

public class MonedaPool {
	@Resource(name = "jdbc/cryptomanager")
	private DataSource pisina;

	public MonedaPool(DataSource pisina) {
		this.pisina = pisina;
	}
	
	public ArrayList<MonedaEntidad> obternerListaMonedas() {
		Connection con = null;
		ArrayList<MonedaEntidad> listaMonedas = new ArrayList<MonedaEntidad>();
		try {
			con = pisina.getConnection();
			PreparedStatement ps = con.prepareStatement("select m.nick,m.nombre, m.logo,sum(t.cant_mon * case when tp.nombre =\"compra\" then 1 else -1 end ) as \"Cantidad\",avg(t.prec_tot * case when tp.nombre =\"compra\" then 1 else 0 end /t.cant_mon * case when tp.nombre =\"compra\" then 1 else 0 end ) as \"PPC\" ,avg(t.prec_tot * case when tp.nombre =\"compra\" then 0 else 1 end /t.cant_mon * case when tp.nombre =\"compra\" then 0 else 1 end ) as \"PPV\" from trans as t left join moneda as m on t.nick_mon = m.nick left join tp_trans as tp on t.id_tipo = tp.id_tipo group by nick_mon");
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				String nick = resultado.getString("nick");
				String name = resultado.getString("nombre");
				String img = resultado.getString("logo");
				double Cantidad = resultado.getDouble("Cantidad");
				double PPC = resultado.getDouble("PPC");
				double PPV = resultado.getDouble("PPV");
				MonedaEntidad MonedaDao = new MonedaEntidad(nick, name, img, Cantidad, PPC, PPV);
				listaMonedas.add(MonedaDao);
			}
		} catch (SQLException e) {
		} finally {

		}
		return listaMonedas;
	}

	public void agregarMoneda(MonedaEntidad mone) {
		Connection con = null;
		try {
			con = pisina.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into moneda(nik, nombre, logo) values(?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, mone.getNik());
			ps.setString(2, mone.getName());
			ps.setString(3, mone.getImg());
			int resultado = ps.executeUpdate();
			System.out.println(resultado);
			/*
			if (ps.executeUpdate() > 0) {
				// Retrieves any auto-generated keys created as a result of executing this
				// Statement object
				java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
					int primkey = generatedKeys.getInt(1);
					// = primkey;
				}
			}*/
			


		} catch (SQLException e) {
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

