package app.service;

import app.domain.FighterInventory;
import app.domain.Trader;
import app.domain.TraderInventory;
import app.repository.*;
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
    private final TrustRepository trustRepository;

    public TraderDTOService(TraderRepository traderRepository, TraderInventoryRepository traderInventoryRepository, FighterRepository fighterRepository, FighterInventoryRepository fighterInventoryRepository, TrustRepository trustRepository) {
        this.traderRepository = traderRepository;
        this.traderInventoryRepository = traderInventoryRepository;
        this.fighterRepository = fighterRepository;
        this.fighterInventoryRepository = fighterInventoryRepository;
        this.trustRepository = trustRepository;
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

    public String buyItem(String name, TraderInventory request, HttpServletResponse httpServletResponse) throws IOException {
        if (traderInventoryRepository.findTI(request.getId()) == null){
            httpServletResponse.sendError(418, "несуществующее говно");
            return "Несущ. говно";
        } else {
        double price = traderInventoryRepository.findTI(request.getId()).getPrice();
        if (traderInventoryRepository.findTI(request.getId()).getAmount() < request.getAmount()){
            httpServletResponse.sendError(418,"Столько нет в наличии");
            return "Столько нет в наличии";
        } else if(fighterRepository.findByCallsign(name).get(0).getMoney() < price * request.getAmount()){
            httpServletResponse.sendError(418,"Столько нет денег");
            return "Столько нет денег";
        } else {
            traderInventoryRepository.updateInventoryTrader(request.getId(), request.getAmount());
            traderRepository.updateTraderMoney(traderInventoryRepository.findByTraderInvId(request.getId()), price * request.getAmount());
            fighterRepository.updateMoneyAfterBuying(name, price * request.getAmount());
            if (request.getAmount() * price >= 100000){
                if(trustRepository.checkTrustLvl(traderInventoryRepository.findTI(request.getId()).getTraderId(),fighterRepository.findByCallsign(name).get(0)) < 4) {
                    trustRepository.updateTrust(traderInventoryRepository.findTI(request.getId()).getTraderId(), fighterRepository.findByCallsign(name).get(0));
                }
            }
            if (fighterRepository.checkExists(fighterRepository.findByCallsign(name).get(0)
                    , traderInventoryRepository.findTI(request.getId()).getAmmunition_id()
                    , traderInventoryRepository.findTI(request.getId()).getArmor_id()
                    , traderInventoryRepository.findTI(request.getId()).getHelmet_id()
                    , traderInventoryRepository.findTI(request.getId()).getMagazine_id()
                    , traderInventoryRepository.findTI(request.getId()).getMedicine_id()
                    , traderInventoryRepository.findTI(request.getId()).getProvision_id()
                    , traderInventoryRepository.findTI(request.getId()).getWeapon_id()) == 0) {
                fighterInventoryRepository.save(new FighterInventory(fighterRepository.findByCallsign(name).get(0)
                        , traderInventoryRepository.findTI(request.getId()).getWeapon_id()
                        , traderInventoryRepository.findTI(request.getId()).getAmmunition_id()
                        , traderInventoryRepository.findTI(request.getId()).getMagazine_id()
                        , traderInventoryRepository.findTI(request.getId()).getMedicine_id()
                        , traderInventoryRepository.findTI(request.getId()).getProvision_id()
                        , traderInventoryRepository.findTI(request.getId()).getArmor_id()
                        , traderInventoryRepository.findTI(request.getId()).getHelmet_id()
                        , request.getAmount()));
            } else {
                fighterRepository.updateAfterBuying(
                        traderInventoryRepository.findTI(request.getId()).getAmmunition_id()
                        , traderInventoryRepository.findTI(request.getId()).getArmor_id()
                        , traderInventoryRepository.findTI(request.getId()).getHelmet_id()
                        , traderInventoryRepository.findTI(request.getId()).getMagazine_id()
                        , traderInventoryRepository.findTI(request.getId()).getMedicine_id()
                        , traderInventoryRepository.findTI(request.getId()).getProvision_id()
                        , traderInventoryRepository.findTI(request.getId()).getWeapon_id()
                        , request.getAmount()
                        , fighterRepository.getFighterInventoryId(fighterRepository.findByCallsign(name).get(0)
                                , traderInventoryRepository.findTI(request.getId()).getAmmunition_id()
                                , traderInventoryRepository.findTI(request.getId()).getArmor_id()
                                , traderInventoryRepository.findTI(request.getId()).getHelmet_id()
                                , traderInventoryRepository.findTI(request.getId()).getMagazine_id()
                                , traderInventoryRepository.findTI(request.getId()).getMedicine_id()
                                , traderInventoryRepository.findTI(request.getId()).getProvision_id()
                                , traderInventoryRepository.findTI(request.getId()).getWeapon_id()).get(0).getId());
            }
            return "buyItem() ok!";
            }
        }
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
