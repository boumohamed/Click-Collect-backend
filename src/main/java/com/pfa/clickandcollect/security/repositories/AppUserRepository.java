package com.pfa.clickandcollect.security.repositories;

import com.pfa.clickandcollect.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository  extends JpaRepository<AppUser, String> {
    public AppUser findByUsername(String username);
}