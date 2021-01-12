package app;

import app.domain.Trader;
import app.domain.TraderInventory;
import app.service.TraderDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TradersController {

    @Autowired
    private TraderDTOService traderDTOService;

    @GetMapping("/TraderInventory")
    public List<TraderInventory> getInventory(@RequestParam(name = "callsign", required = true) String callsign){
        return traderDTOService.getAllInventory(callsign);
    }
}
