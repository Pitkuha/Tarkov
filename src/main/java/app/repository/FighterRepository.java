package app.repository;

import app.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface FighterRepository extends JpaRepository<Fighter, Long> {
    List<Fighter> findByCallsign(String name);

    @Transactional
    @Modifying
    @Query("update Fighter f set f.task = :taskid where f.callsign = :callsign")
    void updateCurrentTask(@Param("taskid") Task task_id , @Param("callsign") String name);

    @Query("select f.task from Fighter f where f.callsign = :name")
    Task findTask(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("update Fighter f set f.task = null, f.money = f.money + :reward where f.callsign = :name")
    void updateMoney(@Param("name") String name, @Param("reward") double reward);

    @Transactional
    @Modifying
    @Query("update Fighter f set f.money = f.money - :money where f.callsign = :name")
    void updateMoneyAfterBuying(@Param("name") String name, @Param("money") double money);

    @Transactional
    @Modifying
    @Query("update Fighter f set f.task = null where f.callsign = :name")
    void updateTaskNull (@Param("name")String name);

    @Query("select count(fi.id) from FighterInventory fi where fi.ammunition_id = :ammo_id " +
            "and fi.armor_id = :armor_id " +
            "and fi.helmet_id = :helmet_id " +
            "and fi.magazine_id = :magazine_id " +
            "and fi.medicine_id = :medicine_id " +
            "and fi.provision_id = :provision_id " +
            "and fi.weapon_id = :weapon_id " +
            "and fi.fighterId = :fighter_id")
    int checkExists(@Param("fighter_id") Fighter fighter_id
            ,@Param("ammo_id") Ammunition ammo_id
            ,@Param("armor_id") Armor armor_id
            ,@Param("helmet_id") Helmet helmet_id
            ,@Param("magazine_id") Magazin magazine_id
            ,@Param("medicine_id") Medicine medicine_id
            ,@Param("provision_id") Provision provision_id
            ,@Param("weapon_id") Weapon weapon_id);

    @Transactional
    @Modifying
    @Query("update FighterInventory fi set fi.helmet_id = :helmet_id" +
            ", fi.ammunition_id = :ammo_id" +
            ", fi.armor_id = :armor_id" +
            ", fi.magazine_id = :magazine_id" +
            ", fi.medicine_id = :medicine_id" +
            ", fi.provision_id = :provision_id" +
            ", fi.weapon_id = :weapon_id" +
            ", fi.amount = fi.amount + :amount where fi.id = :InvId")
    void updateAfterBuying(@Param("ammo_id") long ammo_id
            ,@Param("armor_id") long armor_id
            ,@Param("helmet_id") long helmet_id
            ,@Param("magazine_id") long magazine_id
            ,@Param("medicine_id") long medicine_id
            ,@Param("provision_id") long provision_id
            ,@Param("weapon_id") long weapon_id
            ,@Param("amount") int amount
            ,@Param("InvId") long invId);

    @Query("select fi from FighterInventory fi where fi.helmet_id = :helmet_id " +
            "and fi.ammunition_id = :ammo_id " +
            "and fi.armor_id = :armor_id " +
            "and fi.magazine_id = :magazine_id " +
            "and fi.medicine_id = :medicine_id " +
            "and fi.provision_id = :provision_id " +
            "and fi.weapon_id = :weapon_id " +
            "and fi.amount = :amount " +
            "and fi.fighterId = :fighter_id")
    FighterInventory getFighterInventoryId(@Param("fighter_id") long fighter_id
            ,@Param("ammo_id") long ammo_id
            ,@Param("armor_id") long armor_id
            ,@Param("helmet_id") long helmet_id
            ,@Param("magazine_id") long magazine_id
            ,@Param("medicine_id") long medicine_id
            ,@Param("provision_id") long provision_id
            ,@Param("weapon_id") long weapon_id
            ,@Param("amount") int amount);
}
