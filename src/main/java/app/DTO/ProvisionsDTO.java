package app.DTO;

import app.domain.Provision;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProvisionsDTO {
    @NotNull
    private String name;
    @NotNull
    @Min(value = 0)
    private double energy;

    public ProvisionsDTO() {
    }

    public ProvisionsDTO(Provision provision) {
        this.name = provision.getName();
        this.energy = provision.getEnergy();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
}
