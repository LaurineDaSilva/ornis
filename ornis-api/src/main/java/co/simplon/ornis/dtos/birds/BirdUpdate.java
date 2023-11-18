package co.simplon.ornis.dtos.birds;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public String toString() {
	return String.format(
		"{scientificName=%s, commonName=%s, description=%s, file=%s}",
		(file != null ? "[BLOB]" : null));

    }

}
