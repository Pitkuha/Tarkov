package app.DTO;

import app.domain.Weapon;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class WeaponDTO {
    @NotNull
    private String type;

    @NotNull
    private String name;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private double accuracy;

    @NotNull
    @Min(value = 1)
    private double ergonomics;

    @NotNull
    @Min(value = 1)
    private double starting_speed;

    @NotNull
    @Min(value = 0)
    private double caliber;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private double technical_condition;

    public WeaponDTO(Weapon weapon){
        this.type = weapon.getType();
        this.name = weapon.getName();
        this.accuracy = weapon.getAccuracy();
        this.ergonomics = weapon.getErgonomics();
        this.starting_speed = weapon.getStarting_speed();
        this.caliber = weapon.getCaliber();
        this.technical_condition = weapon.getTechnical_condition();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getErgonomics() {
        return ergonomics;
    }

    public void setErgonomics(double ergonomics) {
        this.ergonomics = ergonomics;
    }

    public double getStarting_speed() {
        return starting_speed;
    }

    public void setStarting_speed(double starting_speed) {
        this.starting_speed = starting_speed;
    }

    public double getCaliber() {
        return caliber;
    }

    public void setCaliber(double caliber) {
        this.caliber = caliber;
    }

    public double getTechnical_condition() {
        return technical_condition;
    }

    public void setTechnical_condition(double technical_condition) {
        this.technical_condition = technical_condition;
    }
}
