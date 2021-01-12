package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "Provisions")
public class Provision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Energy")
    private double energy;

    public Provision(String name, double energy) {
        this.name = name;
        this.energy = energy;
    }

    public Provision() {
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

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
}
