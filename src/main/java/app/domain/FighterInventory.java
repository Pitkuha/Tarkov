package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "FighterInventory")
@IdClass(FighterInventoryPK.class)
public class FighterInventory {
    @Id
    @ManyToOne
    @JoinColumn(name = "fighter_id", referencedColumnName = "id")
    private Fighter fighter_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "weapon_id", referencedColumnName = "id")
    private Weapon weapon_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "ammunition_id", referencedColumnName = "id")
    private Ammunition ammunition_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "magazine_id", referencedColumnName = "id")
    private Magazin magazine_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "Medicine_id", referencedColumnName = "id")
    private Medicine medicine_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "Provision_id", referencedColumnName = "id")
    private Provision provision_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "Armor_id", referencedColumnName = "id")
    private Armor armor_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "Helmet_id", referencedColumnName = "id")
    private Helmet helmet_id;

    @Column(name = "Amount")
    private int amount;

    public FighterInventory(Fighter fighter_id, Weapon weapon_id, Ammunition ammunition_id, Magazin magazine_id, Medicine medicine_id, Provision provision_id, Armor armor_id, Helmet helmet_id, int amount) {
        this.fighter_id = fighter_id;
        this.weapon_id = weapon_id;
        this.ammunition_id = ammunition_id;
        this.magazine_id = magazine_id;
        this.medicine_id = medicine_id;
        this.provision_id = provision_id;
        this.armor_id = armor_id;
        this.helmet_id = helmet_id;
        this.amount = amount;
    }

    public FighterInventory() {
    }

    public Fighter getFighter_id() {
        return fighter_id;
    }

    public void setFighter_id(Fighter fighter_id) {
        this.fighter_id = fighter_id;
    }

    public Weapon getWeapon_id() {
        return weapon_id;
    }

    public void setWeapon_id(Weapon weapon_id) {
        this.weapon_id = weapon_id;
    }

    public Ammunition getAmmunition_id() {
        return ammunition_id;
    }

    public void setAmmunition_id(Ammunition ammunition_id) {
        this.ammunition_id = ammunition_id;
    }

    public Magazin getMagazine_id() {
        return magazine_id;
    }

    public void setMagazine_id(Magazin magazine_id) {
        this.magazine_id = magazine_id;
    }

    public Medicine getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(Medicine medicine_id) {
        this.medicine_id = medicine_id;
    }

    public Provision getProvision_id() {
        return provision_id;
    }

    public void setProvision_id(Provision provision_id) {
        this.provision_id = provision_id;
    }

    public Armor getArmor_id() {
        return armor_id;
    }

    public void setArmor_id(Armor armor_id) {
        this.armor_id = armor_id;
    }

    public Helmet getHelmet_id() {
        return helmet_id;
    }

    public void setHelmet_id(Helmet helmet_id) {
        this.helmet_id = helmet_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
