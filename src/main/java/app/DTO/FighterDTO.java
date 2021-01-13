package app.DTO;

import app.domain.Fighter;
import app.domain.Task;
import app.domain.Trust;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class FighterDTO {
    @NotNull
    private String callsign;
    private Task task;
    @NotNull
    @Min(value = 0)
    private double money;

    public FighterDTO() {
    }

    public FighterDTO(Fighter fighter) {
        this.callsign = fighter.getCallsign();
        this.task = fighter.getTask();
        this.money = fighter.getMoney();
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
