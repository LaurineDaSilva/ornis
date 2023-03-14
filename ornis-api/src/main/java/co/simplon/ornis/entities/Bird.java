package co.simplon.ornis.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "birds")
public class Bird extends AbstractEntity {

    @Column(name = "vernacular_name")
    private String vernacularName;

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "image_url")
    private String imageUrl;

    public Bird() {
	// TODO Auto-generated constructor stub
    }

    public String getVernacularName() {
	return vernacularName;
    }

    public void setVernacularName(String vernacularName) {
	this.vernacularName = vernacularName;
    }

    public String getScientificName() {
	return scientificName;
    }

    public void setScientificName(String scientificName) {
	this.scientificName = scientificName;
    }

    public String getImageUrl() {
	return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
	return "{vernacularName=" + vernacularName
		+ ", scientificName=" + scientificName
		+ ", imageUrl=" + imageUrl + "}";
    }

}
