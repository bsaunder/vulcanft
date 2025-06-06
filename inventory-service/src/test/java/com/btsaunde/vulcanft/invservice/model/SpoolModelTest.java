package com.btsaunde.vulcanft.invservice.model;

import com.btsaunde.vulcanft.invservice.model.enums.SpoolMaterialType;
import com.btsaunde.vulcanft.invservice.model.enums.SpoolTemperature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpoolModelTest {

    @Test
    void gettersAndSettersWork() {
        Brand brand = new Brand("B", "w", "n");
        Spool spool = new Spool();
        spool.setMaterialType(SpoolMaterialType.PLASTIC);
        spool.setSize(1.0);
        spool.setEmptyWeight(0.5);
        spool.setBrand(brand);
        spool.setColor("Red");
        spool.setTemperature(SpoolTemperature.HIGH);
        spool.setAmsCompatible(true);

        assertEquals(SpoolMaterialType.PLASTIC, spool.getMaterialType());
        assertEquals(1.0, spool.getSize());
        assertEquals(0.5, spool.getEmptyWeight());
        assertEquals(brand, spool.getBrand());
        assertEquals("Red", spool.getColor());
        assertEquals(SpoolTemperature.HIGH, spool.getTemperature());
        assertTrue(spool.isAmsCompatible());
        assertNotNull(spool.toString());
    }
}
