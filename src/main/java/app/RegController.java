package app;

import app.domain.Fighter;
import app.domain.UserDTO;
import app.service.FighterDTOService;
import app.service.TrustDTOService;
import app.service.UserDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
public class RegController {
    @Autowired
    private UserDTOService userDTOService;

    @Autowired
    private FighterDTOService fighterDTOService;

    @GetMapping("/UserInfo")
    public Fighter getFighter(Principal principal){
        return userDTOService.getFighter(principal.getName());
    }

    @PostMapping("/registration")
    public void addUser(UserDTO user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (!userDTOService.isLoginVacant(user.getUsername())) {
            //response.sendRedirect("/error.html");
            response.sendRedirect("/registration.html?error");
        } else {
            userDTOService.register(user);
            fighterDTOService.addFighter(user);
            request.login(user.getUsername(), user.getPassword());
            //response.sendRedirect("/work.html");
            response.sendRedirect("/AfterAvtor.html");
        }

    }

    @PostMapping("/login")
    public void login(UserDTO user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("LOGIN LOGIN LOGIN LOGIN LOGIN LOGIN ");
        System.out.println("USERNAME: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        if (userDTOService.isLoginThere(user.getUsername(), user.getPassword())) {
            request.login(user.getUsername(), user.getPassword());
            //Для проверки работоспособностей расскоментить строчку ниже
            //response.sendRedirect("/work.html");
            response.sendRedirect("/AfterAvtor.html");
        } else {
            //response.sendRedirect("/error.html");
            response.sendRedirect("/login.html?error");
        }
    }
}
