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
import modelo.MonedaPool;
import modelo.Scraping;
import modelo.TransacionPool;

/**
 * Servlet implementation class CrearOperacion
 */
@WebServlet("/CrearOperacion")
public class CrearOperacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/cryptomanager")
	private DataSource pisina;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearOperacion() {
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
		String nick = request.getParameter("nik");
		int cantidad = Integer.valueOf(request.getParameter("cant"));
		int precioT = Integer.valueOf(request.getParameter("precT"));
		String tipoT = request.getParameter("oper");
		OperacionEnidad tran = new OperacionEnidad(nick, cantidad, precioT, tipoT);
		try {
			con = pisina.getConnection();
			MonedaPool poolmone = new MonedaPool(pisina);
			TransacionPool pooltran = new TransacionPool(pisina);
			if (poolmone.existecrypto(nick)) {
				pooltran.agregarTrasacion(tran);
				ArrayList<OperacionEnidad> transa = pooltran.obternerListaTransaciones();
				request.setAttribute("Transa", transa);
				RequestDispatcher rd = request.getRequestDispatcher("/TablaOperaciones.jsp");
				rd.forward(request, response);
			}else {
				MonedaEntidad crypto = Scraping.getdataScraping(nick);
				if(crypto.getName() != "ERROR" && crypto.getImg() != "NOIMG") {
					poolmone.agregarMoneda(crypto);
					pooltran.agregarTrasacion(tran);
					ArrayList<OperacionEnidad> transa = pooltran.obternerListaTransaciones();
					request.setAttribute("Transa", transa);
					RequestDispatcher rd = request.getRequestDispatcher("/TablaOperaciones.jsp");
					rd.forward(request, response);
				}else {
					crypto.setImg("");
					if(crypto.getName().equals("ERROR")) {crypto.setName("");}
					request.setAttribute("Tranacion", tran);
					
					RequestDispatcher rd = request.getRequestDispatcher("/AñadirMoneda.jsp");
					rd.forward(request, response);
					
				}
				
				
				
				
			}
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
	}

}
