package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the valoracion database table.
 * 
 */
@Entity
@NamedQuery(name="Valoracion.findAll", query="SELECT v FROM Valoracion v")
public class Valoracion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_VALORACION")
	private int idValoracion;

	@Column(name="VALORVALORACION")
	private int valorvaloracion;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name="ID_PUBLICACION")
	private Publicacion publicacion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Valoracion() {
	}

	public int getIdValoracion() {
		return this.idValoracion;
	}

	public void setIdValoracion(int idValoracion) {
		this.idValoracion = idValoracion;
	}

	public int getValorvaloracion() {
		return this.valorvaloracion;
	}

	public void setValorvaloracion(int valorvaloracion) {
		this.valorvaloracion = valorvaloracion;
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