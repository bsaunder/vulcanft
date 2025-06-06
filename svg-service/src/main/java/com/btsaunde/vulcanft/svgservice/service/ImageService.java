package com.btsaunde.vulcanft.svgservice.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Image;
import org.springframework.stereotype.Service;

/**
 * Utility service that provides basic image manipulation operations used when
 * generating label graphics.
 */
@Service
public class ImageService {

        /**
         * Crop the provided image byte array to the specified rectangle.
         */
        public static byte[] cropImage(byte[] imageBytes, int x, int y, int width, int height) throws IOException {
        // Convert byte array to BufferedImage
        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        BufferedImage originalImage = ImageIO.read(bis);

        // Check for valid cropping parameters
        if (x < 0 || y < 0 || width <= 0 || height <= 0 ||
            x + width > originalImage.getWidth() || y + height > originalImage.getHeight()) {
            throw new IllegalArgumentException("Invalid cropping parameters");
        }
      
        // Create the subimage (crop)
        BufferedImage croppedImage = originalImage.getSubimage(x, y, width, height);

        // Convert cropped image back to byte array
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        String formatName = "png";
        ImageIO.write(croppedImage, formatName, bos);

        return bos.toByteArray();
    }

        /**
         * Resize the provided image byte array to the target dimensions.
         */
        public static byte[] resizeImage(byte[] imageBytes, int targetWidth, int targetHeight) throws IOException {
        // Convert byte array to BufferedImage
        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        BufferedImage originalImage = ImageIO.read(bis);

        if (originalImage == null) {
            throw new IOException("Invalid image format or corrupted image data.");
        }
        
        // Resize the image
        Image resizedImage = originalImage.getScaledInstance(targetWidth, targetHeight, BufferedImage.SCALE_AREA_AVERAGING);
        BufferedImage bufferedResizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        bufferedResizedImage.getGraphics().drawImage(resizedImage, 0, 0, null);

        // Convert resized BufferedImage back to byte array
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bufferedResizedImage, "png", bos);

        return bos.toByteArray();
    }
    
}
