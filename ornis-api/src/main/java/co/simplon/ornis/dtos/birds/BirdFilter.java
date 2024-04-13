package co.simplon.ornis.dtos.birds;

import java.util.Set;

public class BirdFilter {

    private String beakShapeName;

    private String feetShapeName;

    private Set<String> colorsNames;

    public BirdFilter() {
    }

    public String getBeakShapeName() {
	return beakShapeName;
    }

    public void setBeakShapeName(String beakShapeName) {
	this.beakShapeName = beakShapeName;
    }

    public String getFeetShapeName() {
	return feetShapeName;
    }

    public void setFeetShapeName(String feetShapeName) {
	this.feetShapeName = feetShapeName;
    }

    public Set<String> getColorsNames() {
	return colorsNames;
    }

    public void setColorsNames(Set<String> colorsNames) {
	this.colorsNames = colorsNames;
    }

    @Override
    public String toString() {
	return String.format(
		"{beakShapeName=%s, feetShapeName=%s, colorsNames=%s}");
    }

}
