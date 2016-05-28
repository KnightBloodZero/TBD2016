package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prioridad_publicacion database table.
 * 
 */
@Entity
@Table(name="prioridad_publicacion")
@NamedQuery(name="PrioridadPublicacion.findAll", query="SELECT p FROM PrioridadPublicacion p")
public class PrioridadPublicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PRIORIDADPUBLICACION")
	private int idPrioridadpublicacion;

	@Column(name="DESCRIPCIONPRIORIDADPUBLICACION")
	private String descripcionprioridadpublicacion;

	@Column(name="NOMBREPRIORIDADPUBLICACION")
	private String nombreprioridadpublicacion;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="prioridadPublicacion")
	private List<Publicacion> publicacions;

	public PrioridadPublicacion() {
	}

	public int getIdPrioridadpublicacion() {
		return this.idPrioridadpublicacion;
	}

	public void setIdPrioridadpublicacion(int idPrioridadpublicacion) {
		this.idPrioridadpublicacion = idPrioridadpublicacion;
	}

	public String getDescripcionprioridadpublicacion() {
		return this.descripcionprioridadpublicacion;
	}

	public void setDescripcionprioridadpublicacion(String descripcionprioridadpublicacion) {
		this.descripcionprioridadpublicacion = descripcionprioridadpublicacion;
	}

	public String getNombreprioridadpublicacion() {
		return this.nombreprioridadpublicacion;
	}

	public void setNombreprioridadpublicacion(String nombreprioridadpublicacion) {
		this.nombreprioridadpublicacion = nombreprioridadpublicacion;
	}

	public List<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(List<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

	public Publicacion addPublicacion(Publicacion publicacion) {
		getPublicacions().add(publicacion);
		publicacion.setPrioridadPublicacion(this);

		return publicacion;
	}

	public Publicacion removePublicacion(Publicacion publicacion) {
		getPublicacions().remove(publicacion);
		publicacion.setPrioridadPublicacion(null);

		return publicacion;
	}

}