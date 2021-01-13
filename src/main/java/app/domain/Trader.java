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

    @Column(name = "callsign")
    private String callsign;
    @Column(name = "Money")
    private double money;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "TraderTask",
//    joinColumns = {@JoinColumn(name = "Trader_ID")},
//    inverseJoinColumns = {@JoinColumn(name = "Task_ID")})
//    private Set<Task> tasks = new HashSet<>();

    @OneToMany(mappedBy = "task")
    private Set<TraderTasks> traderTasks = new HashSet<>();

    @OneToMany(mappedBy = "fighter_id")
    private Set<Trust> trusts = new HashSet<>();

    public Trader(String callsign, double money) {
        this.callsign = callsign;
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

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String call_sign) {
        this.callsign = call_sign;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Set<TraderTasks> getTraderTasks() {
        return traderTasks;
    }

    public void setTraderTasks(Set<TraderTasks> tasks) {
        this.traderTasks = tasks;
    }

    public Set<Trust> getTrusts() {
        return trusts;
    }

    public void setTrusts(Set<Trust> trusts) {
        this.trusts = trusts;
    }
}
