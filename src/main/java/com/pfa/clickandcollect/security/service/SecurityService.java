package com.pfa.clickandcollect.security.service;

import com.pfa.clickandcollect.security.entities.AppRole;
import com.pfa.clickandcollect.security.entities.AppUser;


public interface SecurityService {
    AppUser saveNewUser(String username, String password, String passwordV);
    AppRole saveNewRole(String role, String description);
    void addRoleToUser(String username, String role);
    void removeRoleFromUser(String username, String role);
    AppUser loadUserByUsername(String username);
}