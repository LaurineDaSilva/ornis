package co.simplon.ornis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "birds")
public class Bird extends AbstractEntity {

    @Column(name = "vernacular_name")
    private String vernacularName;

    @Column(name = "scientific_name")
    private String scientificName;

    public Bird() {
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

    @Override
    public String toString() {
	return "{vernacularName=" + vernacularName
		+ ", scientificName=" + scientificName
		+ "}";
    }

}
