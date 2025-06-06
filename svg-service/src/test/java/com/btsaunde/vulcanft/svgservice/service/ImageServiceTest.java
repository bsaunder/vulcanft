package com.btsaunde.vulcanft.svgservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link ImageService} utilities.
 */
class ImageServiceTest {

    private static byte[] createImage(int w, int h) throws Exception {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        java.awt.Graphics2D g = img.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);
        g.dispose();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", bos);
        return bos.toByteArray();
    }

    @Test
    void cropImageReturnsExpectedSize() throws Exception {
        byte[] bytes = createImage(10, 10);
        byte[] cropped = ImageService.cropImage(bytes, 2, 2, 5, 5);
        BufferedImage img = ImageIO.read(new java.io.ByteArrayInputStream(cropped));
        assertEquals(5, img.getWidth());
        assertEquals(5, img.getHeight());
    }

    @Test
    void cropImageInvalidParamsThrows() throws Exception {
        byte[] bytes = createImage(10, 10);
        assertThrows(IllegalArgumentException.class, () -> ImageService.cropImage(bytes, -1, 0, 5, 5));
    }

    @Test
    void resizeImageProducesTargetDimensions() throws Exception {
        byte[] bytes = createImage(10, 10);
        byte[] resized = ImageService.resizeImage(bytes, 4, 6);
        BufferedImage img = ImageIO.read(new java.io.ByteArrayInputStream(resized));
        assertEquals(4, img.getWidth());
        assertEquals(6, img.getHeight());
        assertNotNull(resized);
    }
}
