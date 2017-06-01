package com.ipartek.formacion.leire.dal;

import java.util.HashMap;
import java.util.Map;

import com.ipartek.formacion.leire.tipos.Productos;

public class ProductosDALColeccion implements ProductosDAL {
	private Map<String, Productos> productos = new HashMap<String, Productos>();

	public void alta(Productos producto) {
		if (productos.containsKey(producto.getId()))
			throw new ProductoExistenteException("Producto existente" + producto.getId());

		productos.put(producto.getId(), producto);

	}

	public void modificar(Productos producto) {

		productos.put(producto.getId(), producto);

	}

	public void borrar(Productos producto) {
		productos.remove(producto.getId());

	}

	public Productos buscarPorId(String id) {
		return productos.get(id);
	}

	public Productos[] buscarTodosLosProductos() {
		return productos.values().toArray(new Productos[productos.size()]);
	}

	public boolean productoExiste(Productos producto) {
		return productos.containsKey(producto);
	}
}
