package com.ipartek.formacion.leire.dal;

import com.ipartek.formacion.leire.dal.UsuariosDAL;
import com.ipartek.formacion.leire.dal.UsuariosDALColeccion;

public class DALFactory {
	public static UsuariosDAL getUsuariosDAL() {
		// return new UsuariosDALUsuarioUnico();
		return new UsuariosDALColeccion();
	}
}
