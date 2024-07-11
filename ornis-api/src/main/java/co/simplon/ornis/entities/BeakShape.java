package co.simplon.ornis.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_beak_shapes")
public class BeakShape extends AbstractEntity {

    @Column(name = "name", updatable = false)
    private String name;

    @Column(name = "image", updatable = false)
    private String image;

    public BeakShape() {
    }

    public String getName() {
	return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
	// Not updatable
	this.name = name;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	return obj instanceof BeakShape other
		&& Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
	return Objects.hash(name);
    }

    @Override
    public String toString() {
	return String.format("{id=%s, name=%s, image=%s}",
		getId(), name, image);
    }

}
