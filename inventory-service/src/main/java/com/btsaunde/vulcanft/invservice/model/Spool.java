package com.btsaunde.vulcanft.invservice.model;

public class Spool {
    public enum MaterialType {
        CARDBOARD, PLASTIC
    }

    public enum Temperature {
        LOW, HIGH
    }

    private MaterialType materialType;
    private double size;
    private double emptyWeight;
    private Brand brand;
    private String color;
    private Temperature temperature;
    private boolean amsCompatible;

    public Spool() {
    }

    public Spool(MaterialType materialType, double size, double emptyWeight, Brand brand, String color, Temperature temperature, boolean amsCompatible) {
        this.materialType = materialType;
        this.size = size;
        this.emptyWeight = emptyWeight;
        this.brand = brand;
        this.color = color;
        this.temperature = temperature;
        this.amsCompatible = amsCompatible;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(double emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public boolean isAmsCompatible() {
        return amsCompatible;
    }

    public void setAmsCompatible(boolean amsCompatible) {
        this.amsCompatible = amsCompatible;
    }

    @Override
    public String toString() {
        return "Spool{" +
                "materialType='" + materialType + '\'' +
                ", size='" + size + '\'' +
                ", emptyWeight=" + emptyWeight +
                ", brand=" + brand +
                ", color='" + color + '\'' +
                ", temperature='" + temperature + '\'' +
                ", amsCompatible=" + amsCompatible +
                '}';
    }
}
