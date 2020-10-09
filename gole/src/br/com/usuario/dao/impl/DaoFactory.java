package br.com.usuario.dao.impl;

import db.DB;

public class DaoFactory {
	
	public static UsuarioDAO createUsuarioDAO() {
		return new UsuarioDaoJDBC(DB.getConnection());
	}
}
