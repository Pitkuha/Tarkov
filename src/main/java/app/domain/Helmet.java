package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "Helmet")
public class Helmet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Armor_Class")
    private int armor_class;
    @Column(name = "Material")
    private String material;
    @Column(name = "Armor_Point")
    private double armor_point;
    @Column(name = "Ricochet_Chance")
    private double ricochet_chance;

    public Helmet(String name, int armor_class, String material, double armor_point, double ricochet_chance) {
        this.name = name;
        this.armor_class = armor_class;
        this.material = material;
        this.armor_point = armor_point;
        this.ricochet_chance = ricochet_chance;
    }

    public Helmet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
