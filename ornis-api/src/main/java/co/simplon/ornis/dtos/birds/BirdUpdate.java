package co.simplon.ornis.dtos.birds;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import co.simplon.ornis.dtos.birds.validators.XenoIdUnicity;
import co.simplon.ornis.entities.BeakShape;
import co.simplon.ornis.entities.BirdSize;
import co.simplon.ornis.entities.FeetShape;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BirdUpdate {

    @NotBlank
    @Size(max = 100)
    private String scientificName;

    @NotBlank
    @Size(max = 200)
    private String commonName;

    @Size(max = 5000)
    private String description;

    private MultipartFile file;

    @XenoIdUnicity
    private Integer xenoId;

    private BeakShape beakShape;

    private FeetShape feetShape;

    private BirdSize size;

    private Set<Long> colorIds;

    public BirdUpdate() {
    }

    public String getScientificName() {
	return scientificName;
    }

    public void setScientificName(String scientificName) {
	this.scientificName = scientificName;
    }

    public String getCommonName() {
	return commonName;
    }

    public void setCommonName(String commonName) {
	this.commonName = commonName;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public MultipartFile getFile() {
	return file;
    }

    public void setFile(MultipartFile file) {
	this.file = file;
    }

    public Integer getXenoId() {
	return xenoId;
    }

    public void setXenoId(Integer xenoId) {
	this.xenoId = xenoId;
    }

    public BeakShape getBeakShape() {
	return beakShape;
    }

    public void setBeakShape(BeakShape beakShape) {
	this.beakShape = beakShape;
    }

    public FeetShape getFeetShape() {
	return feetShape;
    }

    public void setFeetShape(FeetShape feetShape) {
	this.feetShape = feetShape;
    }

    public BirdSize getSize() {
	return size;
    }

    public void setSize(BirdSize size) {
	this.size = size;
    }

    public Set<Long> getColorIds() {
	return colorIds;
    }

    public void setColorIds(Set<Long> colorIds) {
	this.colorIds = colorIds;
    }

    @Override
    public String toString() {
	return String.format(
		"{scientificName=%s, commonName=%s, description=%s, file=%s, xenoId=%s, beakShape=%s, feetShape=%s, size=%s, colorIds=%s}",
		(file != null ? "[BLOB]" : null));

    }

}
