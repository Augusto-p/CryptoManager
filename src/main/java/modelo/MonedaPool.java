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

	public Connection MonedaPool() {
		Connection con=null;
		try {
			Context initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/cryptomanager");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public ArrayList<MonedaEntidad> obternerListaMonedas() {
		Connection con = this.MonedaPool();
		ArrayList<MonedaEntidad> listaMonedas = new ArrayList<MonedaEntidad>();
		try {
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
		Connection con = this.MonedaPool();
		int resultado = -1;
		try {
			PreparedStatement ps = con.prepareStatement("insert into moneda (nik, nombre, logo) values(?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, mone.getNik());
			ps.setString(2, mone.getName());
			ps.setString(3, mone.getImg());
			


		} catch (SQLException e) {
		} finally {
		}
	}
}

