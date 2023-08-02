package co.simplon.ornis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "birds")
public class Bird extends AbstractEntity {

    @Column(name = "species_code")
    private String speciesCode;

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "common_name")
    private String commonName;

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

    @Override
    public String toString() {
	return "{speciesCode=" + speciesCode
		+ ", scientificName=" + scientificName
		+ ", commonName=" + commonName + "}";
    }

}
