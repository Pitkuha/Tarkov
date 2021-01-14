package app;

import app.domain.FighterInventory;
import app.domain.Trader;
import app.domain.TraderInventory;
import app.service.FighterDTOService;
import app.service.TraderDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private TraderDTOService traderDTOService;

    @Autowired
    private FighterDTOService fighterDTOService;

    @GetMapping("/TraderInventory")
    public List<TraderInventory> getTraderInventory(@RequestParam(name = "callsign", required = true) String callsign){
        return traderDTOService.getAllInventory(callsign);
    }

    @GetMapping("/FighterInventory")
    public List<FighterInventory> getFighterInventory(Principal principal){
        return fighterDTOService.getAllInventory(principal.getName());
    }

    
}
