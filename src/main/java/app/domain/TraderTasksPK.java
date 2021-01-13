package app.domain;

import java.io.Serializable;

public class TraderTasksPK implements Serializable {
    private long task_id;
    private long trader_id;

    public TraderTasksPK(long task_id, long trader_id) {
        this.task_id = task_id;
        this.trader_id = trader_id;
    }

    public TraderTasksPK() {
    }

    public long getTask_id() {
        return task_id;
    }

    public void setTask_id(long task_id) {
        this.task_id = task_id;
    }

    public long getTrader_id() {
        return trader_id;
    }

    public void setTrader_id(long trader_id) {
        this.trader_id = trader_id;
    }
}
