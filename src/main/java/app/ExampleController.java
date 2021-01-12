package app;

import app.domain.Ammunition;
import app.domain.Helmet;
import app.domain.TraderInventory;
import app.service.HelmetDTOService;
import app.service.TryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class ExampleController {

    @Autowired
    private HelmetDTOService helmetDTOService;

    @Autowired
    private TryService tryService;

    @PostMapping(value = "/helmet", produces = "application/json")
    public String addHelmet(@Valid @RequestBody Helmet request, BindingResult bindingResult, Principal principal){
        System.out.println("==========");
        System.out.println(principal.getName());
        helmetDTOService.save(request);
        System.out.println("Сохранено");
        System.out.println("---------------");
        TraderInventory traderInventory = new TraderInventory();
        tryService.save(traderInventory);
        return "ok";
    }


    @GetMapping("/helmet")
    @ResponseBody
    public List<Helmet> getHelmets(){
        System.out.println("Вывод хелметов");
        return helmetDTOService.loadUsersDots();
    }


}
