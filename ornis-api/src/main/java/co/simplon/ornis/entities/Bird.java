package co.simplon.ornis.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import co.simplon.ornis.entities.listeners.BirdListener;

@Entity
@EntityListeners(BirdListener.class)
@Table(name = "birds")
public class Bird extends AbstractEntity {

    @Column(name = "species_code")
    private String speciesCode;

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "description")
    private String description;

    public Bird() {
    }

    public String getSpeciesCode() {
	return speciesCode;
    }

    public void setSpeciesCode(String speciesCode) {
	this.speciesCode = speciesCode;
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
		"{id=%s, speciesCode=%s, scientificName=%s, commonName=%s, imageName=%s, description=%s}",
		getId(), speciesCode, scientificName,
		commonName, imageName, description);
    }

}
