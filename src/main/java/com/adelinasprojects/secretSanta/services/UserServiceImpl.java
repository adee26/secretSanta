package com.adelinasprojects.secretSanta.services;

import com.adelinasprojects.secretSanta.dto.UserDTO;
import com.adelinasprojects.secretSanta.entities.User;
import com.adelinasprojects.secretSanta.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createAccount(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }

    @Override
    public boolean login(UserDTO userDTO){
        boolean isLoggedIn = false;
        Optional<User> user = userRepository.findUserByEmail(userDTO.getEmail());
        if(user.isPresent()){
           if(passwordEncoder.matches(userDTO.getPassword(), user.get().getPassword())){
               isLoggedIn = true;
           }
        }
        return isLoggedIn;
    }
}
