package app.domain;

import java.io.Serializable;

public class TraderInventoryPK implements Serializable {
    private long trader_id;
    private long weapon_id;
    private long ammunition_id;
    private long magazine_id;
    private long medicine_id;
    private long provision_id;
    private long armor_id;
    private long helmet_id;

    public TraderInventoryPK(long trader_id, long weapon_id, long ammunition_id, long magazine_id, long medicine_id, long provision_id, long armor_id, long helmet_id) {
        this.trader_id = trader_id;
        this.weapon_id = weapon_id;
        this.ammunition_id = ammunition_id;
        this.magazine_id = magazine_id;
        this.medicine_id = medicine_id;
        this.provision_id = provision_id;
        this.armor_id = armor_id;
        this.helmet_id = helmet_id;
    }

    public TraderInventoryPK() {
    }

    public long getTrader_id() {
        return trader_id;
    }

    public void setTrader_id(long trader_id) {
        this.trader_id = trader_id;
    }

    public long getWeapon_id() {
        return weapon_id;
    }

    public void setWeapon_id(long weapon_id) {
        this.weapon_id = weapon_id;
    }

    public long getAmmunition_id() {
        return ammunition_id;
    }

    public void setAmmunition_id(long ammunition_id) {
        this.ammunition_id = ammunition_id;
    }

    public long getMagazine_id() {
        return magazine_id;
    }

    public void setMagazine_id(long magazine_id) {
        this.magazine_id = magazine_id;
    }

    public long getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(long medicine_id) {
        this.medicine_id = medicine_id;
    }

    public long getProvision_id() {
        return provision_id;
    }

    public void setProvision_id(long provision_id) {
        this.provision_id = provision_id;
    }

    public long getArmor_id() {
        return armor_id;
    }

    public void setArmor_id(long armor_id) {
        this.armor_id = armor_id;
    }

    public long getHelmet_id() {
        return helmet_id;
    }

    public void setHelmet_id(long helmet_id) {
        this.helmet_id = helmet_id;
    }
}
