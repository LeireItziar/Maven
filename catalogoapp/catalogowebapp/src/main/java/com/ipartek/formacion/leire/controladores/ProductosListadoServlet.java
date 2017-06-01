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

import com.ipartek.formacion.leire.dal.ProductosDAL;
import com.ipartek.formacion.leire.tipos.Productos;

@WebServlet("/productoslistado")
public class ProductosListadoServlet extends HttpServlet {
	static final String RUTA_LISTADO = "/WEB-INF/vistas/productoscrud.jsp";
	static final String RUTA_FORMULARIO = "/WEB-INF/vistas/productosform.jsp";
	static final String RUTA_SERVLET_LISTADO = "productoscrud";
	static final String RUTA_ADMIN = "/WEB-INF/vistas/administrar.jsp";
	static final String RUTA_PRODLIST = "/WEB-INF/vistas/productoslistado.jsp";
	//	private static final String RUTA_LOGIN = "/WEB-INF/vistas/login.jsp";

	public static final int TIEMPO_INACTIVIDAD = 30 * 60;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		ProductosDAL dalprod = (ProductosDAL) application.getAttribute("dalprod");
		//		if (dalprod == null) {
		//			dalprod = ProductosDALFactory.getProductosDAL();
		//			dalprod.alta(new Productos("1", "Libro1", "Libroewfoñjkjjj", 20.67));
		//			dalprod.alta(new Productos("2", "Libro33", "urthfrhj", 5));
		//			application.setAttribute("dalprod", dalprod);
		//		}

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(TIEMPO_INACTIVIDAD);

		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(TIEMPO_INACTIVIDAD);
		response.addCookie(cookie);

		//		String opprod = request.getParameter("opprod");
		//		if (opprod == null) {
		Productos[] producto = dalprod.buscarTodosLosProductos();
		request.setAttribute("producto", producto);
		//			request.getRequestDispatcher(RUTA_LISTADO).forward(request, response);
		request.getRequestDispatcher(RUTA_PRODLIST).forward(request, response);
		//		} else {
		//			String id = request.getParameter("id");
		//			Productos producto;
		//		}
		//			switch (opprod) {
		//
		//			case "mantenimiento":
		//				request.getRequestDispatcher(RUTA_FORMULARIO).forward(request, response);
		//				break;
		//			case "modificar":
		//				producto = dalprod.buscarPorId(id);
		//				request.setAttribute("producto", producto);
		//				request.getRequestDispatcher(RUTA_FORMULARIO).forward(request, response);
		//				break;
		//			case "borrar":
		//				producto = dalprod.buscarPorId(id);
		//				dalprod.borrar(producto);
		//				response.sendRedirect(ProductosListadoServlet.RUTA_SERVLET_LISTADO);
		//				break;
		//			case "alta":
		//				request.getRequestDispatcher(RUTA_FORMULARIO).forward(request, response);
		//				break;
		//			case "atras":
		//				request.getRequestDispatcher(RUTA_ADMIN).forward(request, response);
		//				break;
		////			case "logout":
		////				session.invalidate();
		////				request.getRequestDispatcher(RUTA_LOGIN).forward(request, response);
		//			default:
		//				request.getRequestDispatcher(RUTA_PRODLIST).forward(request, response);
		//			}
		//		}
		//
	}
}
