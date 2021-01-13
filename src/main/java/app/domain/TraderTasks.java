package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "TraderTasks")
@IdClass(TraderTasksPK.class)
public class TraderTasks {
    @Id
    @ManyToOne
    @JoinColumn(name = "trader_id", referencedColumnName = "id")
    private Trader trader_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task_id;

    public TraderTasks(Trader trader_id, Task task_id) {
        this.trader_id = trader_id;
        this.task_id = task_id;
    }

    public TraderTasks() {
    }

    public Trader getTrader_id() {
        return trader_id;
    }

    public void setTrader_id(Trader trader_id) {
        this.trader_id = trader_id;
    }

    public Task getTask_id() {
        return task_id;
    }

    public void setTask_id(Task task_id) {
        this.task_id = task_id;
    }
}
