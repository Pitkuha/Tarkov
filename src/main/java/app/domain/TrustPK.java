package app.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

public class TrustPK implements Serializable {
    private long fighter_id;
    private long trader_id;

    public TrustPK(long fighter_id, long trader_id) {
        this.fighter_id = fighter_id;
        this.trader_id = trader_id;
    }

    public TrustPK() {
    }

    public long getFighter_id() {
        return fighter_id;
    }

    public void setFighter_id(long fighter_id) {
        this.fighter_id = fighter_id;
    }

    public long getTrader_id() {
        return trader_id;
    }

    public void setTrader_id(long trader_id) {
        this.trader_id = trader_id;
    }
}
