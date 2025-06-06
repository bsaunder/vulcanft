package com.btsaunde.vulcanft.invservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import com.btsaunde.vulcanft.invservice.model.Brand;
import com.btsaunde.vulcanft.invservice.repository.BrandRepository;
import com.btsaunde.vulcanft.invservice.service.BrandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandService brandService;

    private Brand sampleBrand;

    @BeforeEach
    void setUp() {
        sampleBrand = new Brand("TestBrand", "http://example.com", "notes");
        sampleBrand.setId(1L);
    }

    @Test
    void getAllBrandsReturnsList() {
        List<Brand> brands = List.of(sampleBrand);
        when(brandRepository.findAll()).thenReturn(brands);

        List<Brand> result = brandService.getAllBrands();

        assertEquals(brands, result);
        verify(brandRepository).findAll();
    }

    @Test
    void getBrandByIdFound() {
        when(brandRepository.findById(1L)).thenReturn(Optional.of(sampleBrand));

        Optional<Brand> result = brandService.getBrandById(1L);

        assertTrue(result.isPresent());
        assertEquals(sampleBrand, result.get());
        verify(brandRepository).findById(1L);
    }

    @Test
    void getBrandByIdNotFound() {
        when(brandRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Brand> result = brandService.getBrandById(1L);

        assertTrue(result.isEmpty());
        verify(brandRepository).findById(1L);
    }

    @Test
    void createBrandSavesBrand() {
        when(brandRepository.save(sampleBrand)).thenReturn(sampleBrand);

        Brand result = brandService.createBrand(sampleBrand);

        assertEquals(sampleBrand, result);
        verify(brandRepository).save(sampleBrand);
    }

    @Test
    void updateBrandExisting() {
        Brand update = new Brand("Updated", "http://example.com", "notes");
        when(brandRepository.findById(1L)).thenReturn(Optional.of(sampleBrand));
        when(brandRepository.save(any(Brand.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Optional<Brand> result = brandService.updateBrand(1L, update);

        assertTrue(result.isPresent());
        assertEquals("Updated", sampleBrand.getName());
        verify(brandRepository).findById(1L);
        verify(brandRepository).save(sampleBrand);
    }

    @Test
    void updateBrandMissing() {
        when(brandRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Brand> result = brandService.updateBrand(1L, sampleBrand);

        assertTrue(result.isEmpty());
        verify(brandRepository).findById(1L);
        verify(brandRepository, never()).save(any());
    }

    @Test
    void deleteBrandExisting() {
        when(brandRepository.existsById(1L)).thenReturn(true);

        boolean result = brandService.deleteBrand(1L);

        assertTrue(result);
        verify(brandRepository).existsById(1L);
        verify(brandRepository).deleteById(1L);
    }

    @Test
    void deleteBrandMissing() {
        when(brandRepository.existsById(1L)).thenReturn(false);

        boolean result = brandService.deleteBrand(1L);

        assertFalse(result);
        verify(brandRepository).existsById(1L);
        verify(brandRepository, never()).deleteById(any());
    }
}
