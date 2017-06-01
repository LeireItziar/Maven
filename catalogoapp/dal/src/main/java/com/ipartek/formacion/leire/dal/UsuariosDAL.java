package com.ipartek.formacion.leire.dal;

import com.ipartek.formacion.leire.tipos.Usuario;

public interface UsuariosDAL {
	public void alta(Usuario usuario);

	public void modificar(Usuario usuario);

	public void borrar(Usuario usuario);

	public Usuario buscarPorId(String idusu);

	public Usuario[] buscarTodosLosUsuarios();

	public boolean validar(Usuario usuario);
}
