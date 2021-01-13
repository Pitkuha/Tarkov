package app.DTO;

import app.domain.Task;
import app.domain.Trader;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class TraderDTO {
    @NotNull
    private String callsign;
    @NotNull
    @Min(value = 0)
    private double money;
    private Set<Task> tasks = new HashSet<>();

    public TraderDTO() {
    }

    public TraderDTO(Trader trader) {
        this.callsign = trader.getCallsign();
        this.money = trader.getMoney();
        this.tasks = trader.getTasks();
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
