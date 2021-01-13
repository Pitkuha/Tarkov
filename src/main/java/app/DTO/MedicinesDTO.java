package app.DTO;

import app.domain.Medicine;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MedicinesDTO {
    @NotNull
    private String name;
    @NotNull
    @Min(value = 0)
    private double health_resource;

    public MedicinesDTO() {
    }
    public MedicinesDTO(Medicine medicine) {
        this.health_resource = medicine.getHealt_resource();
        this.name = medicine.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth_resource() {
        return health_resource;
    }

    public void setHealth_resource(double health_resource) {
        this.health_resource = health_resource;
    }
}
