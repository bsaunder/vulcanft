package com.btsaunde.vulcanft.invservice.controller;

import com.btsaunde.vulcanft.invservice.model.Brand;
import com.btsaunde.vulcanft.invservice.repository.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for {@link BrandController} that also generate Spring REST Docs snippets.
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
class BrandControllerDocumentationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BrandRepository brandRepository;

    @BeforeEach
    void setup() {
        brandRepository.deleteAll();
        brandRepository.save(new Brand("TestBrand", "https://example.com", "notes"));
    }

    @Test
    void getBrands() throws Exception {
        mockMvc.perform(get("/api/brand").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("brands-get"));
    }
}
