package com.btsaunde.vulcanft.svgservice.model;

/**
 * Data model representing the fields required to populate a filament label.
 * The properties correspond directly to placeholders used in the SVG template.
 */
public class FilamenLabel {

    /** Manufacturer of the filament. */
    private String brand;
    /** Material type such as PLA or PETG. */
    private String type;
    /** Product line name. */
    private String line;
    /** Stock keeping unit. */
    private String sku;
    /** Display color name. */
    private String colorName;
    /** Color specified as hex or semicolon separated gradient. */
    private String colorHex;
    /** Recommended nozzle temperature range. */
    private String nozzleTemp;
    /** Recommended bed temperature range. */
    private String bedTemp;
    /** Maximum printer speed in mm/s. */
    private int maxPrintSpeed;
    /** Drying temperature for the filament. */
    private int dryingTemp;
    /** Drying time in hours. */
    private int dryingTime;
    /** Maximum recommended relative humidity. */
    private int maxRh;
    /** Whether drying is required before use. */
    private boolean dryingRequired;
    /** Whether the spool is compatible with the AMS system. */
    private boolean amsCompatible;
    /** Flag indicating if the material releases toxic fumes. */
    private boolean toxicFumes;
    /** Unique identifier for the spool. */
    private String spoolId;

    // ---------------------------------------------------------------------
    // Getters and Setters
    // ---------------------------------------------------------------------
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public String getNozzleTemp() {
        return nozzleTemp;
    }

    public void setNozzleTemp(String nozzleTemp) {
        this.nozzleTemp = nozzleTemp;
    }

    public String getBedTemp() {
        return bedTemp;
    }

    public void setBedTemp(String bedTemp) {
        this.bedTemp = bedTemp;
    }

    public int getMaxPrintSpeed() {
        return maxPrintSpeed;
    }

    public void setMaxPrintSpeed(int maxPrintSpeed) {
        this.maxPrintSpeed = maxPrintSpeed;
    }

    public String getSpoolId() {
        return spoolId;
    }

    public void setSpoolId(String spoolId) {
        this.spoolId = spoolId;
    }

    public int getDryingTemp() {
        return dryingTemp;
    }

    public void setDryingTemp(int dryingTemp) {
        this.dryingTemp = dryingTemp;
    }

    public int getDryingTime() {
        return dryingTime;
    }

    public void setDryingTime(int dryingTime) {
        this.dryingTime = dryingTime;
    }

    public int getMaxRh() {
        return maxRh;
    }

    public void setMaxRh(int maxRh) {
        this.maxRh = maxRh;
    }

    public boolean isDryingRequired() {
        return dryingRequired;
    }

    public void setDryingRequired(boolean dryingRequired) {
        this.dryingRequired = dryingRequired;
    }

    public boolean isAmsCompatible() {
        return amsCompatible;
    }

    public void setAmsCompatible(boolean amsCompatible) {
        this.amsCompatible = amsCompatible;
    }

    public boolean isToxicFumes() {
        return toxicFumes;
    }

    public void setToxicFumes(boolean toxicFumes) {
        this.toxicFumes = toxicFumes;
    }
}
