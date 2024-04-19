package co.simplon.ornis.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_birds_colors")
public class BirdColor extends AbstractEntity {

    @Column(name = "bird_id")
    private Long birdId;

    @Column(name = "color_id")
    private Long colorId;

    public BirdColor() {
    }

    public Long getBirdId() {
	return birdId;
    }

    public void setBirdId(Long birdId) {
	this.birdId = birdId;
    }

    public Long getColorId() {
	return colorId;
    }

    public void setColorId(Long colorId) {
	this.colorId = colorId;
    }

    @Override
    public int hashCode() {
	return Objects.hash(birdId, colorId);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	return obj instanceof BirdColor other
		&& Objects.equals(birdId, other.birdId)
		&& Objects.equals(colorId, other.colorId);
    }

    @Override
    public String toString() {
	return String.format(
		"{id=%s, birdId=%s, colorId=%s}", getId(),
		birdId, colorId);
    }

}
