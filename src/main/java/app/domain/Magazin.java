package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "Magazins")
public class Magazin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Ergonomics")
    private double ergonomics;
    @Column(name = "Caliber")
    private double caliber;

    public Magazin(double ergonomics, double caliber) {
        this.ergonomics = ergonomics;
        this.caliber = caliber;
    }

    public Magazin() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getErgonomics() {
        return ergonomics;
    }

    public void setErgonomics(double ergonomics) {
        this.ergonomics = ergonomics;
    }

    public double getCaliber() {
        return caliber;
    }

    public void setCaliber(double caliber) {
        this.caliber = caliber;
    }
}
