package se.iths.christoffer.labbappusers.repository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import se.iths.christoffer.labbappusers.entity.AppUser;

import java.util.List;

@RequestScoped
public class AppUserJpaRepository implements AppUserRepository {
    @Inject
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

    @Override
    public AppUser findUser(String username, String password) {
        TypedQuery<AppUser> query = entityManager.createQuery(
                "SELECT u FROM AppUser u WHERE u.username = :username AND u.password = :password",
                AppUser.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
