package com.ipartek.formacion.leire.controladores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.leire.dal.DALFactory;
import com.ipartek.formacion.leire.dal.UsuariosDAL;
import com.ipartek.formacion.leire.tipos.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	/* package */static final String RUTA = "/WEB-INF/vistas/";
	private static final String RUTA_PRINCIPAL = RUTA + "principal.jsp";
	private static final String RUTA_LOGIN = RUTA + "login.jsp";
	//	private static final String RUTA_ADMIN = RUTA + "administrar.jsp";
	static final String RUTA_SERVLET_LISTADO = RUTA + "productoscrud";
	//	private static final String RUTA_LISTADO = RUTA + "productoslistado.jsp";

	public static final int TIEMPO_INACTIVIDAD = 30 * 60;

	/* package */static final int MINIMO_CARACTERES = 4;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger datos de vistas
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");

		String opcion = request.getParameter("opcion");

		// Crear modelos en base a los datos
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPass(pass);

		// Llamada a lógica de negocio
		ServletContext application = request.getServletContext();

		//		UsuariosDAL usuariosDAL = (UsuariosDAL) application.getAttribute(AltaServlet.USUARIOS_DAL);
		UsuariosDAL usuariosDAL = (UsuariosDAL) application.getAttribute("UsuariosDAL");

		//
		if (usuariosDAL == null) {
			usuariosDAL = DALFactory.getUsuariosDAL();

		}
		//
		//		//		usuariosDAL.alta(new Usuario("Leire", "leire"));
		//		usuariosDAL.alta(new Usuario("admin", "admin"));

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(TIEMPO_INACTIVIDAD);

		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(TIEMPO_INACTIVIDAD);
		response.addCookie(cookie);

		// ESTADOS
		boolean esValido = usuariosDAL.validar(usuario);

		boolean sinParametros = usuario.getNombre() == null;

		boolean esUsuarioYaRegistrado = session.getAttribute("usuario") != null;

		boolean quiereSalir = "logout".equals(opcion);

		boolean nombreValido = usuario.getNombre() != null && usuario.getNombre().length() >= MINIMO_CARACTERES;
		boolean passValido = !(usuario.getPass() == null || usuario.getPass().length() < MINIMO_CARACTERES);

		// Redirigir a una nueva vista
		if (quiereSalir) {
			session.invalidate();
			request.getRequestDispatcher(RUTA_LOGIN).forward(request, response);
		} else if (esUsuarioYaRegistrado) {
			request.getRequestDispatcher(RUTA_PRINCIPAL).forward(request, response);
			log.info("Usuario ya registrado");
		} else if (sinParametros) {
			request.getRequestDispatcher(RUTA_LOGIN).forward(request, response);
		} else if (!nombreValido || !passValido) {
			usuario.setErrores("El nombre y la pass deben tener como mínimo " + MINIMO_CARACTERES + " caracteres y son ambos requeridos");
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher(RUTA_LOGIN).forward(request, response);
		} else if (esValido) {

			session.setAttribute("usuario", usuariosDAL.buscarPorId(usuario.getNombre()));
			request.getRequestDispatcher(RUTA_PRINCIPAL).forward(request, response);
		} else {
			log.error("El usuario y contraseña introducidos no son válidos");
			//			usuario.setErrores("El usuario y contraseña introducidos no son válidos");
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher(RUTA_LOGIN).forward(request, response);
		}
	}
}
