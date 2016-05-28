package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the audio database table.
 * 
 */
@Entity
@NamedQuery(name="Audio.findAll", query="SELECT a FROM Audio a")
public class Audio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_AUDIO")
	private int idAudio;

	@Column(name="DESCRIPCIONAUDIO")
	private String descripcionaudio;

	@Column(name="NOMBREAUDIO")
	private String nombreaudio;

	@Column(name="URLAUDIO")
	private String urlaudio;

	//bi-directional many-to-one association to Publicacion
	@ManyToOne
	@JoinColumn(name="ID_PUBLICACION")
	private Publicacion publicacion;

	public Audio() {
	}

	public int getIdAudio() {
		return this.idAudio;
	}

	public void setIdAudio(int idAudio) {
		this.idAudio = idAudio;
	}

	public String getDescripcionaudio() {
		return this.descripcionaudio;
	}

	public void setDescripcionaudio(String descripcionaudio) {
		this.descripcionaudio = descripcionaudio;
	}

	public String getNombreaudio() {
		return this.nombreaudio;
	}

	public void setNombreaudio(String nombreaudio) {
		this.nombreaudio = nombreaudio;
	}

	public String getUrlaudio() {
		return this.urlaudio;
	}

	public void setUrlaudio(String urlaudio) {
		this.urlaudio = urlaudio;
	}

	public Publicacion getPublicacion() {
		return this.publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

}