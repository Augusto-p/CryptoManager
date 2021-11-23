package controlador;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.jasper.tagplugins.jstl.core.Out;

import entidades.MonedaEntidad;
import modelo.Conexion;
import modelo.FuncionesVarias;
import modelo.MonedaPool;
import modelo.monedaDao;

/**
 * Servlet implementation class CrearMoneda
 */
@WebServlet("/CrearMoneda")
public class CrearMoneda extends HttpServlet {
	private static final long serialVersionUID = 1L;


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
		
		try {
			MonedaPool poolcoin = new MonedaPool();
			String nick = request.getParameter("nik");
			String name = request.getParameter("name");
			String archivo = request.getParameter("logo");
			MonedaEntidad mone = new MonedaEntidad(nick, name, archivo);
			poolcoin.agregarMoneda(mone);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	

}
