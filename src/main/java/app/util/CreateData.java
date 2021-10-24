package app.util;

import app.domain.*;
import app.repository.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CreateData {
    private final TraderRepository traderRepository;
    private final TaskRepository taskRepository;
    private final TraderTasksRepository traderTasksRepository;
    private final HelmetRepository helmetRepository;
    private final TraderInventoryRepository traderInventoryRepository;
    private final AmmunitionRepository ammunitionRepository;
    private final MagazinRepository magazinRepository;
    private final MedicineRepository medicineRepository;
    private final ArmorRepository armorRepository;
    private final ProvisionRepository provisionRepository;
    private final WeaponRepository weaponRepository;
    public CreateData(TraderRepository traderRepository, TaskRepository taskRepository, TraderTasksRepository traderTasksRepository, HelmetRepository helmetRepository, TraderInventoryRepository traderInventoryRepository, AmmunitionRepository ammunitionRepository, MagazinRepository magazinRepository, MedicineRepository medicineRepository, ArmorRepository armorRepository, ProvisionRepository provisionRepository, WeaponRepository weaponRepository) {
        this.traderRepository = traderRepository;
        this.taskRepository = taskRepository;
        this.traderTasksRepository = traderTasksRepository;
        this.helmetRepository = helmetRepository;
        this.traderInventoryRepository = traderInventoryRepository;
        this.ammunitionRepository = ammunitionRepository;
        this.magazinRepository = magazinRepository;
        this.medicineRepository = medicineRepository;
        this.armorRepository = armorRepository;
        this.provisionRepository = provisionRepository;
        this.weaponRepository = weaponRepository;
    }

    //TODO Комментарии
    //Обновим название методов, для того, чтобы комментарии были излишни
    @PostConstruct
    public void addInTables(){
        if (taskRepository.findAll().isEmpty()) {
            //Tasks
            taskRepository.save(new Task("Пикник со стрельбой", 20000, "Уничтожить 15 диких в лесу", 1));
            taskRepository.save(new Task("Гренадёр", 50000, "Уничтожить 12 операторов ЧВК с помощью гранат", 2));
            taskRepository.save(new Task("Операция Водолей", 14000, "Найти спрятонную команату с водой в общежитии", 1));
            taskRepository.save(new Task("Планы снабжения", 70000, "Найти защищенную папку на Лесопилке", 3));
            taskRepository.save(new Task("Осведомлен, значит вооружён", 90000, "Установить WIFI камеру для наблюдения за причалом. Установить WIFI камеру для наблюдения за дорогой в припортовую зону.", 4));
        }


        if (traderRepository.findAll().isEmpty()) {
            traderRepository.save(new Trader("Prapor", 600000));
            traderRepository.save(new Trader("Terapevt", 600000));
            traderRepository.save(new Trader("Skupshik", 600000));
            traderRepository.save(new Trader("Lizhnik", 600000));
            traderRepository.save(new Trader("Mirotvorec", 600000));
            traderRepository.save(new Trader("Mechanic", 600000));
            traderRepository.save(new Trader("Baracholshik", 600000));
            traderRepository.save(new Trader("Eger", 600000));
        }

//        List<Trader> traders = traderRepository.findAll();
//        List<Task> tasks = taskRepository.findAll();
//        traders.stream().forEach((trader -> {
//            tasks.stream().forEach((task -> {traderTasksRepository.save(new TraderTasks(trader,task));}));
//        }));
//        System.out.println("ready");

        if (traderTasksRepository.findAll().isEmpty()) {
            traderTasksRepository.save(new TraderTasks(traderRepository.findByCallsign("Prapor").get(0), taskRepository.foundTask("Пикник со стрельбой")));
            traderTasksRepository.save(new TraderTasks(traderRepository.findByCallsign("Prapor").get(0), taskRepository.foundTask("Гренадёр")));
            traderTasksRepository.save(new TraderTasks(traderRepository.findByCallsign("Terapevt").get(0), taskRepository.foundTask("Операция Водолей")));
            traderTasksRepository.save(new TraderTasks(traderRepository.findByCallsign("Terapevt").get(0), taskRepository.foundTask("Планы снабжения")));
            traderTasksRepository.save(new TraderTasks(traderRepository.findByCallsign("Lizhnik").get(0), taskRepository.foundTask("Осведомлен, значит вооружён")));
        }

        Helmet helmet1 = new Helmet("СШ-68",3,"Баллистическая сталь",100,30);
        Helmet helmet2 = new Helmet("Ратник-БШ",3,"Аллюминий",100,30);
        Helmet helmet3 = new Helmet("Колпак 1",2,"Арамид",100,10);
        Helmet helmet4 = new Helmet("Ops-Core Fast",4,"Комбинированные материалы",100,30);
        if (helmetRepository.findAll().isEmpty()) {
            helmetRepository.save(helmet1);
            helmetRepository.save(helmet2);
            helmetRepository.save(helmet3);
            helmetRepository.save(helmet4);
        }

        Ammunition ammunition1 = new Ammunition(7.62, 700);
        Ammunition ammunition2 = new Ammunition(5.45, 883);
        Ammunition ammunition3 = new Ammunition(7, 415);
        Ammunition ammunition4 = new Ammunition(9, 380);
        if (ammunitionRepository.findAll().isEmpty()) {
            ammunitionRepository.save(ammunition1);
            ammunitionRepository.save(ammunition2);
            ammunitionRepository.save(ammunition3);
            ammunitionRepository.save(ammunition4);
        }

        Magazin magazin1 = new Magazin(3, 5.45);
        Magazin magazin2 = new Magazin(4, 7.62);
        Magazin magazin3 = new Magazin(1, 9);
        Magazin magazin4 = new Magazin(3, 5.56);

        if (magazinRepository.findAll().isEmpty()) {
            magazinRepository.save(magazin1);
            magazinRepository.save(magazin2);
            magazinRepository.save(magazin3);
            magazinRepository.save(magazin4);
        }

        Medicine medicine1 = new Medicine("АИ-2", 100);
        Medicine medicine2 = new Medicine("Автомобильная аптечка", 200);
        Medicine medicine3 = new Medicine("Salewa", 350);
        Medicine medicine4 = new Medicine("Бинт", 10);

        if (medicineRepository.findAll().isEmpty()) {
            medicineRepository.save(medicine1);
            medicineRepository.save(medicine2);
            medicineRepository.save(medicine3);
            medicineRepository.save(medicine4);
        }

        Armor armor1 = new Armor("PACA", 2, "Арамид", 40);
        Armor armor2 = new Armor("6Б5-15 Улей", 4, "Керамика", 50);
        Armor armor3 = new Armor("6Б43", 3, "Баллистическая сталь", 47);
        Armor armor4 = new Armor("6Б3ТМ-01М", 4, "Титан", 50);

        if (armorRepository.findAll().isEmpty()) {
            armorRepository.save(armor1);
            armorRepository.save(armor2);
            armorRepository.save(armor3);
            armorRepository.save(armor4);
        }

        Provision provision1 = new Provision("Snickers", 30);
        Provision provision2 = new Provision("Галеты", 10);
        Provision provision3 = new Provision("Сайра консервированная", 40);
        Provision provision4 = new Provision("Сухпай Искра", 80);

        if (provisionRepository.findAll().isEmpty()) {
            provisionRepository.save(provision1);
            provisionRepository.save(provision2);
            provisionRepository.save(provision3);
            provisionRepository.save(provision4);
        }

        Weapon weapon1 = new Weapon("Автомат", "АК-74М", 89, 50, 910, 5.45, 100);
        Weapon weapon2 = new Weapon("Пистолет-пулемет", "Витязь-СН", 44, 55, 377, 9, 100);
        Weapon weapon3 = new Weapon("Ружье", "Mossberg 590A1", 98, 52, 436, 12, 100);
        Weapon weapon4 = new Weapon("Автомат", "АКМН", 91, 23, 717, 7.62, 100);

        if (weaponRepository.findAll().isEmpty()) {
            weaponRepository.save(weapon1);
            weaponRepository.save(weapon2);
            weaponRepository.save(weapon3);
            weaponRepository.save(weapon4);
        }

        if (traderInventoryRepository.findAll().isEmpty()) {
            List<Trader> traders = traderRepository.findAll();
            traderInventoryRepository.save(new TraderInventory(traders.get(0), weapon1, null, null, null, null, null, null, 10000, 30000));
            traderInventoryRepository.save(new TraderInventory(traders.get(0), weapon2, null, null, null, null, null, null, 5000, 21500));
            traderInventoryRepository.save(new TraderInventory(traders.get(0), weapon4, null, null, null, null, null, null, 2000, 39900));
            traderInventoryRepository.save(new TraderInventory(traders.get(0), null, ammunition1, null, null, null, null, null, 100000, 140));
            traderInventoryRepository.save(new TraderInventory(traders.get(0), null, ammunition2, null, null, null, null, null, 200000, 100));
            traderInventoryRepository.save(new TraderInventory(traders.get(0), null, ammunition4, null, null, null, null, null, 400000, 75));
            traderInventoryRepository.save(new TraderInventory(traders.get(0), null, null, magazin1, null, null, null, null, 1000, 2000));
            traderInventoryRepository.save(new TraderInventory(traders.get(0), null, null, magazin2, null, null, null, null, 500, 3000));
            traderInventoryRepository.save(new TraderInventory(traders.get(0), null, null, magazin3, null, null, null, null, 2400, 1500));
            traderInventoryRepository.save(new TraderInventory(traders.get(1), null, null, null, medicine1, null, null, null, 10000, 5000));
            traderInventoryRepository.save(new TraderInventory(traders.get(1), null, null, null, medicine2, null, null, null, 7500, 7500));
            traderInventoryRepository.save(new TraderInventory(traders.get(1), null, null, null, medicine3, null, null, null, 5000, 12500));
            traderInventoryRepository.save(new TraderInventory(traders.get(1), null, null, null, medicine4, null, null, null, 12000, 2000));
            traderInventoryRepository.save(new TraderInventory(traders.get(1), null, null, null, null, provision1, null, null, 1000, 120));
            traderInventoryRepository.save(new TraderInventory(traders.get(1), null, null, null, null, provision2, null, null, 1500, 100));
            traderInventoryRepository.save(new TraderInventory(traders.get(1), null, null, null, null, provision3, null, null, 400, 200));
            traderInventoryRepository.save(new TraderInventory(traders.get(1), null, null, null, null, provision4, null, null, 100, 650));
            traderInventoryRepository.save(new TraderInventory(traders.get(6), null, null, null, null, null, armor1, null, 700, 13000));
            traderInventoryRepository.save(new TraderInventory(traders.get(6), null, null, null, null, null, armor2, null, 350, 25000));
            traderInventoryRepository.save(new TraderInventory(traders.get(6), null, null, null, null, null, armor3, null, 200, 40000));
            traderInventoryRepository.save(new TraderInventory(traders.get(6), null, null, null, null, null, armor4, null, 500, 36000));
            traderInventoryRepository.save(new TraderInventory(traders.get(6), null, null, null, null, null, null, helmet1, 1000, 18000));
            traderInventoryRepository.save(new TraderInventory(traders.get(6), null, null, null, null, null, null, helmet2, 900, 21000));
            traderInventoryRepository.save(new TraderInventory(traders.get(6), null, null, null, null, null, null, helmet3, 1500, 8000));
            traderInventoryRepository.save(new TraderInventory(traders.get(6), null, null, null, null, null, null, helmet4, 100, 110000));
            traderInventoryRepository.save(new TraderInventory(traders.get(4), weapon3, null, null, null, null, null, null, 400, 24500));
            traderInventoryRepository.save(new TraderInventory(traders.get(4), null, ammunition3, null, null, null, null, null, 10000, 85));
            traderInventoryRepository.save(new TraderInventory(traders.get(4), null, null, magazin4, null, null, null, null, 1200, 2550));
        }
    }
}
