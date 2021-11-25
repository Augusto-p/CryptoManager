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
import entidades.OperacionEnidad;
import modelo.FuncionesVarias;
import modelo.MonedaPool;
import modelo.TransacionPool;


/**
 * Servlet implementation class CrearMoneda
 */
@WebServlet("/CrearMoneda")
public class CrearMoneda extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/cryptomanager")
	private DataSource pisina;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearMoneda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		try {
			con = pisina.getConnection();
			MonedaPool poolcoin = new MonedaPool(pisina);
			TransacionPool pooltransa = new TransacionPool(pisina);
			String nick = request.getParameter("nik");
			String name = request.getParameter("name");
			String archivo = request.getParameter("logo");
			String base64 = "";
			if (FuncionesVarias.downimage(archivo, "logo")) {
				base64 = FuncionesVarias.getbase64img();
			}	
			MonedaEntidad mone = new MonedaEntidad(nick, name, base64);
			poolcoin.agregarMoneda(mone);
			OperacionEnidad opreacion = (OperacionEnidad) request.getAttribute("Tranacion");
			pooltransa.agregarTrasacion(opreacion);
			ArrayList<OperacionEnidad> transa = pooltransa.obternerListaTransaciones();
			request.setAttribute("Transa", transa);
			RequestDispatcher rd = request.getRequestDispatcher("/TablaOperaciones.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	

}
