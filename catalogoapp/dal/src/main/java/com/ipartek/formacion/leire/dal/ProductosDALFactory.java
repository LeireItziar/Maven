package com.ipartek.formacion.leire.dal;

//import com.ipartek.productos.leire.dal.ProductosDALColeccion;

public class ProductosDALFactory {
	public static ProductosDAL getProductosDAL() {

		return new ProductosDALColeccion();
	}
}
