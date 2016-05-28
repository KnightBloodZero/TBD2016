package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_USUARIO")
	private int idUsuario;

	@Column(name="APELLIDOUSUARIO")
	private String apellidousuario;

	@Column(name="CELULARUSUARIO")
	private String celularusuario;

	@Column(name="EMAILUSUARIO")
	private String emailusuario;

	@Column(name="NICKNAMEUSUARIO")
	private String nicknameusuario;

	@Column(name="NOMBREUSUARIO")
	private String nombreusuario;

	@Column(name="PASSWORDUSUARIO")
	private String passwordusuario;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="usuario")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Publicacion
	@OneToMany(mappedBy="usuario")
	private List<Publicacion> publicacions;

	//bi-directional many-to-one association to RolUsuario
	@OneToMany(mappedBy="usuario")
	private List<RolUsuario> rolUsuarios;

	//bi-directional many-to-one association to Valoracion
	@OneToMany(mappedBy="usuario")
	private List<Valoracion> valoracions;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidousuario() {
		return this.apellidousuario;
	}

	public void setApellidousuario(String apellidousuario) {
		this.apellidousuario = apellidousuario;
	}

	public String getCelularusuario() {
		return this.celularusuario;
	}

	public void setCelularusuario(String celularusuario) {
		this.celularusuario = celularusuario;
	}

	public String getEmailusuario() {
		return this.emailusuario;
	}

	public void setEmailusuario(String emailusuario) {
		this.emailusuario = emailusuario;
	}

	public String getNicknameusuario() {
		return this.nicknameusuario;
	}

	public void setNicknameusuario(String nicknameusuario) {
		this.nicknameusuario = nicknameusuario;
	}

	public String getNombreusuario() {
		return this.nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getPasswordusuario() {
		return this.passwordusuario;
	}

	public void setPasswordusuario(String passwordusuario) {
		this.passwordusuario = passwordusuario;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setUsuario(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setUsuario(null);

		return comentario;
	}

	public List<Publicacion> getPublicacions() {
		return this.publicacions;
	}

	public void setPublicacions(List<Publicacion> publicacions) {
		this.publicacions = publicacions;
	}

	public Publicacion addPublicacion(Publicacion publicacion) {
		getPublicacions().add(publicacion);
		publicacion.setUsuario(this);

		return publicacion;
	}

	public Publicacion removePublicacion(Publicacion publicacion) {
		getPublicacions().remove(publicacion);
		publicacion.setUsuario(null);

		return publicacion;
	}

	public List<RolUsuario> getRolUsuarios() {
		return this.rolUsuarios;
	}

	public void setRolUsuarios(List<RolUsuario> rolUsuarios) {
		this.rolUsuarios = rolUsuarios;
	}

	public RolUsuario addRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().add(rolUsuario);
		rolUsuario.setUsuario(this);

		return rolUsuario;
	}

	public RolUsuario removeRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().remove(rolUsuario);
		rolUsuario.setUsuario(null);

		return rolUsuario;
	}

	public List<Valoracion> getValoracions() {
		return this.valoracions;
	}

	public void setValoracions(List<Valoracion> valoracions) {
		this.valoracions = valoracions;
	}

	public Valoracion addValoracion(Valoracion valoracion) {
		getValoracions().add(valoracion);
		valoracion.setUsuario(this);

		return valoracion;
	}

	public Valoracion removeValoracion(Valoracion valoracion) {
		getValoracions().remove(valoracion);
		valoracion.setUsuario(null);

		return valoracion;
	}

}