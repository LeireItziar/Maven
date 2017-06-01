package com.ipartek.formacion.leire.dal;

import java.util.HashMap;
import java.util.Map;

import com.ipartek.formacion.leire.tipos.Usuario;

public class UsuariosDALColeccion implements UsuariosDAL {

	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

	public void alta(Usuario usuario) {
		if (usuarios.containsKey(usuario.getNombre()))
			throw new UsuarioYaExistenteDALException("Ya existe el usuario " + usuario.getNombre());

		usuarios.put(usuario.getNombre(), usuario);
	}

	public boolean validar(Usuario usuario) {
		return usuarios.containsKey(usuario.getNombre());
	}

	public void modificar(Usuario usuario) {
		if (!usuarios.containsKey(usuario.getNombre()))
			throw new DALException("Intento de modificar usuario no existente " + usuario);

		usuarios.put(usuario.getNombre(), usuario);
	}

	public void borrar(Usuario usuario) {
		usuarios.remove(usuario.getNombre());
	}

	public Usuario buscarPorId(String idusu) {
		return usuarios.get(idusu);
	}

	public Usuario[] buscarTodosLosUsuarios() {

		return usuarios.values().toArray(new Usuario[usuarios.size()]);
	}

}
