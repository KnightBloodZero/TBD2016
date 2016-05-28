package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ROL")
	private int idRol;

	@Column(name="DESCRIPCIONROL")
	private String descripcionrol;

	@Column(name="NOMBREROL")
	private String nombrerol;

	//bi-directional many-to-one association to PrioridadUsuario
	@ManyToOne
	@JoinColumn(name="ID_PRIORIDADUSUARIO")
	private PrioridadUsuario prioridadUsuario;

	//bi-directional many-to-one association to RolUsuario
	@OneToMany(mappedBy="rol")
	private List<RolUsuario> rolUsuarios;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcionrol() {
		return this.descripcionrol;
	}

	public void setDescripcionrol(String descripcionrol) {
		this.descripcionrol = descripcionrol;
	}

	public String getNombrerol() {
		return this.nombrerol;
	}

	public void setNombrerol(String nombrerol) {
		this.nombrerol = nombrerol;
	}

	public PrioridadUsuario getPrioridadUsuario() {
		return this.prioridadUsuario;
	}

	public void setPrioridadUsuario(PrioridadUsuario prioridadUsuario) {
		this.prioridadUsuario = prioridadUsuario;
	}

	public List<RolUsuario> getRolUsuarios() {
		return this.rolUsuarios;
	}

	public void setRolUsuarios(List<RolUsuario> rolUsuarios) {
		this.rolUsuarios = rolUsuarios;
	}

	public RolUsuario addRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().add(rolUsuario);
		rolUsuario.setRol(this);

		return rolUsuario;
	}

	public RolUsuario removeRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().remove(rolUsuario);
		rolUsuario.setRol(null);

		return rolUsuario;
	}

}