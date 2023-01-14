package springsecdatajpa.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.service.AppUserService;
import springsecdatajpa.demo.service.TokenService;
import springsecdatajpa.demo.util.MapperClass;

@RestController
@RequestMapping("")
public class WelcomeController {

    private static final Logger LOG = LoggerFactory.getLogger(WelcomeController.class);
    private final AppUserService appUserService;
    private final TokenService tokenService;
    private final MapperClass mapperClass = new MapperClass();

    public WelcomeController(AppUserService appUserService, TokenService tokenService) {
        this.appUserService = appUserService;
        this.tokenService = tokenService;

    }


    @GetMapping("/welcome")
    public String welcomeAll() {
        System.out.println("Are we here?");



        return "Welcome to this Open Endpoint";
    }

    @PostMapping("/authenticate")
    public String authenticateUser(@RequestBody AppUserLoginDTO appUserLoginDTO) {
        System.out.println("Are we here? WELCOMEALL");

        //TODO: Check if user exists and if password exist
        // IF SO--> Return token -> Else deny access
        boolean goodUser = appUserService.checkIfValidUser(appUserLoginDTO);

        if(goodUser){
            // TODO: map dto to realUser
            AppUser appuser = mapperClass.convertDtoToUser(appUserLoginDTO);
            System.out.println(appuser.toString());
            String token = tokenService.generateToken2(appuser);



            System.out.println("In good user");;

            return token;
        }else {
            return "User and user password not found";
        }
    }



    @PostMapping("/givetoken")
    public String givetoken(@RequestBody AppUserLoginDTO appUserLoginDTO){
        System.out.println("Are we here?2222");

//        LOG.debug("Token requested for user: '{}'", appUserLoginDTO.getUsername());
//        //TODO: Check if user exists and if password exist
//        // IF SO--> Return token -> Else deny access
//        boolean goodUser = appUserService.checkIfValidUser(appUserLoginDTO);
//
//
//        String token = tokenService.generateToken2(appUserLoginDTO);
//        LOG.debug("Token granted {}", token);
        return "token";
    }

}
