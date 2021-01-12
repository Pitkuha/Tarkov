package app.DTO;


import app.domain.Ammunition;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AmmunitionDTO {
    @NotNull
    @Min(value = 0)
    private double caliber;
    @NotNull
    @Min(value = 1)
    private double bullet_speed;

    public AmmunitionDTO(Ammunition ammunition){
        this.bullet_speed = ammunition.getBullet_speed();
        this.bullet_speed = ammunition.getCaliber();
    }

    public double getCaliber() {
        return caliber;
    }

    public void setCaliber(double caliber) {
        this.caliber = caliber;
    }

    public double getBullet_speed() {
        return bullet_speed;
    }

    public void setBullet_speed(double bullet_speed) {
        this.bullet_speed = bullet_speed;
    }
}
