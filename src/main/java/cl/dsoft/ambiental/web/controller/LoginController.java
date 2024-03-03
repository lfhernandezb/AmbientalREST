package cl.dsoft.ambiental.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static Logger logger = LogManager.getLogger(LoginController.class);

    //@CrossOrigin(origins = "http://localhost:4200")
    //@RequestMapping("/user")
    @GetMapping("")
    public Principal user(Principal user) {
        return user;
    }
}
