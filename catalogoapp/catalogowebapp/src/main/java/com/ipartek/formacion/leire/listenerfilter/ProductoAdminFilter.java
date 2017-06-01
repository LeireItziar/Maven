package com.ipartek.formacion.leire.listenerfilter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.leire.tipos.Usuario;

/**
 * Servlet Filter implementation class ProductoAdminFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/productoscrud" })
public class ProductoAdminFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ProductoAdminFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpSession session = ((HttpServletRequest) request).getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (!(usuario.isAdmin())) {
			//			request.getRequestDispatcher("/login").forward(request, response);
			request.getRequestDispatcher("/productoslistado").forward(request, response);

		}
		//		request.getRequestDispatcher(arg0)
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
