<%@ include file="includes/cabecera.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Mantenimiento de productos</h2>

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
				<td>
					<a href="?opprod=modificar&id=${producto.id}">Modificar</a>
				</td>
				<td>
					<a href="?opprod=borrar&id=${producto.id}">Borrar</a>
				</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>
<center><a href="?opprod=alta">Alta</a> &nbsp;&nbsp;&nbsp;<a href="#">Volver</a></center> 

<%@ include file="includes/pie.jsp"%>