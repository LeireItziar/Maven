package com.ipartek.formacion.leire.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.leire.dal.ProductosDAL;
import com.ipartek.formacion.leire.tipos.Productos;

@WebServlet("/productosform")
public class ProductosFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opprod = request.getParameter("opprodform");

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String id = request.getParameter("id");
		double precio = Double.parseDouble(request.getParameter("precio"));

		RequestDispatcher rutaListadoprod = request.getRequestDispatcher(ProductosCRUDServlet.RUTA_SERVLET_LISTADO);
		//		RequestDispatcher rutaFormulario = request.getRequestDispatcher(ProductosCRUDServlet.RUTA_FORMULARIO);

		if (opprod == null) {
			rutaListadoprod.forward(request, response);
			return;
		}

		Productos producto = new Productos(id, nombre, descripcion, precio);

		ServletContext application = request.getServletContext();
		ProductosDAL dalprod = (ProductosDAL) application.getAttribute("dalprod");

		switch (opprod) {
		case "alta":

			dalprod.alta(producto);
			response.sendRedirect(ProductosCRUDServlet.RUTA_SERVLET_LISTADO);

			break;
		case "modificar":

			dalprod.modificar(producto);
			response.sendRedirect(ProductosCRUDServlet.RUTA_SERVLET_LISTADO);

			break;
		case "borrar":
			dalprod.borrar(producto);
			rutaListadoprod.forward(request, response);

			break;

		}
	}
}
