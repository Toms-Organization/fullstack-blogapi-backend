package springsecdatajpa.demo.service;

import org.springframework.stereotype.Service;
import springsecdatajpa.demo.entity.AppUser;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.repository.AppUserRepository;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;


    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public boolean checkIfValidUser(AppUserLoginDTO appUserLoginDTO) {
        System.out.println(appUserLoginDTO.toString());
        AppUser thisUser = appUserRepository.findByUsernameAndUserpassword(appUserLoginDTO.getUsername(), appUserLoginDTO.getUserpassword());
        System.out.println(thisUser);
        if (thisUser != null) {
            System.out.println("not null");
            return true;
        } else {
            System.out.println("is null....");
            return false;
        }
    }
}
