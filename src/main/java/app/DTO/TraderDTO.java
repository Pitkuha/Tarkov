package app.DTO;

import app.domain.Task;
import app.domain.Trader;
import app.domain.TraderTasks;
import app.domain.Trust;

import javax.persistence.OneToMany;
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
    private Set<TraderTasks> traderTasks = new HashSet<>();
    private Set<Trust> trusts = new HashSet<>();

    public TraderDTO() {
    }

    public TraderDTO(Trader trader) {
        this.callsign = trader.getCallsign();
        this.money = trader.getMoney();
        this.traderTasks = trader.getTraderTasks();
        this.trusts= trader.getTrusts();
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

    public Set<TraderTasks> getTraderTasks() {
        return traderTasks;
    }

    public void setTraderTasks(Set<TraderTasks> traderTasks) {
        this.traderTasks = traderTasks;
    }

    public Set<Trust> getTrusts() {
        return trusts;
    }

    public void setTrusts(Set<Trust> trusts) {
        this.trusts = trusts;
    }
}
