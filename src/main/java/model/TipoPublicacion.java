package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_publicacion database table.
 * 
 */
@Entity
@Table(name="tipo_publicacion")
@NamedQuery(name="TipoPublicacion.findAll", query="SELECT t FROM TipoPublicacion t")
public class TipoPublicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_TIPOPUBLICACION")
	private int idTipopublicacion;

	@Column(name="DESCRIPCIONTIPOPUBLI")
	private String descripciontipopubli;

	@Column(name="NOMBRETIPOPUBLI")
	private String nombretipopubli;

	//bi-directional many-to-one association to PublicacionTipo
	@OneToMany(mappedBy="tipoPublicacion")
	private List<PublicacionTipo> publicacionTipos;

	public TipoPublicacion() {
	}

	public int getIdTipopublicacion() {
		return this.idTipopublicacion;
	}

	public void setIdTipopublicacion(int idTipopublicacion) {
		this.idTipopublicacion = idTipopublicacion;
	}

	public String getDescripciontipopubli() {
		return this.descripciontipopubli;
	}

	public void setDescripciontipopubli(String descripciontipopubli) {
		this.descripciontipopubli = descripciontipopubli;
	}

	public String getNombretipopubli() {
		return this.nombretipopubli;
	}

	public void setNombretipopubli(String nombretipopubli) {
		this.nombretipopubli = nombretipopubli;
	}

	public List<PublicacionTipo> getPublicacionTipos() {
		return this.publicacionTipos;
	}

	public void setPublicacionTipos(List<PublicacionTipo> publicacionTipos) {
		this.publicacionTipos = publicacionTipos;
	}

	public PublicacionTipo addPublicacionTipo(PublicacionTipo publicacionTipo) {
		getPublicacionTipos().add(publicacionTipo);
		publicacionTipo.setTipoPublicacion(this);

		return publicacionTipo;
	}

	public PublicacionTipo removePublicacionTipo(PublicacionTipo publicacionTipo) {
		getPublicacionTipos().remove(publicacionTipo);
		publicacionTipo.setTipoPublicacion(null);

		return publicacionTipo;
	}

}