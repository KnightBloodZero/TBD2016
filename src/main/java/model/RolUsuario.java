package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rol_usuario database table.
 * 
 */
@Entity
@Table(name="rol_usuario")
@NamedQuery(name="RolUsuario.findAll", query="SELECT r FROM RolUsuario r")
public class RolUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ROL_USUARIO")
	private int idRolUsuario;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public RolUsuario() {
	}

	public int getIdRolUsuario() {
		return this.idRolUsuario;
	}

	public void setIdRolUsuario(int idRolUsuario) {
		this.idRolUsuario = idRolUsuario;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}