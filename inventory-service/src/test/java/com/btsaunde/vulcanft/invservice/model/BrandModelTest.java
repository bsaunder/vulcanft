package com.btsaunde.vulcanft.invservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandModelTest {

    @Test
    void gettersAndSettersWork() {
        Brand brand = new Brand();
        brand.setId(10L);
        brand.setName("Test");
        brand.setWebsite("http://example.com");
        brand.setNotes("notes");

        assertEquals(10L, brand.getId());
        assertEquals("Test", brand.getName());
        assertEquals("http://example.com", brand.getWebsite());
        assertEquals("notes", brand.getNotes());
        assertNotNull(brand.toString());
    }

    @Test
    void constructorSetsFields() {
        Brand brand = new Brand("Name", "web", "n");
        brand.setId(5L);
        assertEquals("Name", brand.getName());
        assertEquals("web", brand.getWebsite());
        assertEquals("n", brand.getNotes());
        assertEquals(5L, brand.getId());
    }
}
