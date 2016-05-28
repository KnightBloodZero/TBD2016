package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the publicacion_tag database table.
 * 
 */
@Entity
@Table(name="publicacion_tag")
@NamedQuery(name="PublicacionTag.findAll", query="SELECT p FROM PublicacionTag p")
public class PublicacionTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PUBLI_TAG")
	private int idPubliTag;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name="ID_PUBLICACION")
	private Publicacion publicacion;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="ID_TAG")
	private Tag tag;

	public PublicacionTag() {
	}

	public int getIdPubliTag() {
		return this.idPubliTag;
	}

	public void setIdPubliTag(int idPubliTag) {
		this.idPubliTag = idPubliTag;
	}

	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}