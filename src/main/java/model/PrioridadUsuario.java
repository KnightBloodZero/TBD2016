package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prioridad_usuario database table.
 * 
 */
@Entity
@Table(name="prioridad_usuario")
@NamedQuery(name="PrioridadUsuario.findAll", query="SELECT p FROM PrioridadUsuario p")
public class PrioridadUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PRIORIDADUSUARIO")
	private int idPrioridadusuario;

	@Column(name="DESCRIPCIONPRIORIDADUSUARIO")
	private String descripcionprioridadusuario;

	@Column(name="NOMBREPRIORIDADUSUARIO")
	private String nombreprioridadusuario;

	//bi-directional many-to-one association to Rol
	@OneToMany(mappedBy="prioridadUsuario")
	private List<Rol> rols;

	public PrioridadUsuario() {
	}

	public int getIdPrioridadusuario() {
		return this.idPrioridadusuario;
	}

	public void setIdPrioridadusuario(int idPrioridadusuario) {
		this.idPrioridadusuario = idPrioridadusuario;
	}

	public String getDescripcionprioridadusuario() {
		return this.descripcionprioridadusuario;
	}

	public void setDescripcionprioridadusuario(String descripcionprioridadusuario) {
		this.descripcionprioridadusuario = descripcionprioridadusuario;
	}

	public String getNombreprioridadusuario() {
		return this.nombreprioridadusuario;
	}

	public void setNombreprioridadusuario(String nombreprioridadusuario) {
		this.nombreprioridadusuario = nombreprioridadusuario;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

	public Rol addRol(Rol rol) {
		getRols().add(rol);
		rol.setPrioridadUsuario(this);

		return rol;
	}

	public Rol removeRol(Rol rol) {
		getRols().remove(rol);
		rol.setPrioridadUsuario(null);

		return rol;
	}

}