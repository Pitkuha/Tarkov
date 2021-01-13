package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "TraderTasks")
//@IdClass(TraderTasksPK.class)
public class TraderTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @Id
    @ManyToOne
    @JoinColumn(name = "trader_id", referencedColumnName = "id")
    private Trader trader_id;

//    @Id
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

    public TraderTasks(Trader trader_id, Task task) {
        this.trader_id = trader_id;
        this.task = task;
    }

    public TraderTasks() {
    }

    public Trader getTrader_id() {
        return trader_id;
    }

    public void setTrader_id(Trader trader_id) {
        this.trader_id = trader_id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task_id) {
        this.task = task_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
