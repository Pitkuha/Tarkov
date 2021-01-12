package app.DTO;

import app.domain.Armor;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ArmorDTO {
    @NotNull
    private String name;

    @NotNull
    @Min(value = 1)
    @Max(value = 6)
    private int armor_class;

    @NotNull
    private String material;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private double armor_point;

    public ArmorDTO(Armor armor){
        this.name = armor.getName();
        this.armor_class = armor.getArmor_class();
        this.material = armor.getMaterial();
        this.armor_point = armor.getArmor_point();
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
}
