package com.ipartek.formacion.leire.listenerfilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.leire.dal.DALFactory;
import com.ipartek.formacion.leire.dal.ProductosDAL;
import com.ipartek.formacion.leire.dal.ProductosDALFactory;
import com.ipartek.formacion.leire.dal.UsuariosDAL;
import com.ipartek.formacion.leire.tipos.Productos;
import com.ipartek.formacion.leire.tipos.Usuario;

/**
 * Application Lifecycle Listener implementation class InicioDALListener
 *
 */
@WebListener
public class InicioDALListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public InicioDALListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext application = sce.getServletContext();
		ProductosDAL dalprod = (ProductosDAL) application.getAttribute("dalprod");
		dalprod = ProductosDALFactory.getProductosDAL();
		dalprod.alta(new Productos("1", "Libro1", "Libroewfoñjkjjj", 20.67));
		dalprod.alta(new Productos("2", "Libro33", "urthfrhj", 5));
		application.setAttribute("dalprod", dalprod);

		UsuariosDAL usuariosDAL = (UsuariosDAL) application.getAttribute("UsuariosDAL");
		usuariosDAL = DALFactory.getUsuariosDAL();
		usuariosDAL.alta(new Usuario("Leire", "leire", false));
		usuariosDAL.alta(new Usuario("admin", "admin", true));
		application.setAttribute("UsuariosDAL", usuariosDAL);

	}
}
