package co.simplon.ornis.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BirdCreate {

    @NotBlank
    @Size(max = 100)
    private String scientificName;

    @NotBlank
    @Size(max = 200)
    private String commonName;

    @Size(max = 5000)
    private String description;

    public BirdCreate() {
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

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return "{scientificName=" + scientificName
		+ ", commonName=" + commonName
		+ ", description=" + description + "}";
    }

}
