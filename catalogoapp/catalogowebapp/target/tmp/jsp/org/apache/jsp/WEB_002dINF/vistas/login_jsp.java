package org.apache.jsp.WEB_002dINF.vistas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/vistas/includes/cabeceralogin.jsp");
    _jspx_dependants.add("/WEB-INF/vistas/includes/pie.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\" />\r\n");
      out.write("<title>Tienda</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/estilos.css\" />\r\n");
      out.write("<script src=\"js/funciones.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t<h1>Usuarios</h1>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</header>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<h2>Login</h2>\r\n");
      out.write("\t\r\n");
      out.write("\t");
      com.ipartek.formacion.leire.tipos.Usuario usuario = null;
      synchronized (request) {
        usuario = (com.ipartek.formacion.leire.tipos.Usuario) _jspx_page_context.getAttribute("usuario", PageContext.REQUEST_SCOPE);
        if (usuario == null){
          usuario = new com.ipartek.formacion.leire.tipos.Usuario();
          _jspx_page_context.setAttribute("usuario", usuario, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<form action=\"login\" method=\"post\">\r\n");
      out.write("\t\t<fieldset>\r\n");
      out.write("\t\t\t<label for=\"nombre\">Nombre</label> <input id=\"nombre\" name=\"nombre\"\r\n");
      out.write("\t\t\t  required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t\t<fieldset>\r\n");
      out.write("\t\t\t<label for=\"pass\">Contraseña</label> <input type=\"password\" id=\"pass\"\r\n");
      out.write("\t\t\t\tname=\"pass\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.pass}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t\t<fieldset>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t \t<input type=\"submit\" value=\"Login\" /> \r\n");
      out.write("\t\t\t<!-- <p class=\"errores\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.errores}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p> -->\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<p>&copy;2017 Leire Munarriz...</p>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
