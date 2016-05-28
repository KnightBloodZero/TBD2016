package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the publicacion_tipo database table.
 * 
 */
@Entity
@Table(name="publicacion_tipo")
@NamedQuery(name="PublicacionTipo.findAll", query="SELECT p FROM PublicacionTipo p")
public class PublicacionTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PUBLI_TIPO")
	private int idPubliTipo;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name="ID_PUBLICACION")
	private Publicacion publicacion;

	//bi-directional many-to-one association to TipoPublicacion
	@ManyToOne
	@JoinColumn(name="ID_TIPOPUBLICACION")
	private TipoPublicacion tipoPublicacion;

	public PublicacionTipo() {
	}

	public int getIdPubliTipo() {
		return this.idPubliTipo;
	}

	public void setIdPubliTipo(int idPubliTipo) {
		this.idPubliTipo = idPubliTipo;
	}

	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public TipoPublicacion getTipoPublicacion() {
		return this.tipoPublicacion;
	}

	public void setTipoPublicacion(TipoPublicacion tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}

}