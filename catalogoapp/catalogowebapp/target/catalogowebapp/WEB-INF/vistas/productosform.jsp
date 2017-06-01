<%@ include file="includes/cabecera.jsp" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<h2>Productos</h2>
	
	<jsp:useBean id="producto" scope="request"
		class="com.ipartek.formacion.leire.tipos.Productos" />

	<form action="productosform" method="post">
		<fieldset>
			<label for="id">ID</label> 
			
			<input id="id" name="id" required="required" value="${producto.id}" 
			<c:if test="${param.opprod == 'modificar' or param.opprod == 'borrar'}">
			  	readonly="readonly"
			  </c:if>   
		  />
		</fieldset>
		<fieldset>
			<label for="nombre">Nombre</label> <input type="text" id="nombre"
				name="nombre" value="${producto.nombre}"/>
		</fieldset>
		<fieldset>
			<label for="descripcion">Descripcion</label> <input type="text" id="descripcion"
				name="descripcion" value="${producto.descripcion}"/>
		</fieldset>
		<fieldset>
			<label for="precio">Precio</label> <input type="number" id="precio"
				name="precio" value="${producto.precio}"/>
		
		<input type="submit" value="${fn:toUpperCase(param.opprod)}" />
		<input type="hidden" name="opprodform" value="${param.opprod}" />
	</fieldset>
	</form>
	
	
<%@ include file="includes/pie.jsp" %>
