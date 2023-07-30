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

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "french_name")
    private String frenchName;

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

    public String getEnglishName() {
	return englishName;
    }

    public void setEnglishName(String englishName) {
	this.englishName = englishName;
    }

    public String getFrenchName() {
	return frenchName;
    }

    public void setFrenchName(String frenchName) {
	this.frenchName = frenchName;
    }

    @Override
    public String toString() {
	return "{speciesCode=" + speciesCode
		+ ", scientificName=" + scientificName
		+ ", englishName=" + englishName
		+ ", frenchName=" + frenchName + "}";
    }

}
