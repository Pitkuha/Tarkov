package app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Trader")
public class Trader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Call_Sign")
    private String call_sign;
    @Column(name = "Money")
    private double money;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TraderTask",
    joinColumns = {@JoinColumn(name = "Trader_ID")},
    inverseJoinColumns = {@JoinColumn(name = "Task_ID")})
    private Set<Task> tasks = new HashSet<>();

    @OneToMany(mappedBy = "fighter_id")
    private Set<Trust> trusts = new HashSet<>();

    public Trader(String call_sign, double money) {
        this.call_sign = call_sign;
        this.money = money;
    }

    public Trader() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCall_sign() {
        return call_sign;
    }

    public void setCall_sign(String call_sign) {
        this.call_sign = call_sign;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
