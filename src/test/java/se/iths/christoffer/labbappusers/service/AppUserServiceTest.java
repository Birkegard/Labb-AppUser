package se.iths.christoffer.labbappusers.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import se.iths.christoffer.labbappusers.EntityManagerProducer;
import se.iths.christoffer.labbappusers.entity.AppUser;
import se.iths.christoffer.labbappusers.repository.AppUserJpaRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableWeld
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppUserServiceTest {

    @WeldSetup
    WeldInitiator weld = WeldInitiator.from(
                    AppUserService.class,
                    AppUserJpaRepository.class,
                    EntityManagerProducer.class)
            .activate(RequestScoped.class)
            .build();

    @Inject
    private AppUserService appUserService;


    @Test
    void saveUser() {
        //arrange
        AppUser user = new AppUser("Jonas", "Lösen");

        //act
        AppUser saveUser = appUserService.saveUser(user);

        //assert
        assertEquals("Jonas", saveUser.getUsername());
        assertEquals("Lösen", saveUser.getPassword());
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void findUser() {
    }
}