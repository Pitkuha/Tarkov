package app.service;

import app.domain.FighterInventory;
import app.domain.TraderInventory;
import app.repository.FighterInventoryRepository;
import app.repository.FighterRepository;
import app.repository.TraderInventoryRepository;
import app.repository.TraderRepository;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class TraderDTOService {
    private final TraderRepository traderRepository;
    private final TraderInventoryRepository traderInventoryRepository;
    private final FighterRepository fighterRepository;
    private final FighterInventoryRepository fighterInventoryRepository;

    public TraderDTOService(TraderRepository traderRepository, TraderInventoryRepository traderInventoryRepository, FighterRepository fighterRepository, FighterInventoryRepository fighterInventoryRepository) {
        this.traderRepository = traderRepository;
        this.traderInventoryRepository = traderInventoryRepository;
        this.fighterRepository = fighterRepository;
        this.fighterInventoryRepository = fighterInventoryRepository;
    }

    public List<TraderInventory> getAllInventory(String name, HttpServletResponse response) throws IOException {
        List<TraderInventory> fromDB;
        try {
            fromDB = traderInventoryRepository.findAllByTraderId(traderRepository.findByCallsign(name).get(0));
        }catch (IndexOutOfBoundsException e){
            fromDB = null;
            response.sendError(418);
        }
        return fromDB;
    }

    public String buyItem(String name, TraderInventory traderInventory){
        traderInventoryRepository.updateInventoryTrader(traderInventory.getId(),traderInventory.getAmount());
        traderRepository.updateTraderMoney(traderInventoryRepository.findByTraderInvId(traderInventory.getId()),traderInventory.getPrice() * traderInventory.getAmount());
        fighterRepository.updateMoneyAfterBuying(name,traderInventory.getPrice() * traderInventory.getAmount());
        if (fighterRepository.checkExists(fighterRepository.findByCallsign(name).get(0)
                ,traderInventoryRepository.findTI(traderInventory.getId()).getAmmunition_id()
                ,traderInventoryRepository.findTI(traderInventory.getId()).getArmor_id()
                ,traderInventoryRepository.findTI(traderInventory.getId()).getHelmet_id()
                ,traderInventoryRepository.findTI(traderInventory.getId()).getMagazine_id()
                ,traderInventoryRepository.findTI(traderInventory.getId()).getMedicine_id()
                ,traderInventoryRepository.findTI(traderInventory.getId()).getProvision_id()
                ,traderInventoryRepository.findTI(traderInventory.getId()).getWeapon_id()) == 0){
            fighterInventoryRepository.save(new FighterInventory(fighterRepository.findByCallsign(name).get(0)
                    ,traderInventoryRepository.findTI(traderInventory.getId()).getWeapon_id()
                    ,traderInventoryRepository.findTI(traderInventory.getId()).getAmmunition_id()
                    ,traderInventoryRepository.findTI(traderInventory.getId()).getMagazine_id()
                    ,traderInventoryRepository.findTI(traderInventory.getId()).getMedicine_id()
                    ,traderInventoryRepository.findTI(traderInventory.getId()).getProvision_id()
                    ,traderInventoryRepository.findTI(traderInventory.getId()).getArmor_id()
                    ,traderInventoryRepository.findTI(traderInventory.getId()).getHelmet_id()
                    ,traderInventory.getAmount()));
        } else {
            fighterRepository.updateAfterBuying(traderInventory.getAmmunition_id().getId()
                    ,traderInventory.getArmor_id().getId()
                    ,traderInventory.getHelmet_id().getId()
                    ,traderInventory.getMagazine_id().getId()
                    ,traderInventory.getMedicine_id().getId()
                    ,traderInventory.getProvision_id().getId()
                    ,traderInventory.getWeapon_id().getId()
                    ,traderInventory.getAmount()
                    ,fighterRepository.getFighterInventoryId(fighterRepository.findByCallsign(name).get(0).getId()
                            ,traderInventory.getAmmunition_id().getId()
                            ,traderInventory.getArmor_id().getId()
                            ,traderInventory.getHelmet_id().getId()
                            ,traderInventory.getMagazine_id().getId()
                            ,traderInventory.getMedicine_id().getId()
                            ,traderInventory.getProvision_id().getId()
                            ,traderInventory.getWeapon_id().getId()
                            ,traderInventory.getAmount()).getId());
        }

        return "buyItem() ok!";
    }
}
