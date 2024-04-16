package co.simplon.ornis.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_colors")
public class Color extends AbstractEntity {

    @Column(name = "rgbCode")
    private String rgbCode;

    @Column(name = "name")
    private String name;

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
