package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "Ammunition")
public class Ammunition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Caliber")
    private double caliber;
    @Column(name = "Bullet_Speed")
    private double bullet_speed;

    public Ammunition(double caliber, double bullet_speed) {
        this.caliber = caliber;
        this.bullet_speed = bullet_speed;
    }

    public Ammunition() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
