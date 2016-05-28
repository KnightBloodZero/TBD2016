package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_TAG")
	private int idTag;

	@Column(name="DESCRIPCIONTAG")
	private String descripciontag;

	@Column(name="NOMBRETAG")
	private String nombretag;

	//bi-directional many-to-one association to PublicacionTag
	@OneToMany(mappedBy="tag")
	private List<PublicacionTag> publicacionTags;

	public Tag() {
	}

	public int getIdTag() {
		return this.idTag;
	}

	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	public String getDescripciontag() {
		return this.descripciontag;
	}

	public void setDescripciontag(String descripciontag) {
		this.descripciontag = descripciontag;
	}

	public String getNombretag() {
		return this.nombretag;
	}

	public void setNombretag(String nombretag) {
		this.nombretag = nombretag;
	}

	public List<PublicacionTag> getPublicacionTags() {
		return this.publicacionTags;
	}

	public void setPublicacionTags(List<PublicacionTag> publicacionTags) {
		this.publicacionTags = publicacionTags;
	}

	public PublicacionTag addPublicacionTag(PublicacionTag publicacionTag) {
		getPublicacionTags().add(publicacionTag);
		publicacionTag.setTag(this);

		return publicacionTag;
	}

	public PublicacionTag removePublicacionTag(PublicacionTag publicacionTag) {
		getPublicacionTags().remove(publicacionTag);
		publicacionTag.setTag(null);

		return publicacionTag;
	}

}