package com.adelinasprojects.secretSanta.services;

import com.adelinasprojects.secretSanta.dto.UserDTO;
import com.adelinasprojects.secretSanta.entities.User;

public interface UserService {
    void createAccount(User user);
    boolean login(UserDTO userDTO);
}
