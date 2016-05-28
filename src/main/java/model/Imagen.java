package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the imagen database table.
 * 
 */
@Entity
@NamedQuery(name="Imagen.findAll", query="SELECT i FROM Imagen i")
public class Imagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_IMAGEN")
	private int idImagen;

	@Column(name="DESCRIPCIONIMAGEN")
	private String descripcionimagen;

	@Column(name="NOMBREIMAGEN")
	private String nombreimagen;

	@Column(name="URLIMAGEN")
	private String urlimagen;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name="ID_PUBLICACION")
	private Publicacion publicacion;

	public Imagen() {
	}

	public int getIdImagen() {
		return this.idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public String getDescripcionimagen() {
		return this.descripcionimagen;
	}

	public void setDescripcionimagen(String descripcionimagen) {
		this.descripcionimagen = descripcionimagen;
	}

	public String getNombreimagen() {
		return this.nombreimagen;
	}

	public void setNombreimagen(String nombreimagen) {
		this.nombreimagen = nombreimagen;
	}

	public String getUrlimagen() {
		return this.urlimagen;
	}

	public void setUrlimagen(String urlimagen) {
		this.urlimagen = urlimagen;
	}

	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

}