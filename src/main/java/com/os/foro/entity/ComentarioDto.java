package com.os.foro.entity;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import com.googlecode.objectify.annotation.OnLoad;
/**
 * 
 * @author OscarEdmit
 *
 */
@Entity
public class ComentarioDto {
	@Id
	private Long id;
	@Index
	private String descripcion;
	@Index @Load
	private Ref<UsuarioDto> usuario;
	
	@Ignore
	private UsuarioDto usuarioRef;
	
	@OnLoad
	public void getRefs() {
		if (usuario.isLoaded())
			if (usuario != null)
				usuarioRef = usuario.get();
	}
	
	public ComentarioDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public UsuarioDto getUsuario() {
		return usuario.get();
	}
	public void setUsuario(UsuarioDto usuario) {
		this.usuario = Ref.create(usuario);
	}
	public UsuarioDto getUsuarioRef() {
		return usuarioRef;
	}

	public void setUsuarioRef(UsuarioDto usuarioRef) {
		this.usuarioRef = usuarioRef;
	}

	@Override
	public String toString() {
		return "ComentarioDto [id=" + id + ", descripcion=" + descripcion
				+ ", usuario=" + usuario + "]";
	}
	
}
