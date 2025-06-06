package com.btsaunde.vulcanft.svgservice.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.batik.transcoder.TranscoderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btsaunde.vulcanft.svgservice.model.FilamenLabel;

/**
 * Service responsible for populating the filament label template and converting
 * the resulting SVG into a PNG image.
 */
@Service
public class FilamentLabelService {

        /** Handles Thymeleaf template rendering. */
        @Autowired
        private TemplateService templateService;

        /** Performs the SVG to PNG conversion. */
        @Autowired
        private SvgToPngConversionService conversionService;

        /** Logger instance for this service. */
        private static final Logger logger = LoggerFactory.getLogger(FilamentLabelService.class);

        /**
         * Convenience overload that accepts a {@link FilamenLabel} instance and
         * delegates to the detailed method.
         */
        public byte[] generateLabelFromTemplate(FilamenLabel filamenLabel) throws IOException, TranscoderException {

            return generateLabelFromTemplate(
                filamenLabel.getBrand(), 
                filamenLabel.getType(), 
                filamenLabel.getLine(), 
                filamenLabel.getSku(), 
                filamenLabel.getColorName(), 
                filamenLabel.getColorHex(), 
                filamenLabel.getNozzleTemp(), 
                filamenLabel.getBedTemp(), 
                filamenLabel.getMaxPrintSpeed(), 
                filamenLabel.getDryingTime(), 
                filamenLabel.getMaxRh(), 
                filamenLabel.getSpoolId(), 
                filamenLabel.getDryingTemp(), 
                filamenLabel.isDryingRequired(), 
                filamenLabel.isAmsCompatible(), 
                filamenLabel.isToxicFumes());
        }
    
        /**
         * Generates a label using the provided attributes, renders the SVG
         * template and converts it to PNG.
         */
        public byte[] generateLabelFromTemplate(String brand, String type, String line, String sku, String colorName, String colorHex,
            String nozzleTemp, String bedTemp, int maxPrintSpeed, int dryingTime, int maxRh, String spoolId, int dryingTemp,
            Boolean dryingRequired, Boolean amsCompatible, Boolean toxicFumes) throws IOException, TranscoderException {
        

            // Build Map for Template
            logger.info("Setting up SVG Template, ID: " + spoolId);
            Map<String, Object> variables = new HashMap<>();
            variables.put("brand", brand);
            variables.put("type", type);
            variables.put("line", line);
            variables.put("sku", sku);
            variables.put("colorName", colorName);
            variables.put("nozzleTemp", nozzleTemp);
            variables.put("bedTemp", bedTemp);
            variables.put("maxPrintSpeed", maxPrintSpeed);
            variables.put("dryingTime", dryingTime);
            variables.put("dryingTemp", dryingTemp);
            variables.put("maxHumiditiy", maxRh);
            variables.put("spoolId", spoolId);
                        
            if(dryingRequired){
                variables.put("dryingRequired", "Required");
                variables.put("dryingHex", "#FF0000");
            } else {
                variables.put("dryingRequired", "Optional");
                variables.put("dryingHex", "#000000");
            }
        
            if(amsCompatible){
                variables.put("amsCompatible", "Compatible");
                variables.put("amsHex", "#000000");
            } else {
                variables.put("amsCompatible", "Incompatible");
                variables.put("amsHex", "#FF0000");
            }

            if(toxicFumes){
                variables.put("toxicFumes", "Yes");
                variables.put("toxicHex", "#FF0000");
            } else {
                variables.put("toxicFumes", "No");
                variables.put("toxicHex", "#000000");
            }

            if(colorHex.contains(";")){
                // Split Colors and Set Variables
                String[] parts = colorHex.split(";");
        
                if(parts.length == 2){
                    variables.put("circleFill", "url(#dualGradient)");
                    variables.put("colorHex", "#"+parts[0].trim());
                    variables.put("colorHex2", "#"+parts[1].trim());
                    variables.put("colorHex3", "#"+parts[1].trim()); // Need to set in order for SVG to Parse
                }else if(parts.length == 3){
                    variables.put("circleFill", "url(#tripleGradient)");
                    variables.put("colorHex", "#"+parts[0].trim());
                    variables.put("colorHex2", "#"+parts[1].trim());
                    variables.put("colorHex3", "#"+parts[2].trim());
                }else{
                    variables.put("circleFill", "#"+parts[0].trim());
                }
            }else{
                // Single Color
                variables.put("circleFill", "#"+colorHex.trim());
            }
            
            // Process the template and get the result as a String
            logger.info("Generating Label SVG, ID: " + spoolId);
            String populatedTemplate = templateService.processTemplate("filamentLabel", variables);

            // Convert the provided SVG code to PNG using the service
            logger.info("Generating PNG, ID: " + spoolId);
            byte[] pngContent = conversionService.convertSvgToPng(populatedTemplate, 300);

            // Crop Sides off Image
            //logger.info("Cropping PNG, ID: " + spoolId);
            //byte[] croppedPngContent = ImageService.cropImage(pngContent, 60, 0, 280, 212);

            // Resize Image
            //logger.info("Resizing PNG, ID: " + spoolId);
            //byte[] resizedImage = ImageService.resizeImage(pngContent, 282, 212);

            logger.info("PNG Ready, ID: " + spoolId);
            return pngContent;
    }

}
