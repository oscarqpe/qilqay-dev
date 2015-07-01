package com.os.foro.entity;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.OnLoad;
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
	@Index
	private double rate;
	@Ignore
	private Integer votos;
	
	@OnLoad
    public void getRefs() {
		this.votos = ofy().load().type(RatingDto.class)
				.ancestor(Key.create(this)).list().size();
	}
	
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
    
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public Integer getVotos() {
		return votos;
	}
	public void setVotos(Integer votos) {
		this.votos = votos;
	}
	@Override
	public String toString() {
		return "TemaDto [id=" + id + ", titulo=" + titulo + ", contenido="
				+ contenido + ", comentarios=" + comentarios + "]";
	}
}
