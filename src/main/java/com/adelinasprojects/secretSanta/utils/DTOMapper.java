package com.adelinasprojects.secretSanta.utils;

import com.adelinasprojects.secretSanta.dto.UserDTO;
import com.adelinasprojects.secretSanta.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DTOMapper {
    private final PasswordEncoder passwordEncoder;

    public DTOMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

//    public static User mapDTOToUser(UserDTO userDTO){
//        User user = new User();
//
//    }
}
