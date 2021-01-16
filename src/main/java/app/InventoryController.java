package app;

import app.domain.FighterInventory;
import app.domain.Trader;
import app.domain.TraderInventory;
import app.service.FighterDTOService;
import app.service.TraderDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private TraderDTOService traderDTOService;

    @Autowired
    private FighterDTOService fighterDTOService;

    @GetMapping("/TraderInventory")
    public List<TraderInventory> getTraderInventory(@RequestParam(name = "callsign", required = true) String callsign, HttpServletResponse response) throws IOException {
        return traderDTOService.getAllInventory(callsign, response);
    }

    @GetMapping("/FighterInventory")
    public List<FighterInventory> getFighterInventory(Principal principal){
        return fighterDTOService.getAllInventory(principal.getName());
    }

    @PostMapping(value = "/buy", produces = "application/json")
    public String buyItems(@Valid @RequestBody TraderInventory request, Principal principal, HttpServletResponse httpServletResponse) throws IOException {
        traderDTOService.buyItem(principal.getName(),request,httpServletResponse);
        return "buy ok!";
    }
    
    @GetMapping("/getTrader")
    public Trader getTrader(@RequestParam(name = "callsign", required = true) String request, HttpServletResponse httpServletResponse) throws IOException {
        return traderDTOService.getTrader(request, httpServletResponse);
    }
}
