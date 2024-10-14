package com.banking.app.Services;

import com.banking.app.Entity.User;
import com.banking.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired      //Constructor injection
    public UserServices(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        if(userRepo == null || passwordEncoder == null){
            throw new IllegalArgumentException("Dependencies cannot be null");
        }
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User RegisterUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public Optional<User> findByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public Optional<User> findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public void deleteUserByUsername(String username){
        userRepo.deleteByUsername(username);
    }


}
