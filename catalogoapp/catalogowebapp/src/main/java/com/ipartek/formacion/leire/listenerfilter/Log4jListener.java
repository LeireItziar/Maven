package com.ipartek.formacion.leire.listenerfilter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.PropertyConfigurator;

/**
 * Application Lifecycle Listener implementation class Log4jListener
 *
 */
@WebListener
public class Log4jListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */

	public Log4jListener() {
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
		//Arranca la configuracion de Log4j
		PropertyConfigurator.configure(sce.getServletContext().getRealPath("/WEB-INF/classes") + "/log4j.properties");
	}

}
