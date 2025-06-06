package com.btsaunde.vulcanft.svgservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Unit tests for {@link TemplateService}.
 */
@ExtendWith(MockitoExtension.class)
class TemplateServiceTest {

    @Mock
    private TemplateEngine templateEngine;

    @InjectMocks
    private TemplateService templateService;

    @Test
    void processTemplateDelegatesToEngine() {
        when(templateEngine.process(eq("test"), any(Context.class))).thenReturn("result");

        String output = templateService.processTemplate("test", Map.of("k", "v"));

        assertEquals("result", output);

        ArgumentCaptor<Context> captor = ArgumentCaptor.forClass(Context.class);
        verify(templateEngine).process(eq("test"), captor.capture());
        assertEquals("v", captor.getValue().getVariable("k"));
    }
}
