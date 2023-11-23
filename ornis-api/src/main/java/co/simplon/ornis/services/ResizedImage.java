package co.simplon.ornis.services;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResizedImage {

    private Image resultingImage;
    private BufferedImage outputImage;

    public ResizedImage() {
    }

    BufferedImage resizeImage(BufferedImage originalImage,
	    int targetWidth, int targetHeight)
	    throws IOException {
	Image resultingImage = originalImage
		.getScaledInstance(targetWidth,
			targetHeight, Image.SCALE_DEFAULT);
	BufferedImage outputImage = new BufferedImage(
		targetWidth, targetHeight,
		BufferedImage.TYPE_INT_RGB);
	outputImage.getGraphics().drawImage(resultingImage,
		0, 0, null);
	return outputImage;
    }

}
