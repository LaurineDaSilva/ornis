package co.simplon.ornis.entities;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_colors")
public class Color extends AbstractEntity {

    @Column(name = "rgbCode")
    private String rgbCode;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "colors", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Bird> birds;

    public Color() {
    }

    public String getRgbCode() {
	return rgbCode;
    }

    public void setRgbCode(String rgbCode) {
	this.rgbCode = rgbCode;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Set<Bird> getBirds() {
	return birds;
    }

    public void setBirds(Set<Bird> birds) {
	this.birds = birds;
    }

    @Override
    public int hashCode() {
	return Objects.hash(rgbCode);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	return obj instanceof Color other
		&& Objects.equals(rgbCode, other.rgbCode);
    }

    @Override
    public String toString() {
	return String.format("{id=%s, rgbCode=%s, name=%s}",
		getId(), rgbCode, name);
    }

}
