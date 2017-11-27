package com.co.developer.parqueaderoREST.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.co.developer.parqueaderoREST.dao.IUsuarioDAO;
import com.co.developer.parqueaderoREST.model.Usuario;

@Repository
public class UsuarioDAO implements IUsuarioDAO {
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> obtenerListadoUsuarios() {
		List<Usuario> listaUsuarios = null;
		
		try {
			Query query = entityManager.createQuery(
					"SELECT user FROM Usuario user");
			listaUsuarios  =  query.getResultList();
		} catch (Exception e) {
			LOGGER.error("Error consultado usuarios ",e);
		}
		
		return listaUsuarios;
	}

	@Override
	public Usuario buscarUsuarioPorId(int idUsuario) {
		Usuario usuario = null;
		String jpql = "SELECT user FROM " + Usuario.class.getSimpleName() + " user " 
		+ " WHERE user.idUsuario = :id";
		
		try {
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", idUsuario);
			usuario = (Usuario) query.getSingleResult();
		} catch (NoResultException nre) {
			LOGGER.info("No hay usuario con los parametros de busqueda ", nre);
		} catch (Exception e) {
			LOGGER.error("Error consultado usuario por id ", e);
		}

		return usuario;
	}

	@Override
	@Transactional
	public Usuario guardarUsuario(Usuario usuario) {
		try {
			entityManager.persist(usuario);
			entityManager.flush();
		} catch (Exception e) {
			LOGGER.error("Error guardando el usuario. ",e);
		}
		
		return usuario;
	}

}
