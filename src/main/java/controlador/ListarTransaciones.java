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

import entidades.OperacionEnidad;
import modelo.Conexion;
import modelo.MonedaPool;
import modelo.TransacionPool;

/**
 * Servlet implementation class ListarTransaciones
 */
@WebServlet("/ListarTransaciones")
public class ListarTransaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/cryptomanager")
	private DataSource pisina;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTransaciones() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		ArrayList<OperacionEnidad> list = new ArrayList<OperacionEnidad>();
		try {
			con = pisina.getConnection();
			TransacionPool tranpool = new TransacionPool(pisina);
			list = tranpool.obternerListaTransaciones();
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
		request.setAttribute("Transa", list);
		RequestDispatcher rd = request.getRequestDispatcher("/TablaOperaciones.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
