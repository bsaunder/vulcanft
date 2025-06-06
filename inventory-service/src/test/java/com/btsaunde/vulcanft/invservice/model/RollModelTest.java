package com.btsaunde.vulcanft.invservice.model;

import com.btsaunde.vulcanft.invservice.model.enums.RollLocation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RollModelTest {

    @Test
    void gettersAndSettersWork() {
        Roll roll = new Roll(1L, 0.75, "f", "r", RollLocation.STORAGE, LocalDate.now(), LocalDate.now());

        roll.setRollId(2L);
        roll.setStartingSize(1.0);
        roll.setFilament("filament");
        roll.setRoll("roll");
        roll.setLocation(RollLocation.AMS);
        LocalDate opened = LocalDate.now().minusDays(1);
        LocalDate sealed = LocalDate.now();
        roll.setDateOpened(opened);
        roll.setDateSealed(sealed);

        assertEquals(2L, roll.getRollId());
        assertEquals(1.0, roll.getStartingSize());
        assertEquals("filament", roll.getFilament());
        assertEquals("roll", roll.getRoll());
        assertEquals(RollLocation.AMS, roll.getLocation());
        assertEquals(opened, roll.getDateOpened());
        assertEquals(sealed, roll.getDateSealed());
    }
}
