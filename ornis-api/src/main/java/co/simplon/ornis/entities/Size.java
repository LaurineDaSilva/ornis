package co.simplon.ornis.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_sizes")
public class Size extends AbstractEntity {

    @Column(name = "name")
    private String name;

    public Size() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public int hashCode() {
	return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	return obj instanceof Size other
		&& Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
	return String.format("{id=%s, name=%s}", getId(),
		name);
    }

}
