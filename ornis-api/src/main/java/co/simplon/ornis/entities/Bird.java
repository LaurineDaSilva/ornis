package co.simplon.ornis.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "birds")
public class Bird extends AbstractEntity {

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "description")
    private String description;

    @Column(name = "xeno_id")
    private String xenoId;

    public Bird() {
    }

    public String getScientificName() {
	return scientificName;
    }

    public void setScientificName(String scientificName) {
	this.scientificName = scientificName;
    }

    public String getCommonName() {
	return commonName;
    }

    public void setCommonName(String commonName) {
	this.commonName = commonName;
    }

    public String getImageName() {
	return imageName;
    }

    public void setImageName(String imageName) {
	this.imageName = imageName;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getXenoId() {
	return xenoId;
    }

    public void setXenoId(String xenoId) {
	this.xenoId = xenoId;
    }

    @Override
    public int hashCode() {
	return Objects.hash(scientificName);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Bird other = (Bird) obj;
	return Objects.equals(scientificName,
		other.scientificName);
    }

    @Override
    public String toString() {
	return String.format(
		"{id=%s, scientificName=%s, commonName=%s, imageName=%s, description=%s, xenoId=%s}",
		getId(), scientificName, commonName,
		imageName, description, xenoId);
    }

}
