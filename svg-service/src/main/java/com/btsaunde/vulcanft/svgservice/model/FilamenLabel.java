package com.btsaunde.vulcanft.svgservice.model;

public class FilamenLabel {

    private String brand;
    private String type;
    private String line;
    private String sku;
    private String colorName;
    private String colorHex;
    private String nozzleTemp;
    private String bedTemp;
    private int maxPrintSpeed;
    private int dryingTemp;
    private int dryingTime;
    private int maxRh;
    private boolean dryingRequired;
    private boolean amsCompatible;
    private boolean toxicFumes;
    private String spoolId;

    // Getters and Setters
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
