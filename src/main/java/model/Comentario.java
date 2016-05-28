package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comentario database table.
 * 
 */
@Entity
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_COMENTARIO")
	private int idComentario;

	@Column(name="TEXTOCOMENTARIO")
	private String textocomentario;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name="ID_PUBLICACION")
	private Publicacion publicacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Comentario() {
	}

	public int getIdComentario() {
		return this.idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getTextocomentario() {
		return this.textocomentario;
	}

	public void setTextocomentario(String textocomentario) {
		this.textocomentario = textocomentario;
	}

	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}