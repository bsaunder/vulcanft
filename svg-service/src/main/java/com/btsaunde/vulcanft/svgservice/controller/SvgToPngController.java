package com.btsaunde.vulcanft.svgservice.controller;

import java.io.IOException;

import org.apache.batik.transcoder.TranscoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.btsaunde.vulcanft.svgservice.service.SvgToPngConversionService;

/**
 * Controller that exposes an endpoint to convert raw SVG markup into PNG
 * images.
 */
@RestController
@RequestMapping("/api/svg")
public class SvgToPngController {

    /** Service that handles the SVG to PNG conversion logic. */
    @Autowired
    private SvgToPngConversionService conversionService;

    /**
     * Converts a block of SVG markup into a PNG image.
     *
     * @param svgCode SVG XML to convert
     * @return PNG image bytes
     */
    @PostMapping("/convert")
    public ResponseEntity<byte[]> convertSvgToPng(@RequestBody String svgCode) {
        try {
            // Convert the provided SVG code to PNG using the service
            byte[] pngContent = conversionService.convertSvgToPng(svgCode, 300);

            // Return the PNG as the response with proper Content-Type header
            return ResponseEntity.status(HttpStatus.OK)
                    .header("Content-Type", "image/png")
                    .body(pngContent);
        } catch (IOException | TranscoderException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}

