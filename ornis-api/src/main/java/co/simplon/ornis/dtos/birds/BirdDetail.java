package co.simplon.ornis.dtos.birds;

import java.util.Set;

import co.simplon.ornis.entities.Color;

public interface BirdDetail {

    String getScientificName();

    String getCommonName();

    String getImage();

    String getDescription();

    String getXenoId();

    Set<Color> getColors();

    String getBeakShapeName();

}
