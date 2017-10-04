package com.co.developer.parqueaderoREST.dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.developer.parqueaderoREST.model.Usuario;

@Transactional
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

}
