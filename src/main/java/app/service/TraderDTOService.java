package app.service;

import app.domain.FighterInventory;
import app.domain.Trader;
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

    public String buyItem(String name, TraderInventory request){
        traderInventoryRepository.updateInventoryTrader(request.getId(),request.getAmount());
        traderRepository.updateTraderMoney(traderInventoryRepository.findByTraderInvId(request.getId()),request.getPrice() * request.getAmount());
        fighterRepository.updateMoneyAfterBuying(name,request.getPrice() * request.getAmount());
        if (fighterRepository.checkExists(fighterRepository.findByCallsign(name).get(0)
                ,traderInventoryRepository.findTI(request.getId()).getAmmunition_id()
                ,traderInventoryRepository.findTI(request.getId()).getArmor_id()
                ,traderInventoryRepository.findTI(request.getId()).getHelmet_id()
                ,traderInventoryRepository.findTI(request.getId()).getMagazine_id()
                ,traderInventoryRepository.findTI(request.getId()).getMedicine_id()
                ,traderInventoryRepository.findTI(request.getId()).getProvision_id()
                ,traderInventoryRepository.findTI(request.getId()).getWeapon_id()) == 0){
            fighterInventoryRepository.save(new FighterInventory(fighterRepository.findByCallsign(name).get(0)
                    ,traderInventoryRepository.findTI(request.getId()).getWeapon_id()
                    ,traderInventoryRepository.findTI(request.getId()).getAmmunition_id()
                    ,traderInventoryRepository.findTI(request.getId()).getMagazine_id()
                    ,traderInventoryRepository.findTI(request.getId()).getMedicine_id()
                    ,traderInventoryRepository.findTI(request.getId()).getProvision_id()
                    ,traderInventoryRepository.findTI(request.getId()).getArmor_id()
                    ,traderInventoryRepository.findTI(request.getId()).getHelmet_id()
                    ,request.getAmount()));
        } else {
            fighterRepository.updateAfterBuying(
                     traderInventoryRepository.findTI(request.getId()).getAmmunition_id()
                    ,traderInventoryRepository.findTI(request.getId()).getArmor_id()
                    ,traderInventoryRepository.findTI(request.getId()).getHelmet_id()
                    ,traderInventoryRepository.findTI(request.getId()).getMagazine_id()
                    ,traderInventoryRepository.findTI(request.getId()).getMedicine_id()
                    ,traderInventoryRepository.findTI(request.getId()).getProvision_id()
                    ,traderInventoryRepository.findTI(request.getId()).getWeapon_id()
                    ,request.getAmount()
                    ,fighterRepository.getFighterInventoryId(fighterRepository.findByCallsign(name).get(0)
                            ,traderInventoryRepository.findTI(request.getId()).getAmmunition_id()
                            ,traderInventoryRepository.findTI(request.getId()).getArmor_id()
                            ,traderInventoryRepository.findTI(request.getId()).getHelmet_id()
                            ,traderInventoryRepository.findTI(request.getId()).getMagazine_id()
                            ,traderInventoryRepository.findTI(request.getId()).getMedicine_id()
                            ,traderInventoryRepository.findTI(request.getId()).getProvision_id()
                            ,traderInventoryRepository.findTI(request.getId()).getWeapon_id()).get(0).getId());
        }
        return "buyItem() ok!";
    }

    public Trader getTrader(String name, HttpServletResponse httpServletResponse) throws IOException {
        List<Trader> trader = traderRepository.findByCallsign(name);
        if (trader.isEmpty()){
            httpServletResponse.sendError(418,"Несуществующий традер");
            return null;
        } else {
            return trader.get(0);
        }
    }
}
