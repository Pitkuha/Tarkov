package app.DTO;

import app.domain.Trader;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TraderDTO {
    @NotNull
    private String callsign;
    @NotNull
    @Min(value = 0)
    private double money;

    public TraderDTO() {
    }

    public TraderDTO(Trader trader) {
        this.callsign = trader.getCallsign();
        this.money = trader.getMoney();
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
