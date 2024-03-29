package co.simplon.ornis.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "birds_colors")
public class BirdColor extends AbstractEntity {

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "color_name")
    private String colorName;

    public BirdColor() {
    }

    public String getScientificName() {
	return scientificName;
    }

    public void setScientificName(String scientificName) {
	this.scientificName = scientificName;
    }

    public String getColorName() {
	return colorName;
    }

    public void setColorName(String colorName) {
	this.colorName = colorName;
    }

    @Override
    public int hashCode() {
	return Objects.hash(scientificName, colorName);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	return obj instanceof BirdColor other
		&& Objects.equals(scientificName,
			other.scientificName)
		&& Objects.equals(colorName,
			other.colorName);
    }

    @Override
    public String toString() {
	return String.format(
		"{id=%s, scientificName=%s, colorName=%s}",
		getId(), scientificName, colorName);
    }

}
