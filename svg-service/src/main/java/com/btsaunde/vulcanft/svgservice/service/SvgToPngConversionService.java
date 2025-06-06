package com.btsaunde.vulcanft.svgservice.service;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.w3c.dom.svg.SVGDocument;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service that handles conversion of SVG markup to PNG images using Apache
 * Batik.
 */
@Service
public class SvgToPngConversionService {

    /** Logger instance for this service. */
    private static final Logger logger = LoggerFactory.getLogger(SvgToPngConversionService.class);

    /**
     * Convert an SVG string to a PNG image using the specified DPI for rendering.
     */
    public byte[] convertSvgToPng(String svgContent, int dpi) throws IOException, TranscoderException {

        // Remove any BOM characters
        String cleanSvgContent = removeBOM(svgContent);

        logger.debug(svgContent);

        // Parse the SVG string into a Document
        String parser = XMLResourceDescriptor.getXMLParserClassName();
        ByteArrayInputStream svgInputStream = new ByteArrayInputStream(cleanSvgContent.getBytes("UTF-8"));
        SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(parser);
        SVGDocument doc = factory.createSVGDocument(null, svgInputStream);
        logger.info("SVG Text Parsed");

        // Set up PNG transcoder
        PNGTranscoder transcoder = new PNGTranscoder();
        logger.info("PNG Transcoder Set");

        // Output stream to hold the PNG image data
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Perform the transcoding (SVG to PNG)
        try{
            transcoder.transcode(new TranscoderInput(doc), new TranscoderOutput(outputStream));

            if(outputStream.toByteArray() == null){
                logger.info("Output Stream is Null, Throwing Error");
                throw new TranscoderException("Output Stream Null");
            }

        }catch(Exception e){
            logger.error(e.getLocalizedMessage(), e);
        }

        logger.info("Transcode Complete");

        // Return the PNG byte array
        return outputStream.toByteArray();
    }

    /**
     * Remove any UTF-8 BOM character that may appear at the start of the provided
     * string.
     */
    public static String removeBOM(String xmlContent) {
        // Check if BOM is at the beginning of the string
        if (xmlContent.startsWith("\uFEFF")) {
            // Remove BOM (U+FEFF)
            return xmlContent.substring(1);
        }
        return xmlContent;
    }
}

