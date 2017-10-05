package com.co.developer.parqueaderoREST.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.co.developer.parqueaderoREST.dao.IUsuarioDAO;
import com.co.developer.parqueaderoREST.model.Usuario;

@Repository
public class UsuarioDAO implements IUsuarioDAO {
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Usuario> obtenerListadoUsuarios() {
		
		try {
			Query query = entityManager.createQuery(
					"select user from Usuario user");
			return query.getResultList();
		} catch (Exception e) {
			LOGGER.error("Error consultado usuarios ",e);
			return null;
		}
		

	}

}
