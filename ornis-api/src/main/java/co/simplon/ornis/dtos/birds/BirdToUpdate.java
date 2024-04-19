package co.simplon.ornis.dtos.birds;

import java.util.Set;

public interface BirdToUpdate {

    Long getId();

    String getScientificName();

    String getCommonName();

    String getDescription();

    String getXenoId();

    String getBeakShape();

    String getFeetShape();

    String getSize();

    Set<Long> getColorIds();

}
