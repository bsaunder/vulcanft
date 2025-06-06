package com.btsaunde.vulcanft.invservice.model;

import com.btsaunde.vulcanft.invservice.model.enums.FilamentType;
import jakarta.persistence.*;

/**
 * Represents a specific filament product.
 */
@Entity
@Table(name = "filaments")
public class Filament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Enumerated(EnumType.STRING)
    private FilamentType type;

    private String line;
    private String sku;
    private String colorName;
    private String colorHex;
    private String printingTempRange;
    private String bedTempRange;
    private Integer maxPrintSpeed;
    private Integer dryingTemp;
    private Double dryingHours;
    private Integer maxHumidity;
    private Boolean hasToxicFumes;
    private Boolean dryingIsRequired;
    private Boolean isAmsCompatible;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public FilamentType getType() {
        return type;
    }

    public void setType(FilamentType type) {
        this.type = type;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public String getPrintingTempRange() {
        return printingTempRange;
    }

    public void setPrintingTempRange(String printingTempRange) {
        this.printingTempRange = printingTempRange;
    }

    public String getBedTempRange() {
        return bedTempRange;
    }

    public void setBedTempRange(String bedTempRange) {
        this.bedTempRange = bedTempRange;
    }

    public Integer getMaxPrintSpeed() {
        return maxPrintSpeed;
    }

    public void setMaxPrintSpeed(Integer maxPrintSpeed) {
        this.maxPrintSpeed = maxPrintSpeed;
    }

    public Integer getDryingTemp() {
        return dryingTemp;
    }

    public void setDryingTemp(Integer dryingTemp) {
        this.dryingTemp = dryingTemp;
    }

    public Double getDryingHours() {
        return dryingHours;
    }

    public void setDryingHours(Double dryingHours) {
        this.dryingHours = dryingHours;
    }

    public Integer getMaxHumidity() {
        return maxHumidity;
    }

    public void setMaxHumidity(Integer maxHumidity) {
        this.maxHumidity = maxHumidity;
    }

    public Boolean getHasToxicFumes() {
        return hasToxicFumes;
    }

    public void setHasToxicFumes(Boolean hasToxicFumes) {
        this.hasToxicFumes = hasToxicFumes;
    }

    public Boolean getDryingIsRequired() {
        return dryingIsRequired;
    }

    public void setDryingIsRequired(Boolean dryingIsRequired) {
        this.dryingIsRequired = dryingIsRequired;
    }

    public Boolean getIsAmsCompatible() {
        return isAmsCompatible;
    }

    public void setIsAmsCompatible(Boolean isAmsCompatible) {
        this.isAmsCompatible = isAmsCompatible;
    }

}
