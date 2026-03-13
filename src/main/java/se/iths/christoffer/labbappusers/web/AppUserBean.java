package se.iths.christoffer.labbappusers.web;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import se.iths.christoffer.labbappusers.entity.AppUser;
import se.iths.christoffer.labbappusers.service.AppUserService;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AppUserBean implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Inject
    AppUserService appUserService;
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String password;

    public List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }

    public void saveUser() {
        appUserService.saveUser(new AppUser(username, password));
        username = "";
        password = "";
    }
}
