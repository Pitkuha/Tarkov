package app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Fighter")
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Callsign")
    private String callsign;

    @OneToOne
    private Task task;

    @Column(name = "Money")
    private double money;

    @OneToMany(mappedBy = "trader_id")
    private Set<Trust> trusts = new HashSet<>();

    public Fighter(String callsign, Task task, double money) {
        this.callsign = callsign;
        this.task = task;
        this.money = money;
    }

    public Fighter() {
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

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
