package com.ipartek.formacion.leire.dal;

import com.ipartek.formacion.leire.tipos.Productos;

public interface ProductosDAL {
	public void alta(Productos producto);

	public void modificar(Productos producto);

	public void borrar(Productos producto);

	public Productos buscarPorId(String id);

	public Productos[] buscarTodosLosProductos();

	public boolean productoExiste(Productos producto);

}
