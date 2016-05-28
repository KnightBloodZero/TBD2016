package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the publicacion database table.
 * 
 */
@Entity
@NamedQuery(name="Publicacion.findAll", query="SELECT p FROM Publicacion p")
public class Publicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PUBLICACION")
	private int idPublicacion;

	@Column(name="DESCRIPCIONPUBLICACION")
	private String descripcionpublicacion;

	@Column(name="FECHAPUBLICACION")
	private Timestamp fechapublicacion;

	@Column(name="NOMBREPUBLICACION")
	private String nombrepublicacion;

	//bi-directional many-to-one association to Audio
	@OneToMany(mappedBy="publicacion")
	private List<Audio> audios;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="publicacion")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Imagen
	@OneToMany(mappedBy="publicacion")
	private List<Imagen> imagens;

	//bi-directional many-to-one association to PrioridadPublicacion
	@ManyToOne
	@JoinColumn(name="ID_PRIORIDADPUBLICACION")
	private PrioridadPublicacion prioridadPublicacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to PublicacionTag
	@OneToMany(mappedBy="publicacion")
	private List<PublicacionTag> publicacionTags;

	//bi-directional many-to-one association to PublicacionTipo
	@OneToMany(mappedBy="publicacion")
	private List<PublicacionTipo> publicacionTipos;

	//bi-directional many-to-one association to Valoracion
	@OneToMany(mappedBy="publicacion")
	private List<Valoracion> valoracions;

	public Publicacion() {
	}

	public int getIdPublicacion() {
		return this.idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public String getDescripcionpublicacion() {
		return this.descripcionpublicacion;
	}

	public void setDescripcionpublicacion(String descripcionpublicacion) {
		this.descripcionpublicacion = descripcionpublicacion;
	}

	public Timestamp getFechapublicacion() {
		return this.fechapublicacion;
	}

	public void setFechapublicacion(Timestamp fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}

	public String getNombrepublicacion() {
		return this.nombrepublicacion;
	}

	public void setNombrepublicacion(String nombrepublicacion) {
		this.nombrepublicacion = nombrepublicacion;
	}

	public List<Audio> getAudios() {
		return this.audios;
	}

	public void setAudios(List<Audio> audios) {
		this.audios = audios;
	}

	public Audio addAudio(Audio audio) {
		getAudios().add(audio);
		audio.setPublicacion(this);

		return audio;
	}

	public Audio removeAudio(Audio audio) {
		getAudios().remove(audio);
		audio.setPublicacion(null);

		return audio;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setPublicacion(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setPublicacion(null);

		return comentario;
	}

	public List<Imagen> getImagens() {
		return this.imagens;
	}

	public void setImagens(List<Imagen> imagens) {
		this.imagens = imagens;
	}

	public Imagen addImagen(Imagen imagen) {
		getImagens().add(imagen);
		imagen.setPublicacion(this);

		return imagen;
	}

	public Imagen removeImagen(Imagen imagen) {
		getImagens().remove(imagen);
		imagen.setPublicacion(null);

		return imagen;
	}

	public PrioridadPublicacion getPrioridadPublicacion() {
		return this.prioridadPublicacion;
	}

	public void setPrioridadPublicacion(PrioridadPublicacion prioridadPublicacion) {
		this.prioridadPublicacion = prioridadPublicacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<PublicacionTag> getPublicacionTags() {
		return this.publicacionTags;
	}

	public void setPublicacionTags(List<PublicacionTag> publicacionTags) {
		this.publicacionTags = publicacionTags;
	}

	public PublicacionTag addPublicacionTag(PublicacionTag publicacionTag) {
		getPublicacionTags().add(publicacionTag);
		publicacionTag.setPublicacion(this);

		return publicacionTag;
	}

	public PublicacionTag removePublicacionTag(PublicacionTag publicacionTag) {
		getPublicacionTags().remove(publicacionTag);
		publicacionTag.setPublicacion(null);

		return publicacionTag;
	}

	public List<PublicacionTipo> getPublicacionTipos() {
		return this.publicacionTipos;
	}

	public void setPublicacionTipos(List<PublicacionTipo> publicacionTipos) {
		this.publicacionTipos = publicacionTipos;
	}

	public PublicacionTipo addPublicacionTipo(PublicacionTipo publicacionTipo) {
		getPublicacionTipos().add(publicacionTipo);
		publicacionTipo.setPublicacion(this);

		return publicacionTipo;
	}

	public PublicacionTipo removePublicacionTipo(PublicacionTipo publicacionTipo) {
		getPublicacionTipos().remove(publicacionTipo);
		publicacionTipo.setPublicacion(null);

		return publicacionTipo;
	}

	public List<Valoracion> getValoracions() {
		return this.valoracions;
	}

	public void setValoracions(List<Valoracion> valoracions) {
		this.valoracions = valoracions;
	}

	public Valoracion addValoracion(Valoracion valoracion) {
		getValoracions().add(valoracion);
		valoracion.setPublicacion(this);

		return valoracion;
	}

	public Valoracion removeValoracion(Valoracion valoracion) {
		getValoracions().remove(valoracion);
		valoracion.setPublicacion(null);

		return valoracion;
	}

}