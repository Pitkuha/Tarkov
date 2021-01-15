package app;

import app.domain.FighterInventory;
import app.domain.Trader;
import app.domain.TraderInventory;
import app.service.FighterDTOService;
import app.service.TraderDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/buy", produces = "application/json")
    public String buyItems(@Valid @RequestBody TraderInventory request, Principal principal){
        traderDTOService.buyItem(principal.getName(),request);
        return "buy ok!";
    }
}
