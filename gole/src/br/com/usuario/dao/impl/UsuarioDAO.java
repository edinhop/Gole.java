package br.com.usuario.dao.impl;

import java.util.List;

import br.com.usuario.model.Usuario;


public interface UsuarioDAO {
	
	void insert (Usuario obj);
	
	void update (Usuario obj);
	
	void deleteById (Integer id);
	
	Usuario findById (Integer id);
	
	List<Usuario> findAll();
	
}
