package com.co.developer.parqueaderoREST.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.developer.parqueaderoREST.dao.UsuarioDAO;
import com.co.developer.parqueaderoREST.model.Usuario;

@RestController
@RequestMapping("/parqueadero/usuario")
public class UsuarioController {
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	@RequestMapping(path = "/listadoUsuarios", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> obtenerListadoUsuarios() {

		List<Usuario> listaUsuarios = null;

		try {
			listaUsuarios = usuarioDAO.findAll();
		} catch (Exception e) {
			LOGGER.error("Error obteniendo el listado de usuarios. ", e);
		}

		return new ResponseEntity<List<Usuario>>(listaUsuarios, HttpStatus.OK);
	}
	
}
