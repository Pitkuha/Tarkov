package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "Weapon")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Type")
    private String type;
    @Column(name = "Name")
    private String name;
    @Column(name = "Accuracy")
    private double accuracy;
    @Column(name = "Ergonomics")
    private double ergonomics;
    @Column(name = "Starting_Speed")
    private double starting_speed;
    @Column(name = "Caliber")
    private double caliber;
    @Column(name = "Technical_Condition")
    private double technical_condition;

    public Weapon(String type, String name, double accuracy, double ergonomics, double starting_speed, double caliber, double technical_condition) {
        this.type = type;
        this.name = name;
        this.accuracy = accuracy;
        this.ergonomics = ergonomics;
        this.starting_speed = starting_speed;
        this.caliber = caliber;
        this.technical_condition = technical_condition;
    }

    public Weapon() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
