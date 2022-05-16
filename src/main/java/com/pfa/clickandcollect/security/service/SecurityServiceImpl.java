package com.pfa.clickandcollect.security.service;

import com.pfa.clickandcollect.security.entities.AppRole;
import com.pfa.clickandcollect.security.entities.AppUser;
import com.pfa.clickandcollect.security.repositories.AppRoleRepository;
import com.pfa.clickandcollect.security.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


//@Service
//@Slf4j
//@Transactional
public class SecurityServiceImpl  {
    @Autowired
    private AppUserRepository userRepo;
    @Autowired
    private AppRoleRepository roleRepo;
    /*@Autowired
    private PasswordEncoder pe;
*/
   /* @Override
    public AppUser saveNewUser(String username, String password, String passwordV) {
        if (!password.equals(passwordV)) throw new RuntimeException("Password not match !");
        String PasswordEncoded = pe.encode(password);
        AppUser user = new AppUser();
        user.setUserId(UUID.randomUUID().toString());
        user.setUsername(username);
        user.setPassword(PasswordEncoded);
        user.setActive(true);
        AppUser savedUser = userRepo.save(user);
        return savedUser;
    }*/

   /* @Override
    public AppRole saveNewRole(String role, String description) {

        AppRole Role = roleRepo.findByRole(role);
        if (Role != null) throw new RuntimeException("Role Already existed");
        Role = new AppRole();
        Role.setRole(role);
        Role.setDescription(description);
        AppRole savedRole = roleRepo.save(Role);
        return savedRole;
    }


    @Override
    public void addRoleToUser(String username, String role) {
        AppRole Role = roleRepo.findByRole(role);

        if (Role == null) throw new RuntimeException("Role " + role + " Not Founde");
        AppUser User = userRepo.findByUsername(username);
        if (User == null) throw new RuntimeException("User " + username + " Not Found");
        User.getAppRoles().add(Role);
    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        AppRole Role = roleRepo.findByRole(role);
        if (Role != null) throw new RuntimeException("Role " + role + " Not Founde");
        AppUser User = userRepo.findByUsername(username);
        if (User != null) throw new RuntimeException("User " + username + " Not Found");
        User.getAppRoles().remove(Role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        AppUser User = userRepo.findByUsername(username);
        return User;
    }*/

}
