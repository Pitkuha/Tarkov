package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "Trust")
@IdClass(TrustPK.class)
public class Trust {
    @Id
    @ManyToOne
    @JoinColumn(name = "fighter_id", referencedColumnName = "id")
    private Fighter fighter_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "trader_id", referencedColumnName = "id")
    private Trader trader_id;

    @Column(name = "Trust_Level")
    private int trust_level;

    public Trust(Fighter fighter_id, Trader trader_id, int trust_level) {
        this.fighter_id = fighter_id;
        this.trader_id = trader_id;
        this.trust_level = trust_level;
    }

    public Trust() {
    }

    public Fighter getFighter_id() {
        return fighter_id;
    }

    public void setFighter_id(Fighter fighter_id) {
        this.fighter_id = fighter_id;
    }

    public Trader getTrader_id() {
        return trader_id;
    }

    public void setTrader_id(Trader trader_id) {
        this.trader_id = trader_id;
    }

    public int getTrust_level() {
        return trust_level;
    }

    public void setTrust_level(int trust_level) {
        this.trust_level = trust_level;
    }
}
