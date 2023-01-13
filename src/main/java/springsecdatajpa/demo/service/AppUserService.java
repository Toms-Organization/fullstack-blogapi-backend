package springsecdatajpa.demo.service;

import org.springframework.stereotype.Service;
import springsecdatajpa.demo.entity.DTO.AppUserLoginDTO;
import springsecdatajpa.demo.repository.AppUserRepository;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;


    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public boolean checkIfValidUser(AppUserLoginDTO appUserLoginDTO) {

        return true;



    }
}
