package com.btsaunde.vulcanft.svgservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
public class TemplateService {

    @Autowired
    private TemplateEngine templateEngine;  // Inject the TemplateEngine

    /**
     * This method processes the template and returns the populated template as a String.
     *
     * @param templateName The name of the template file (without extension)
     * @param variables    A map of variables to replace in the template
     * @return The populated template as a String
     */
    public String processTemplate(String templateName, Map<String, Object> variables) {
        // Create a Thymeleaf context and set the variables
        Context context = new Context();
        context.setVariables(variables);

        // Process the template and return the result as a String
        return templateEngine.process(templateName, context);
    }
}
