package com.btsaunde.vulcanft.invservice.controller;

import com.btsaunde.vulcanft.invservice.model.Brand;
import com.btsaunde.vulcanft.invservice.service.BrandService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BrandController.class)
class BrandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BrandService brandService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllBrandsReturnsList() throws Exception {
        Brand brand = new Brand("Test", "w", "n");
        brand.setId(1L);
        when(brandService.getAllBrands()).thenReturn(List.of(brand));

        mockMvc.perform(get("/api/brand"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Test")));
    }

    @Test
    void getBrandByIdFound() throws Exception {
        Brand brand = new Brand("Test", "w", "n");
        brand.setId(1L);
        when(brandService.getBrandById(1L)).thenReturn(Optional.of(brand));

        mockMvc.perform(get("/api/brand/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Test")));
    }

    @Test
    void getBrandByIdNotFound() throws Exception {
        when(brandService.getBrandById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/brand/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void createBrandReturnsBrand() throws Exception {
        Brand brand = new Brand("Test", "w", "n");
        brand.setId(1L);
        when(brandService.createBrand(any(Brand.class))).thenReturn(brand);

        mockMvc.perform(post("/api/brand")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(brand)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Test")));
    }

    @Test
    void updateBrandFound() throws Exception {
        Brand update = new Brand("Update", "w", "n");
        Brand brand = new Brand("Update", "w", "n");
        brand.setId(1L);
        when(brandService.updateBrand(Mockito.eq(1L), any(Brand.class))).thenReturn(Optional.of(brand));

        mockMvc.perform(put("/api/brand/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(update)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Update")));
    }

    @Test
    void updateBrandNotFound() throws Exception {
        when(brandService.updateBrand(Mockito.eq(1L), any(Brand.class))).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/brand/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new Brand())))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteBrandFound() throws Exception {
        when(brandService.deleteBrand(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/brand/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteBrandNotFound() throws Exception {
        when(brandService.deleteBrand(1L)).thenReturn(false);

        mockMvc.perform(delete("/api/brand/1"))
                .andExpect(status().isNotFound());
    }
}
