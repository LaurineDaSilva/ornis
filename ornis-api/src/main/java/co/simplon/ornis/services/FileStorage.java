package co.simplon.ornis.services;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
class FileStorage {

    private static final Map<String, String> TYPES;
    static {
	TYPES = new HashMap<>();
	TYPES.put(MediaType.IMAGE_JPEG_VALUE, "jpeg");
	TYPES.put(MediaType.IMAGE_PNG_VALUE, "png");
    }

    @Value("${ornis.uploads.location}")
    private String uploadFullImageDir;

    @Value("${ornis.uploads.location.resized-image}")
    private String uploadResizedImageDir;

    private Path uploadFullImagePath;
    private Path uploadResizedImagePath;

    FileStorage() {
    }

    @PostConstruct
    private void init() {
	this.uploadFullImagePath = Paths
		.get(uploadFullImageDir);
	this.uploadResizedImagePath = Paths
		.get(uploadResizedImageDir);
    }

    // For original images

    String store(MultipartFile file, String baseName) {
	String contentType = file.getContentType();
	String fullName = String.format("%s.%s", baseName,
		TYPES.get(contentType));
	Path target = uploadFullImagePath.resolve(fullName);
	try (InputStream in = file.getInputStream()) {
	    Files.copy(in, target,
		    StandardCopyOption.REPLACE_EXISTING);
	    return fullName;
	} catch (IOException ex) {
	    throw new RuntimeException(ex);
	}
    }

    void delete(String fullName) {
	Path target = uploadFullImagePath.resolve(fullName);
	try {
	    Files.delete(target);
	} catch (IOException ex) {
	    throw new RuntimeException(ex);
	}
    }

    String replace(MultipartFile file, String baseName,
	    String original) {
	String newFullName = store(file, baseName);
	delete(original);
	return newFullName;
    }

    // For thumbnails

    public Optional<String> getExtensionByStringHandling(
	    String filename) {
	return Optional.ofNullable(filename)
		.filter(f -> f.contains("."))
		.map(f -> f.substring(
			filename.lastIndexOf(".") + 1));
    }

    String storeThumbnail(BufferedImage image,
	    MultipartFile file, String baseName) {
	String contentType = file.getContentType();
	String formatName = getExtensionByStringHandling(
		baseName).toString();
	String fullName = String.format("%s.%s", baseName,
		TYPES.get(contentType));
	Path target = uploadResizedImagePath
		.resolve(fullName);
	try {
	    ImageIO.write(image, formatName,
		    target.toFile());
	} catch (IOException ex) {
	    throw new RuntimeException(ex);
	}

	return fullName;

    }

}
