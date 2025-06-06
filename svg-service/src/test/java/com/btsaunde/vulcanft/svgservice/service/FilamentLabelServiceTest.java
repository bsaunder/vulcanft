package com.btsaunde.vulcanft.svgservice.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Tests for {@link FilamentLabelService}.
 */
@ExtendWith(MockitoExtension.class)
class FilamentLabelServiceTest {

    @Mock
    private TemplateService templateService;

    @Mock
    private SvgToPngConversionService conversionService;

    @InjectMocks
    private FilamentLabelService service;

    @BeforeEach
    void setupMocks() throws Exception {
        when(templateService.processTemplate(eq("filamentLabel"), anyMap())).thenReturn("<svg></svg>");
        when(conversionService.convertSvgToPng(eq("<svg></svg>"), eq(300))).thenReturn(new byte[] {1,2,3});
    }

    @Test
    void generateLabelBuildsVariablesCorrectly() throws Exception {
        byte[] result = service.generateLabelFromTemplate(
                "Brand", "PLA", "Line", "1001", "Color", "FF0000;00FF00",
                "200", "50", 100, 8, 20, "ID1", 60,
                true, false, false);

        assertArrayEquals(new byte[]{1,2,3}, result);

        ArgumentCaptor<Map<String,Object>> captor = ArgumentCaptor.forClass(Map.class);
        verify(templateService).processTemplate(eq("filamentLabel"), captor.capture());
        Map<String,Object> vars = captor.getValue();
        assertEquals("Brand", vars.get("brand"));
        assertEquals("url(#dualGradient)", vars.get("circleFill"));
        assertEquals("#FF0000", vars.get("colorHex"));
        assertEquals("#00FF00", vars.get("colorHex2"));
        assertEquals("Required", vars.get("dryingRequired"));
        assertEquals("Incompatible", vars.get("amsCompatible"));
        assertEquals("No", vars.get("toxicFumes"));
        assertEquals("ID1", vars.get("spoolId"));
    }
}
