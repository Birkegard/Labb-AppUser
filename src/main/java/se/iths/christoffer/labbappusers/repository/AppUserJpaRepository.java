package se.iths.christoffer.labbappusers.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import se.iths.christoffer.labbappusers.entity.AppUser;

import java.util.List;

@ApplicationScoped
public class AppUserJpaRepository implements AppUserRepository {
    @PersistenceContext(unitName = "neon_database_appuser")
    private EntityManager entityManager;

    @Override
    public AppUser saveUser(AppUser user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public List<AppUser> findAllUsers() {
        return entityManager.createQuery(
                "SELECT m FROM AppUser m", AppUser.class).getResultList();
    }
}
