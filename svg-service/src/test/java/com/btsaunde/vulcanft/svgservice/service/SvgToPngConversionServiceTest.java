package com.btsaunde.vulcanft.svgservice.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link SvgToPngConversionService}.
 */
class SvgToPngConversionServiceTest {

    private final SvgToPngConversionService service = new SvgToPngConversionService();

    @Test
    void removeBOMStripsLeadingMarker() {
        String xml = "\uFEFF<svg/>";
        assertEquals("<svg/>", SvgToPngConversionService.removeBOM(xml));
    }

    @Test
    void convertSvgToPngProducesPngBytes() throws Exception {
        String svg = "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"10\" height=\"10\"><rect width=\"10\" height=\"10\" fill=\"red\"/></svg>";
        byte[] result = service.convertSvgToPng(svg, 300);
        assertNotNull(result);
        // PNG magic number
        byte[] expectedHeader = new byte[] {(byte)0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A};
        assertArrayEquals(expectedHeader, java.util.Arrays.copyOf(result, 8));
    }
}
