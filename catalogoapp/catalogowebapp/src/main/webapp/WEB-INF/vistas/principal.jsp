<%@ include file="includes/cabecera.jsp" %>

	
	<jsp:useBean id="usuario" scope="session" 
		class="com.ipartek.formacion.leire.tipos.Usuario" />
	<h2>Bienvenido ${usuario.nombre} </h2>
	
	<br>
	<br>
	<a href="login?opcion=logout">Logout</a>   
	
<!--  	<a href="principal?opcion=aceptar">Aceptar</a>-->
	<a href="productoscrud">Mantenimiento productos</a>
	<br>
	<br>
	<h3><%= new java.util.Date() %></h3>

<%@ include file="includes/pie.jsp" %>