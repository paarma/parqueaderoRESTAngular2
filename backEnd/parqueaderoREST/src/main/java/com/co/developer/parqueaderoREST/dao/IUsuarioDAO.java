package com.co.developer.parqueaderoREST.dao;

import java.util.List;

import com.co.developer.parqueaderoREST.model.Usuario;

public interface IUsuarioDAO {
	List<Usuario> obtenerListadoUsuarios();
}