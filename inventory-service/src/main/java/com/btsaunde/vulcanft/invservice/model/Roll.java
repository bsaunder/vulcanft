package com.btsaunde.vulcanft.invservice.model;

import java.time.LocalDate;
import com.btsaunde.vulcanft.invservice.model.enums.RollLocation;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

/**
 * Entity representing a physical roll of filament.
 */
@Entity
@Table(name = "rolls")
public class Roll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rollId;
    private Double startingSize;
    private String filament;
    private String roll;
    @Enumerated(EnumType.STRING)
    private RollLocation location;
    private LocalDate dateOpened;
    private LocalDate dateSealed;

    /**
     * Convenience constructor used for manual creation of rolls.
     */
    public Roll(Long rollId, Double startingSize, String filament, String roll, RollLocation location, LocalDate dateOpened, LocalDate dateSealed) {
        this.rollId = rollId;
        this.startingSize = startingSize;
        this.filament = filament;
        this.roll = roll;
        this.location = location;
        this.dateOpened = dateOpened;
        this.dateSealed = dateSealed;
    }

    public Long getRollId() {
        return rollId;
    }

    public void setRollId(Long rollId) {
        this.rollId = rollId;
    }

    public Double getStartingSize() {
        return startingSize;
    }

    public void setStartingSize(Double startingSize) {
        this.startingSize = startingSize;
    }

    public String getFilament() {
        return filament;
    }

    public void setFilament(String filament) {
        this.filament = filament;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public RollLocation getLocation() {
        return location;
    }

    public void setLocation(RollLocation location) {
        this.location = location;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    public LocalDate getDateSealed() {
        return dateSealed;
    }

    public void setDateSealed(LocalDate dateSealed) {
        this.dateSealed = dateSealed;
    }
}
