package com.btsaunde.vulcanft.invservice.model;

import com.btsaunde.vulcanft.invservice.model.enums.SpoolMaterialType;
import com.btsaunde.vulcanft.invservice.model.enums.SpoolTemperature;
import jakarta.persistence.*;

@Entity
@Table(name = "spools")
public class Spool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SpoolMaterialType materialType;

    private double size;
    private double emptyWeight;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    private String color;

    @Enumerated(EnumType.STRING)
    private SpoolTemperature temperature;

    private boolean amsCompatible;

    public Spool() {
    }

    public Spool(SpoolMaterialType materialType, double size, double emptyWeight, Brand brand, String color, SpoolTemperature temperature, boolean amsCompatible) {
        this.materialType = materialType;
        this.size = size;
        this.emptyWeight = emptyWeight;
        this.brand = brand;
        this.color = color;
        this.temperature = temperature;
        this.amsCompatible = amsCompatible;
    }

    public SpoolMaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(SpoolMaterialType materialType) {
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

    public SpoolTemperature getTemperature() {
        return temperature;
    }

    public void setTemperature(SpoolTemperature temperature) {
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
