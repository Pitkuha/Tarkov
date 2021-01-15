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

    @Query("select count(fi) from FighterInventory fi where " +
            "(:ammo_id is null and fi.ammunition_id is null or fi.ammunition_id = :ammo_id)" +
            "and (:armor_id is null and fi.armor_id is null or fi.armor_id = :armor_id)" +
            "and (:helmet_id is null and fi.helmet_id is null or fi.helmet_id = :helmet_id)" +
            "and (:magazine_id is null and fi.magazine_id is null or fi.magazine_id = :magazine_id)" +
            "and (:medicine_id is null and fi.medicine_id is null or fi.medicine_id = :medicine_id)" +
            "and (:provision_id is null and fi.provision_id is null or fi.provision_id = :provision_id)" +
            "and (:weapon_id is null and fi.weapon_id is null or fi.weapon_id = :weapon_id)" +
            "and (:fighter_id is null and fi.fighterId is null or fi.fighterId = :fighter_id)")
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
    void updateAfterBuying(@Param("ammo_id") Ammunition ammo_id
            ,@Param("armor_id") Armor armor_id
            ,@Param("helmet_id") Helmet helmet_id
            ,@Param("magazine_id") Magazin magazine_id
            ,@Param("medicine_id") Medicine medicine_id
            ,@Param("provision_id") Provision provision_id
            ,@Param("weapon_id") Weapon weapon_id
            ,@Param("amount") int amount
            ,@Param("InvId") long invId);

    @Query("select fi from FighterInventory fi where" +
            "(:ammo_id is null and fi.ammunition_id is null or fi.ammunition_id = :ammo_id)" +
            "and (:armor_id is null and fi.armor_id is null or fi.armor_id = :armor_id)" +
            "and (:helmet_id is null and fi.helmet_id is null or fi.helmet_id = :helmet_id)" +
            "and (:magazine_id is null and fi.magazine_id is null or fi.magazine_id = :magazine_id)" +
            "and (:medicine_id is null and fi.medicine_id is null or fi.medicine_id = :medicine_id)" +
            "and (:provision_id is null and fi.provision_id is null or fi.provision_id = :provision_id)" +
            "and (:weapon_id is null and fi.weapon_id is null or fi.weapon_id = :weapon_id)" +
            "and (:fighter_id is null and fi.fighterId is null or fi.fighterId = :fighter_id)")
    List<FighterInventory> getFighterInventoryId(@Param("fighter_id") Fighter fighter_id
            ,@Param("ammo_id") Ammunition ammo_id
            ,@Param("armor_id") Armor armor_id
            ,@Param("helmet_id") Helmet helmet_id
            ,@Param("magazine_id") Magazin magazine_id
            ,@Param("medicine_id") Medicine medicine_id
            ,@Param("provision_id") Provision provision_id
            ,@Param("weapon_id") Weapon weapon_id);
}
