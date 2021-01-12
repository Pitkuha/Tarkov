package app.DTO;

import app.domain.Helmet;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class HelmetDTO {
    @NotNull
    private String name;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private int armor_class;

    @NotNull
    private String material;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private double armor_point;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private double ricochet_chance;

    public HelmetDTO() {
    }

    public HelmetDTO(Helmet helmet){
        this.name = helmet.getName();
        this.armor_class = helmet.getArmor_class();
        this.material = helmet.getMaterial();
        this.armor_point = helmet.getArmor_point();
        this.ricochet_chance = helmet.getRicochet_chance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmor_class() {
        return armor_class;
    }

    public void setArmor_class(int armor_class) {
        this.armor_class = armor_class;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getArmor_point() {
        return armor_point;
    }

    public void setArmor_point(double armor_point) {
        this.armor_point = armor_point;
    }

    public double getRicochet_chance() {
        return ricochet_chance;
    }

    public void setRicochet_chance(double ricochet_chance) {
        this.ricochet_chance = ricochet_chance;
    }
}
