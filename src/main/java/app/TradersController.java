package app;

import app.domain.Trader;
import app.domain.TraderInventory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TradersController {

    public List<TraderInventory> getInventory(@Valid @RequestBody Trader trader){
        return
    }
}
