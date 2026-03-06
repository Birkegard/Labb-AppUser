package se.iths.christoffer.labbappusers.repository;

import se.iths.christoffer.labbappusers.entity.AppUser;

import java.util.List;

public interface AppUserRepository {
    AppUser saveUser(AppUser user);

    List<AppUser> findAllUsers();
}
