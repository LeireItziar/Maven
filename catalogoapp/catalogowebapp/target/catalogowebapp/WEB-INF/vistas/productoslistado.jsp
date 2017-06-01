<%@ include file="includes/cabecera.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Listado de productos</h2>

<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Precio</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.producto}" var="producto">
			<tr>
				<td>${producto.id}</td>
				<td>${producto.nombre}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.precio}</td>
				
				
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="login?opcion=logout">Logout</a>


<%@ include file="includes/pie.jsp"%>