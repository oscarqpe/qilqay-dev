package com.os.foro.entity;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.os.foro.entity.ComentarioDto;
/**
 * 
 * @author OscarEdmit
 *
 */
@Entity
public class TemaDto {
	@Id
	private Long id;
	@Index
	private String titulo;
	@Index
	private String contenido;
	@Index
	private List<Ref<ComentarioDto>> comentarios;
	
	
	public TemaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public List<ComentarioDto> getComentarios() {
        List<ComentarioDto> comentarios = new ArrayList<ComentarioDto>();
        if (this.comentarios != null) {
            for (Ref<ComentarioDto> cat : this.comentarios) {
                comentarios.add(cat.get());
            }
            return comentarios;
        } else {
            return null;
        }
    }

    public void setComentarios(List<ComentarioDto> p_comentarios) {
        List<Ref<ComentarioDto>> comentarios = new ArrayList<Ref<ComentarioDto>>();
        for (ComentarioDto comentario : p_comentarios) {
            comentarios.add(Ref.create(comentario));
        }
        this.comentarios = comentarios;
    }
	@Override
	public String toString() {
		return "TemaDto [id=" + id + ", titulo=" + titulo + ", contenido="
				+ contenido + ", comentarios=" + comentarios + "]";
	}
}
