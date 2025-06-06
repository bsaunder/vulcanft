package com.btsaunde.vulcanft.invservice.model;

import com.btsaunde.vulcanft.invservice.model.enums.FilamentType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilamentModelTest {

    @Test
    void gettersAndSettersWork() {
        Brand brand = new Brand("B", "w", "n");
        Filament filament = new Filament();
        filament.setId(1L);
        filament.setBrand(brand);
        filament.setType(FilamentType.PLA);
        filament.setLine("L");
        filament.setSku("SKU");
        filament.setColorName("Color");
        filament.setColorHex("#ffffff");
        filament.setPrintingTempRange("180-200");
        filament.setBedTempRange("50-60");
        filament.setMaxPrintSpeed(100);
        filament.setDryingTemp(60);
        filament.setDryingHours(5.0);
        filament.setMaxHumidity(20);
        filament.setHasToxicFumes(true);
        filament.setDryingIsRequired(true);
        filament.setIsAmsCompatible(true);

        assertEquals(1L, filament.getId());
        assertEquals(brand, filament.getBrand());
        assertEquals(FilamentType.PLA, filament.getType());
        assertEquals("L", filament.getLine());
        assertEquals("SKU", filament.getSku());
        assertEquals("Color", filament.getColorName());
        assertEquals("#ffffff", filament.getColorHex());
        assertEquals("180-200", filament.getPrintingTempRange());
        assertEquals("50-60", filament.getBedTempRange());
        assertEquals(100, filament.getMaxPrintSpeed());
        assertEquals(60, filament.getDryingTemp());
        assertEquals(5.0, filament.getDryingHours());
        assertEquals(20, filament.getMaxHumidity());
        assertTrue(filament.getHasToxicFumes());
        assertTrue(filament.getDryingIsRequired());
        assertTrue(filament.getIsAmsCompatible());
    }
}
