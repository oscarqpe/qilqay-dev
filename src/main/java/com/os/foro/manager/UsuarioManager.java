package com.os.foro.manager;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;
import java.util.logging.Logger;

import com.googlecode.objectify.cmd.Query;
import com.os.foro.entity.UsuarioDto;
import com.os.foro.util.OsUtil;
/**
 * 
 * @author OscarEdmit
 *
 */
public class UsuarioManager {

	private static final Logger LOGGER = Logger.getLogger(UsuarioManager.class.getName());
	
	Query<UsuarioDto> query = ofy().load().type(UsuarioDto.class);
	
	public UsuarioDto registrarUsuario(UsuarioDto usuario) {
		ofy().save().entity(usuario).now();
		usuario = query.filter("email", usuario.getEmail()).first().now();
		return usuario;
	}
	public List<UsuarioDto> listaUsuarios() {
		return query.list();
	}
	public UsuarioDto getUsuario(Long idUsuario) {
		return ofy().load().type(UsuarioDto.class).id(idUsuario).get();
	}
	public UsuarioDto login (String username, String password) {
		UsuarioDto usuario = query.filter("username", username).filter("password", OsUtil.getSecurePassword(password)).first().now();
		return usuario;
	}
}
