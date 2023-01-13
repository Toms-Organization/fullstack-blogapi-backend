package springsecdatajpa.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.service.TokenService;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    private final TokenService tokenService;

    public LoginController(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @GetMapping("")
    public String loginScreen() {
        return "This should be protected.. You are in login.....";
    }




    @PostMapping("/givetoken")
    public String givetoken(@RequestBody AppUserLoginDTO appUserLoginDTO){
        LOG.debug("Token requested for user: '{}'", appUserLoginDTO.getUsername());
        String token = tokenService.generateToken2(appUserLoginDTO);
        LOG.debug("Token granted {}", token);
        return token;
    }

}
