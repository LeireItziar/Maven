<%@ include file="includes/cabeceralogin.jsp" %>

	<h2>Login</h2>
	
	<jsp:useBean id="usuario" scope="request"
		class="com.ipartek.formacion.leire.tipos.Usuario" />

	<form action="login" method="post">
		<fieldset>
			<label for="nombre">Nombre</label> <input id="nombre" name="nombre"
			  required="required" value="${usuario.nombre}" />
		</fieldset>
		<fieldset>
			<label for="pass">Contraseña</label> <input type="password" id="pass"
				name="pass" value="${usuario.pass}" />
		</fieldset>
		<fieldset>
		
		 	<input type="submit" value="Login" /> 
			<!-- <p class="errores">${usuario.errores}</p> -->
		</fieldset>
	</form>
<%@ include file="includes/pie.jsp" %>