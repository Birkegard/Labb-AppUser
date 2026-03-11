package se.iths.christoffer.labbappusers.web;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import se.iths.christoffer.labbappusers.entity.AppUser;
import se.iths.christoffer.labbappusers.service.AppUserService;

import java.io.Serializable;

@Named
@SessionScoped
public class LogInBean implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Inject
    private AppUserService appUserService;
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String password;

    public String logIn() {
        AppUser user = appUserService.findUser(username, password);
        if (user != null) {
            return "messages";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Wrong username and/or password", null));
            return "login";
        }
    }

    public boolean isLoggedIn() {
        return username != null;
    }

    public String checkAccess() {
        if (!isLoggedIn()) {
            return "login?faces-redirect=true";
        } else {
            return null;
        }
    }

    public String logOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
}
