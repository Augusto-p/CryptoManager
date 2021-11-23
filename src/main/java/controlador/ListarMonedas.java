package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import entidades.MonedaEntidad;
import modelo.MonedaPool;
import modelo.monedaDao;

/**
 * Servlet implementation class ListarMonedas
 */
@WebServlet("/ListarMonedas")
public class ListarMonedas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/cryptomanager")
	private DataSource pisina;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarMonedas() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		ArrayList<MonedaEntidad> list = new ArrayList<MonedaEntidad>(); 
		try {
			con = pisina.getConnection();
			MonedaPool monpool = new MonedaPool(pisina);
			list = monpool.obternerListaMonedas();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("monedas", list);
		RequestDispatcher rd = request.getRequestDispatcher("/TablaMonedas.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
