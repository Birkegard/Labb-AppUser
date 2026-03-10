package se.iths.christoffer.labbappusers.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import se.iths.christoffer.labbappusers.entity.AppUser;
import se.iths.christoffer.labbappusers.repository.AppUserRepository;

import java.util.List;

@RequestScoped
public class AppUserService {

    private AppUserRepository appUserRepository;

    public AppUserService() {
    }

    @Inject
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Transactional
    public AppUser saveUser(AppUser user) {
        return appUserRepository.saveUser(user);
    }

    public List<AppUser> getAllUsers() {
        List<AppUser> userList = appUserRepository.findAllUsers();
        return userList;
    }

    public AppUser findUser(String username, String password) {
        return appUserRepository.findUser(username, password);
    }
}
