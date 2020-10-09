package br.com.usuario.controller;

import br.com.usuario.dao.impl.DaoFactory;
import br.com.usuario.dao.impl.UsuarioDAO;
import br.com.usuario.model.Usuario;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UsuarioController {
	
	Usuario usuario = new Usuario();
	UsuarioDAO usuarioDAO = DaoFactory.createUsuarioDAO();
	
	private Usuario jsonToUsuario(JSONObject json) throws JSONException, ParseException{
			Usuario usuario = new Usuario();
			DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
			
			try {
				
				usuario.setNome(json.getString("nome"));
				usuario.setSenha(json.getString("senha"));
				
				Date date = df.parse(json.getString("dataCadastro"));
				usuario.setDataCadastro(date);
				
			} catch (JSONException e) {
					e.printStackTrace();
			}
			
			return usuario;
	}
	
	private JSONObject usuarioToJson(Usuario usuario) throws JSONException {
			JSONObject json = new JSONObject();
			
			try {
				
				json.put("id", usuario.getId());
				json.put("nome", usuario.getNome());
				json.put("senha", usuario.getSenha());
				json.put("dataCadastro", usuario.getDataCadastro());
				return json;
			} catch (JSONException e) {
				
				JSONObject jsonErro = new JSONObject();
				jsonErro.put("erro", e.getMessage());
				return jsonErro;
			}
	}
	
	public JSONObject Create(JSONObject json) throws ParseException, JSONException {
		
		usuario = jsonToUsuario(json);
		usuarioDAO.insert(usuario);
		System.out.println("Cadastro Efetuado");
		
		return usuarioToJson(usuario);
	}
	
	public JSONObject Show (Integer id) throws JSONException {
		JSONObject json = new JSONObject();
		
		try {
			
			usuario = usuarioDAO.findById(id);
			
			return usuarioToJson(usuario);
			
		} catch (JSONException e) {
			
			json.put("erro", e.getMessage());
			return json;
		}
	}
	
	public JSONObject Edit (JSONObject json) throws ParseException, JSONException {
		
		usuario = jsonToUsuario(json);
		usuarioDAO.update(usuario);
		
		return usuarioToJson(usuario);
	}	
	
	public JSONArray Index() {
		
		List<Usuario> usuarios = usuarioDAO.findAll();
		JSONArray json = new JSONArray();
		
		usuarios.forEach(usuarioAtual -> {
				try {
					json.put(usuarioToJson(usuarioAtual));
				} catch (JSONException e) {
						e.printStackTrace();
				}
		});
		return json;
	}
	
	public JSONObject Delete (Integer id) throws JSONException {
		JSONObject json = new JSONObject();
		
		try {
			usuarioDAO.deleteById(id);
			return usuarioToJson(usuario);
			
		} catch (Exception e) {
			json.put("Erro" , e.getMessage());
			return json;
		}
	}
}
