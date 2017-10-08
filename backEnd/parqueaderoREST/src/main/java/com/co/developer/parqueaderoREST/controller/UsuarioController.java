package com.co.developer.parqueaderoREST.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.developer.parqueaderoREST.dao.IUsuarioDAO;
import com.co.developer.parqueaderoREST.model.Usuario;

@RestController
@RequestMapping("/parqueadero/usuario")
public class UsuarioController {
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	
	@RequestMapping(path = "/listado", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> obtenerListadoUsuarios() {
		
		try {
			List<Usuario> listaUsuarios = usuarioDAO.obtenerListadoUsuarios();
			return new ResponseEntity<List<Usuario>>(listaUsuarios, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error obteniendo el listado de usuarios. ", e);
			return new ResponseEntity<List<Usuario>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(path = "/buscarPorId/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable int id){
		
		try {
			Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error buscando usuario por id ",e);
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
