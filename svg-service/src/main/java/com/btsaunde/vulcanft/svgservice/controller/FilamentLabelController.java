package com.btsaunde.vulcanft.svgservice.controller;

import java.io.IOException;
import org.apache.batik.transcoder.TranscoderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btsaunde.vulcanft.svgservice.model.FilamenLabel;
import com.btsaunde.vulcanft.svgservice.service.FilamentLabelService;

@RestController
@RequestMapping("/api/label")
public class FilamentLabelController {

    @Autowired
    private FilamentLabelService filamentLabelService;

    private static final Logger logger = LoggerFactory.getLogger(FilamentLabelController.class);

    @PostMapping("/filament")
    public ResponseEntity<byte[]> getFilamentLabelFromJson(@RequestBody FilamenLabel filament) {
        try{

            byte[] pngContent = filamentLabelService.generateLabelFromTemplate(filament);

            // Return the PNG as the response with proper Content-Type header
            return ResponseEntity.status(HttpStatus.OK)
                    .header("Content-Type", "image/png")
                    .body(pngContent);

        } catch (IOException | TranscoderException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/filament")
    public ResponseEntity<byte[]> getFilamentLabel(@RequestParam(value = "brand", defaultValue = "Bambu Lab") String brand,
                                                    @RequestParam(value = "type", defaultValue = "PLA") String type,
                                                    @RequestParam(value = "line", defaultValue = "Basic") String line,
                                                    @RequestParam(value = "sku", defaultValue = "10101") String sku,
                                                    @RequestParam(value = "colorName", defaultValue = "Black") String colorName,
                                                    @RequestParam(value = "colorHex", defaultValue = "#000000") String colorHex,
                                                    @RequestParam(value = "nozzleTemp", defaultValue = "190-230") String nozzleTemp,
                                                    @RequestParam(value = "bedTemp", defaultValue = "35-45") String bedTemp,
                                                    @RequestParam(value = "maxPrintSpeed", defaultValue = "300") int maxPrintSpeed,
                                                    @RequestParam(value = "dryingTemp", defaultValue = "50") int dryingTemp,
                                                    @RequestParam(value = "dryingTime", defaultValue = "8") int dryingTime,
                                                    @RequestParam(value = "maxRh", defaultValue = "20") int maxRh,
                                                    @RequestParam(value = "spoolId", defaultValue = "000") String spoolId,
                                                    @RequestParam(value = "dryingRequired", defaultValue = "false") Boolean dryingRequired,
                                                    @RequestParam(value = "amsCompatible", defaultValue = "true") Boolean amsCompatible,
                                                    @RequestParam(value = "toxicFumes", defaultValue = "false") Boolean toxicFumes
                                                    ) {
    
        try{
            
            byte[] pngContent = filamentLabelService.generateLabelFromTemplate(brand, type, line, sku, colorName, colorHex, nozzleTemp, bedTemp, maxPrintSpeed, dryingTime, maxRh, spoolId, dryingTemp, dryingRequired, amsCompatible, toxicFumes);

            logger.info("Label Created, ID: " + spoolId);

            // Return the PNG as the response with proper Content-Type header
            return ResponseEntity.status(HttpStatus.OK)
                    .header("Content-Type", "image/png")
                    .body(pngContent);

        } catch (IOException | TranscoderException e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }

    }

}
