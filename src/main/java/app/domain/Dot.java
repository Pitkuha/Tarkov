package app.domain;
//TODO Реализовать связи ManyToOne итд во всех доменах
import javax.persistence.*;

@Entity
@Table(name="DOTS")
public class Dot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="X")
    private double x;
    @Column(name="Y")
    private double y;
    @Column(name="R")
    private double r;
    @Column(name="RESULT")
    private boolean result;

    @ManyToOne
    private User owner;

    public Dot(double x, double y, double r, boolean result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
    }

    public Dot(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
