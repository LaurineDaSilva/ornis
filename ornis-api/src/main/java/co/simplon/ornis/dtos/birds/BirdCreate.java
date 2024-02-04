package co.simplon.ornis.dtos.birds;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import co.simplon.ornis.dtos.birds.validators.CommonNameUnicity;
import co.simplon.ornis.dtos.birds.validators.ScientificNameUnicity;

public class BirdCreate {

    @NotBlank
    @Size(max = 100)
    @ScientificNameUnicity
    private String scientificName;

    @NotBlank
    @Size(max = 200)
    @CommonNameUnicity
    private String commonName;

    @Size(max = 5000)
    private String description;

    @NotNull
    private MultipartFile file;

    public BirdCreate() {
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

    @Override
    public String toString() {
	return String.format(
		"{scientificName=%s, commonName=%s, description=%s, file=%s}",
		(file != null ? "[BLOB]" : null));

    }

}
